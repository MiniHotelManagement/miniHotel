//package edu.sjsu.cmpe275Project.configs;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//
///**
// * Created by emy on 11/16/15.
// */
//
//@Configuration
//@ComponentScan
//@EnableWebMvcSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("agent").password("agent").roles("AGENT");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//    }
////
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests().antMatchers("/", "/welcome").permitAll()
////                .antMatchers("/guest/*").permitAll()
////                .antMatchers("/staff/*").access("hasRole('ADMIN') or hasRole('AGENT')")
////                .antMatchers("/staff/room/*").hasRole("ADMIN").and().httpBasic();
////
////
////
////        //super.configure(http);
////    }
//}