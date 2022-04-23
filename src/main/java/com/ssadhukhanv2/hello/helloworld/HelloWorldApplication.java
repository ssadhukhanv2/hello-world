package com.ssadhukhanv2.hello.helloworld;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HelloWorldApplication{

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
		//infinite();
	}
	public static void infinite(){

		List list=new ArrayList<Integer>();
		int i=0;
		while (true){
			list.add(Integer.valueOf(Integer.MAX_VALUE));
			if(i>10000){
				list=new ArrayList<Integer>();
				i=0;
			}
			i++;
		}
	}

}
