package Demo.DemoDataProcessing.controller;


import com.monkeylearn.MonkeyLearnException;
import org.springframework.web.bind.annotation.*;
import Demo.DemoDataProcessing.models.DataProcessingInputObject;
import Demo.DemoDataProcessing.models.DataProcessingOutputObject;
import Demo.DemoDataProcessing.Services.DataProcessingService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@CrossOrigin
@RestController
public class DataProcessingController {

    DataProcessingService dataProcessingService = new DataProcessingService();

    @PostMapping("/dataprocessing")
    @ResponseBody
    public List<DataProcessingOutputObject> execute(@RequestBody List<DataProcessingInputObject> dataProcessingInputObject) throws MonkeyLearnException, IOException {
        // http://localhost:8090/crawl?concept=hello&concept2=world

        return dataProcessingService.processInfo(dataProcessingInputObject);
    }

    @GetMapping("hello")
    public String sayHello()
    {
        return "HELLO";
    }

}
