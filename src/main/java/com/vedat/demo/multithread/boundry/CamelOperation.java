package com.vedat.demo.multithread.boundry;

import com.vedat.demo.multithread.util.Util;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;

import java.util.List;

public class CamelOperation implements MultiThreadOperation {

    private ProducerTemplate producerTemplate;

    public CamelOperation(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @Override
    public void doOperation(int listSize) {
        List<Long> applicationIdList = Util.generateApplicationIdList(listSize);
        List<Long> ids = (List<Long>)producerTemplate.sendBody("direct:processMultiThread", ExchangePattern.InOut, applicationIdList);
    }

    @Override
    public String operationName() {
        return "CAMEL";
    }
}
