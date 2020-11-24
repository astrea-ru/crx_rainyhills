package com.crx.test.rainyhills;

import com.crx.test.rainyhills.model.Input;
import com.crx.test.rainyhills.model.Output;
import com.crx.test.rainyhills.service.VolumeCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomcatController {
    private static final Logger logger = LoggerFactory.getLogger(TomcatController.class);

    @Autowired
    private VolumeCalculator calculator;

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @PostMapping("/calculate")
    public Output calculate(@RequestBody Input input){
        logger.info("Input: {}", input.getArray());
        Output o = new Output();
        o.setWaterUnits(calculator.calculate(input.getArray().stream().mapToInt(i->i).toArray()));
        return o;
    }
}