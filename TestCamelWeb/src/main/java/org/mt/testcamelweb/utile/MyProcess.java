/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mt.testcamelweb.utile;

import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Administrator
 */
public class MyProcess implements Processor {
    
    @Override
    public void process(Exchange exchng) throws Exception {
        String str = exchng.getIn().getBody(String.class);
        System.out.println(str);
        //  exchng.getOut().removeHeaders("CamelHttp*"); //在process中也可以去掉 camle路由头信息
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> inMap = objectMapper.readValue(str, Map.class);
        
        exchng.getOut().setHeader(ParamKeyDefinition.ChoiceHeaderRetCodeKey, inMap.get("retCode"));
        
        
        
        exchng.getOut().setBody(String.format("<retCode>%s</retCode>", inMap.get("retCode")));//camle 在路由时去掉了body参数，所以需要手动添加
//        exchng.getOut().setHeader(Exchange.HTTP_QUERY, "hl=en&test=activemq"); //指定请求参数
        // exchng.getOut().setBody("example.json-String.with中文。"); //重新设置body参数
    }
    
}
