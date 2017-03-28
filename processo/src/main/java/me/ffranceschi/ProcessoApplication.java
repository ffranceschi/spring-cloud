package me.ffranceschi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableHystrix
@EnableHystrixDashboard
public class ProcessoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessoApplication.class, args);
	}
}
