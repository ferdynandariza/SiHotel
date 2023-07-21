package com.hospitality.SiHotel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {


    @Bean
    public LocaleResolver localeResolver(){
        var session = new SessionLocaleResolver();
        var indonesia = new Locale("id", "ID");
        session.setDefaultLocale(indonesia);
        return session;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Fungsi memanggil fungsi, bukan path
        registry.addViewController("/").setViewName("layout");
        registry.addViewController("/room").setViewName("forward:/room/index");
        registry.addViewController("/inventory").setViewName("forward:/inventory/index");
        registry.addViewController("/room-service").setViewName("forward:/room-service/index");
        registry.addViewController("/reservation").setViewName("forward:/reservation/index");
        registry.addViewController("/booking").setViewName("forward:/booking/index");
        registry.addViewController("/my-room").setViewName("forward:/my-room/index");

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }
}
