package com.example.controller;

import com.example.Services.DataProcessingService;
import com.example.models.DataProcessingInputObject;
import com.example.models.DataProcessingOutputObject;

import org.springframework.web.bind.annotation.*;
import com.example.*;
import java.util.List;

@CrossOrigin
@RestController
public class DataProcessingController {

    DataProcessingService dataProcessingService = new DataProcessingService();

    @PostMapping("/dataprocessing")
    @ResponseBody
    public List<DataProcessingOutputObject> execute(@RequestBody List<DataProcessingInputObject> dataProcessingInputObject)
    {
        // http://localhost:8090/crawl?concept=hello&concept2=world

        return dataProcessingService.processInfo(dataProcessingInputObject);
    }

    @GetMapping("hello")
    public String sayHello()
    {
        return "HELLO";
    }

}
