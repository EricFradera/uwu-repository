package cat.tecnocampus.messaging.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

//TODO 1: Security
// Make the security work. There may be missing annotations and tricks
// We want style, users and index.html be accessible for every body and the rest (sendMessage, my/messages) only to authenticated users.
// You'll need this working. So, if you give up ask the lecturer for help
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    private static final String USERS_QUERY = "select username, password, enabled from myuser where username = ?";

    private static final String AUTHORITIES_QUERY = "select username, role from authorities where username = ?";

    public SecurityConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/style/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin() //to use forms (web)

                .and()
                .httpBasic() //to use http headers REST
                .and()

                .rememberMe()
                .tokenValiditySeconds(2419200)
                .key("tecnocampus")

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //needed only when csrf is enabled (as by default is post)
                .logoutSuccessUrl("/"); //where to go when logout is successful

        http
                .csrf().disable()
                .headers()
                .frameOptions().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY);
    }

}
