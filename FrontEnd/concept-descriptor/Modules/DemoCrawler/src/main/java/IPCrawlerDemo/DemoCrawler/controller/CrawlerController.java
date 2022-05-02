package IPCrawlerDemo.DemoCrawler.controller;


import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class CrawlerController {

    @GetMapping("/crawl")
    @ResponseBody
    public String execute(@RequestParam String concept, @RequestParam String concept2)
    {
        // http://localhost:8090/crawl?concept=hello&concept2=world
        return "json:{etcc}";
    }


    @GetMapping("/")
    public String e()
    {
        return "THIS IS FROM JAVA DEFAULT";
    }

}
