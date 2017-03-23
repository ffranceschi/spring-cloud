package me.ffranceschi.controllers;

/**
 * Created by fernando on 20/03/17.
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="v1/tools")
public class ToolsController {

    @Value(value = "${example.property}")
    String prop;

    @RequestMapping(value="/eureka/services",method = RequestMethod.GET)
    public String getEurekaServices() {

        return "Oi " + prop;
    }
}