package com.vedat.demo.multithread.controller;

import com.vedat.demo.multithread.boundry.CamelOperation;
import com.vedat.demo.multithread.boundry.MultiThreadOperationContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/camel")
public class CamelController {

    private final ProducerTemplate producerTemplate;

    @Autowired
    public CamelController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @RequestMapping("/start-process/{listSize}")
    public ResponseEntity<Long> multiThread(@PathVariable("listSize") Integer listSize) {
        MultiThreadOperationContext context = new MultiThreadOperationContext(new CamelOperation(producerTemplate));
        return ResponseEntity.ok(context.executeMultiThreadOperation(listSize));
    }
}
