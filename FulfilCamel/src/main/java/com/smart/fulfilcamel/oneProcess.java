/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.fulfilcamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author Administrator
 */
public class oneProcess  implements Processor{

    @Override
    public void process(Exchange exchng) throws Exception {
        System.out.println("oneProcess");
         String str = exchng.getIn().getBody(String.class);//获取post ：raw
        System.out.println(str);
        exchng.getOut().setBody("11111111");
    }
    
}
