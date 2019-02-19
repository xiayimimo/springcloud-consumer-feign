package com.example.springcloudconsumerfeign.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springcloudproviderconfig.entity.User;

@FeignClient(name = "springcloud-provider-config",fallback = HystrixFeignFallback.class, configuration = MFeignConfig.class)
public interface MFeignClient {

	//这里是使用feign请求的地址
    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    User getUser(@PathVariable("id") String id);

    //新版本支持使用GetMapping，之前的老版本可能不支持
    @GetMapping(value = "/user/list")
    List<User> getUsers();

}
