package IPCrawlerDemo.DemoCrawler.Services;

import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import com.fasterxml.jackson.core.JsonFactoryBuilder;

import java.util.Arrays;

public class CrawlerService {

    public CrawlerOutputObject processInfo(CrawlerInputObject crawlerInputObject) {

        return doSomeStuff(crawlerInputObject.getConcept1(), crawlerInputObject.getConcept2());
    }


    private CrawlerOutputObject doSomeStuff(String concept1, String concept2)
    {
        //prelucrati si apelati api-urile etc

        CrawlerOutputObject crawlerOutputObject = new CrawlerOutputObject("hello", "2", Arrays.asList("E1", "Restantierii") );
        return crawlerOutputObject;
    }
}
