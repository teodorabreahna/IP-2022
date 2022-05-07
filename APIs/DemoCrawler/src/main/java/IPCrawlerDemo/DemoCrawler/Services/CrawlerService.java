package IPCrawlerDemo.DemoCrawler.Services;

import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.JSONParserConstants;

import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

public class CrawlerService {

    public List<CrawlerOutputObject> processInfo(CrawlerInputObject crawlerInputObject) {

        return doSomeStuff(crawlerInputObject.getConcept1(), crawlerInputObject.getConcept2());
    }


    private List<CrawlerOutputObject> doSomeStuff(String concept1, String concept2)
    {
        //prelucrati si apelati api-urile etc

       CrawlerOutputObject obj1 = new CrawlerOutputObject("username1","ana are mere :(", "mere");
        CrawlerOutputObject obj2 = new CrawlerOutputObject("username2","ana are pere :(", "pere");
        return Arrays.asList(obj1,obj2);
    }
}
