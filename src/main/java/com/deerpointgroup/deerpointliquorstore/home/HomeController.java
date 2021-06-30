/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deerpointgroup.deerpointliquorstore.home;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class HomeController implements WebMvcConfigurer {
    
        @Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/login").setViewName("login");
                registry.addViewController("/register").setViewName("register");
                registry.addViewController("/profile").setViewName("profile");
                registry.addViewController("/about").setViewName("about");
			registry.addViewController("/products").setViewName("products");
	}
       
}
