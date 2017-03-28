package me.ffranceschi.controllers;

/**
 * Created by fernando on 20/03/17.
 */
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value="v1/tools")
public class ToolsController {

    @Value(value = "${example.property}")
    String prop;

    @Autowired
    @LoadBalanced
    public RestTemplate restTemplate;

    @RequestMapping(value="/eureka/services",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "teste")
    public String getEurekaServices() {
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://processo/v1/tools/eureka/services",
                        HttpMethod.GET,
                        null, String.class, 1);

        return restExchange.getBody() + prop;
//        return "Oi " + prop;
    }

    public String teste() {
//        throw new RuntimeException();
        return "FallBack";
    }
}