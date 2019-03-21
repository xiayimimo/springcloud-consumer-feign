package com.example.springcloudconsumerfeign.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
/*
 * 这里配置了feign的打印日志等级
 */
@Configuration
public class MFeignConfig {
	/*@Bean
	public Contract feignContract() {
		return new feign.Contract.Default();
	}*/
	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
