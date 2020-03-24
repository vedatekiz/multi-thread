package com.vedat.demo.multithread.camel.route;

import com.vedat.demo.multithread.camel.processor.MultiThreadProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MultiThreadRoute extends RouteBuilder {

    private final MultiThreadProcessor multiThreadProcessor;

    public MultiThreadRoute(MultiThreadProcessor multiThreadProcessor) {
        this.multiThreadProcessor = multiThreadProcessor;
    }

    @Override
    public void configure() throws Exception {
        from("direct:processMultiThread").threads()
                .split(body())
                .parallelProcessing()
                .process(multiThreadProcessor);
    }
}
