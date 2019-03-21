package com.example.springcloudconsumerfeign.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcloudconsumerfeign.client.MFeignClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import springcloudproviderconfig.entity.User;


@Api("springcloud consumer user 控制器")
@RequestMapping("user")
@RestController
public class UserController {
	@Autowired
    private MFeignClient feignClient;

    /**
     * @param id
     * @return
     */
    @ApiOperation(value = "根据用户id查询用户信息", httpMethod = "GET", produces = "application/json")
    @ApiResponse(code = 200, message = "success", response = User.class)
    @GetMapping("{id}")
    public User getUser(@ApiParam(name = "id",   required = true, value = "用户Id") @PathVariable String id) {
        User user = feignClient.getUser(id);
        return user;
    }


    @GetMapping("list")
    public List<User> users(HttpServletRequest request) {
        try {
            List<User> users = feignClient.getUsers();
            return users == null ? new ArrayList<User>() : users;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
