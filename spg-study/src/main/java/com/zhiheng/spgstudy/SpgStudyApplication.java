package com.zhiheng.spgstudy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.zhiheng.spgstudy.dao.CoffeeDao;
import com.zhiheng.spgstudy.mapper.CoffeeMapper;

import org.springframework.context.annotation.*;

//
@RestController
@SpringBootApplication
public class SpgStudyApplication implements CommandLineRunner {
	
	private final CoffeeDao coffeedao;
	private final CoffeeMapper coffeemapper;
	
	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpgStudyApplication.class, args);
	}

	public SpgStudyApplication(CoffeeDao coffeedao, CoffeeMapper coffeeMapper) {
		this.coffeedao = coffeedao;
		this.coffeemapper = coffeeMapper;
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(coffeedao.selectCoffee());
	}
}
