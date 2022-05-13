package IPStatisticsDemo.DemoStatistics.controller;


import IPStatisticsDemo.DemoStatistics.Services.StatisticsService;
import IPStatisticsDemo.DemoStatistics.models.StatisticsInputObject;
import IPStatisticsDemo.DemoStatistics.models.StatisticsOutputObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class StatisticsController {

    StatisticsService statisticsService = new StatisticsService();

    @PostMapping("/stats")
    @ResponseBody
    public StatisticsOutputObject execute(@RequestBody List<StatisticsInputObject> statisticsInputObject)
    {
        // http://localhost:8090/crawl?concept=hello&concept2=world

        return statisticsService.processInfo(statisticsInputObject);
    }

}
