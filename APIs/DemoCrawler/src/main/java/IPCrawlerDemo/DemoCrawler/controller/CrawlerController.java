package IPCrawlerDemo.DemoCrawler.controller;


import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.OutputObj;
import IPCrawlerDemo.DemoCrawler.services.CrawlerService;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class CrawlerController {

    CrawlerService crawlerService = new CrawlerService();

    @PostMapping("/crawler")
    @ResponseBody
    public List<OutputObj> execute(@RequestBody CrawlerInputObject crawlerInputObject)
    {
        // http://localhost:5000/crawler

        return crawlerService.processInfo(crawlerInputObject);

    }

}
