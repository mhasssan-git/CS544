package com.example.blogapigateway;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator routes(
            RouteLocatorBuilder builder,
            AuthenticationPrefilter authFilter) {
        return builder.routes()
                .route("user-service", r -> r.path("/user-service/**")
                        .filters(f ->
                                f.rewritePath("/user-service(?<segment>/?.*)", "$\\{segment}")
                                        .filter(authFilter.apply(
                                                new AuthenticationPrefilter.Config())))
                        .uri("lb://user-service"))
                .route("post-service", r -> r.path("/post-service/**")
                        .filters(f ->
                                f.rewritePath("/post-service(?<segment>/?.*)", "$\\{segment}")
                                        .filter(authFilter.apply(
                                                new AuthenticationPrefilter.Config())))
                        .uri("lb://post-service"))
                .route("comment-service", r -> r.path("/comment-service/**")
                        .filters(f ->
                                f.rewritePath("/comment-service(?<segment>/?.*)", "$\\{segment}")
                                        .filter(authFilter.apply(
                                                new AuthenticationPrefilter.Config())))
                        .uri("lb://comment-service"))
                .build();
    }

}
