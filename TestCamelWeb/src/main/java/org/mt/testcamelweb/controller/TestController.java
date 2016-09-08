/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mt.testcamelweb.controller;

import java.util.ArrayList;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.spi.RouteContext;
import org.apache.camel.spring.SpringCamelContext;
import org.mt.testcamelweb.utile.MyApplicationContextUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/Test")
public class TestController {

    @RequestMapping(value = "/t1", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getRegisterVerifyCode(@RequestBody String param) throws Exception {
        StringBuffer sb = new StringBuffer(param);
        sb = sb.reverse().append("0000");
        SpringCamelContext context = (SpringCamelContext) MyApplicationContextUtil.getBean("myCoolRoutes");
//        CamelContext context = new DefaultCamelContext(routeDef);
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        Object object = producerTemplate.requestBody("direct:bus1", param, String.class);
        System.out.println(object.toString());
        return sb.toString();
    }
}
