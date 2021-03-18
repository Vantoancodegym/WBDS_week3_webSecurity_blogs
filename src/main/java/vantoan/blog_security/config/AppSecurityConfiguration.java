package vantoan.blog_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vantoan.blog_security.service.IAppUserService;

@EnableWebSecurity
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAppUserService appUserService;
    //    xac thuc bo nho
    //    @Bean
//    public UserDetailsService userDetailsService(){
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
//        memoryUserDetailsManager.createUser(userBuilder.username("hung").password("123456").roles("USER").build());
//        memoryUserDetailsManager.createUser(userBuilder.username("vohung").password("123456").roles("ADMIN").build());
//        return memoryUserDetailsManager;
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService((UserDetailsService) appUserService).passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/blogs").permitAll()
                .and().authorizeRequests().antMatchers("/blogs/create").hasRole("USER")
                .and().authorizeRequests().antMatchers("/blogs/edit/{id}").hasRole("USER")
                .and().authorizeRequests().antMatchers("/blogs/detail/{id}").permitAll()
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));;
        http.csrf().disable();

    }
}
