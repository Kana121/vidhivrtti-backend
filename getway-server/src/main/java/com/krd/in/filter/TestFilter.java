package com.krd.in.filter;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
@Configuration
public class TestFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println(exchange.getRequest());
		 ServerHttpRequest request = exchange.getRequest();
		 HttpHeaders headers = request.getHeaders();
		 Set<String> keySet = headers.keySet();
		 keySet.forEach(key->{
			 List<String> list = headers.get(key);
			 System.out.println(list);
		 });
		return chain.filter(exchange);
	}

}
