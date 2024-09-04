package com.cy.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cy.store.mapper")//指定项目中MAPPER接口路径位置，启动时自动加载接口文件
public class StoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(StoreApplication.class, args);
	}

}
