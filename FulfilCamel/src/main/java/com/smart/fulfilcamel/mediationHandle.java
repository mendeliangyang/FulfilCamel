package com.smart.fulfilcamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class mediationHandle implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String str = exchng.getIn().getBody(String.class);//获取post ：raw
        System.out.println(str);
        exchng.getOut().setHeader("order", "1"); //指定请求的方式
        exchng.getOut().setBody("<a>1111</a>", String.class);
        // exchng.getOut().setBody(str);
    }

}
