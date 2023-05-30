package com.movie.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes().route(p -> p.path("/movie-booking-service/**").uri("lb://movie-booking-service"))
				.route(p -> p.path("/movie-catalogue-service/**").uri("lb://movie-catalogue-service"))
				.route(p -> p.path("/movie-schedule-service/**").uri("lb://movie-schedule-service")).build();
	}
}