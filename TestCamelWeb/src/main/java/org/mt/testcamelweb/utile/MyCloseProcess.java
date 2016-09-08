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
public class MyCloseProcess implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        String str = exchng.getIn().getBody(String.class);
        System.out.println(str);
        exchng.getOut().setBody("receiveProcessed:" + str);
    }

}
