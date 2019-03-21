package com.example.springcloudconsumerfeign.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springcloudproviderconfig.entity.User;

/**
 * 断路器回调
 * @author admin
 *
 */
@Component
public class HystrixFeignFallback implements MFeignClient{

	@Override
	public User getUser(String id) {
		 User user = new User();
	        user.setId("233");
	        return user;
	}

	@Override
	public List<User> getUsers() {
		  return new ArrayList<User>();
	}

}
