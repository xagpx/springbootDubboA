package com.example.demo;

import org.apache.dubbo.config.annotation.Service;

import com.service.ProviderService;
@Service(version = "1.0.0")
public class ProviderServiceImpl implements ProviderService {
    public String sayHello(String name) {
    	System.out.println("-----------");
        return "Hello "+name;
    }
}