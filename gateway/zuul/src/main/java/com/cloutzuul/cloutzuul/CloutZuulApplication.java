package com.cloutzuul.cloutzuul;

import com.cloutzuul.cloutzuul.Filter.ErrorFilter;
import com.cloutzuul.cloutzuul.Filter.PostFilter;
import com.cloutzuul.cloutzuul.Filter.PreFilter;
import com.cloutzuul.cloutzuul.Filter.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CloutZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloutZuulApplication.class, args);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //TODO Deprecated use new resource
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }

    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }

    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

}
