package com.vedat.demo.multithread.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MultiThreadProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Long applicationId = (Long) exchange.getIn().getBody();
        try {
            Thread.sleep(2000);
            System.out.println("Record Processed. Number: " + applicationId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exchange.getIn().setBody(applicationId);

    }
}
