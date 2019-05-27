package com.huashu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import util.IdWorker;
import util.JwtUtil;

@SpringBootApplication
@EntityScan("com.huashu.pojo")//扫描实体类
@ComponentScan(basePackages={"com.huashu"})//扫描本项目下的所有类
public class WebMsApplication  {


	public static void main(String[] args) {

		SpringApplication.run(WebMsApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}

	@Bean
	public JwtUtil jwtUtil(){
		return new JwtUtil();
	}

}
