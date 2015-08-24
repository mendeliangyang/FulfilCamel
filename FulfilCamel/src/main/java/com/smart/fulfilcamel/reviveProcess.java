/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.fulfilcamel;
import javax.servlet.http.HttpServletRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMessage;

/**
 *
 * @author Administrator
 */
public class reviveProcess implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String str = exchng.getIn().getBody(String.class);//获取post ：raw
        System.out.println(str);
        HttpServletRequest req = exchng.getIn(HttpMessage.class).getRequest();
        String name = req.getParameter("name"); //获取post ：form-data
        System.out.println(name);
//        exchng.getOut().removeHeaders("CamelHttp*"); //在process中也可以去掉 camle路由头信息
        exchng.getOut().setHeader(Exchange.HTTP_METHOD, "POST"); //指定请求的方式
        exchng.getOut().setBody(str);//camle 在路由时去掉了body参数，所以需要手动添加
//        exchng.getOut().setHeader(Exchange.HTTP_QUERY, "hl=en&test=activemq"); //指定请求参数
       // exchng.getOut().setBody("example.json-String.with中文。"); //重新设置body参数
    }

}
