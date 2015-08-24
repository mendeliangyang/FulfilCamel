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
public class ExceptionHandle implements Processor {

    @Override
    public void process(Exchange exchng) throws Exception {
        // the caused by exception is stored in a property on the exchange
        Throwable caused = exchng.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
//        assertNotNull(caused);
        System.err.println(caused);
        exchng.getOut().setBody("error occur:" + caused.getLocalizedMessage());
        // here you can do what you want, but Camel regard this exception as handled, and
        // this processor as a failurehandler, so it wont do redeliveries. So this is the
        // end of this route. But if we want to route it somewhere we can just get a
        // producer template and send it.

        // send it to our mock endpoint
        //exchng.getContext().createProducerTemplate().send("mock:myerror", exchng);
    }

}
