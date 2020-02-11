package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
@SpringBootApplication
@EnableDubbo
public class SpringbootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTestApplication.class, args);
	}
	@Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public List<?> callHome(){
    	List<?> lists =restTemplate.getForObject("http://127.0.0.1:8989/miya", List.class);
        return lists;
    }
    @RequestMapping("/info")
    public ArrayList<String> info(){
    	ArrayList<String> t=new ArrayList<String>();
    	t.add("1");
    	System.out.println(t.toString());
        return t;

    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
