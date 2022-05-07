package IPCrawlerDemo.DemoCrawler.controller;


import IPCrawlerDemo.DemoCrawler.Services.CrawlerService;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
public class CrawlerController {

    CrawlerService crawlerService = new CrawlerService();

    @PostMapping("/crawl")
    @ResponseBody
    public List<CrawlerOutputObject> execute(@RequestBody CrawlerInputObject crawlerInputObject)
    {
        // http://localhost:8090/crawl?concept=hello&concept2=world

        return crawlerService.processInfo(crawlerInputObject);
    }

}
