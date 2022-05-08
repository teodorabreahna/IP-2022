package IPCrawlerDemo.DemoCrawler.services;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.GetTweet;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CrawlerService {

    public List<CrawlerOutputObject> processInfo(CrawlerInputObject crawlerInputObject) {

        return doSomeStuff(crawlerInputObject.getConcept1(), crawlerInputObject.getConcept2());
    }

    private List<CrawlerOutputObject> doSomeStuff(String concept1, String concept2)
    {
        //prelucrati si apelati api-urile etc

        String[] inputs = new String[2];
        inputs[0]=concept1;
        inputs[1]=concept2;
        try {
            GetTweet.main(inputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(Paths.get("output_twitter.json").toFile(), CrawlerOutputObject[].class));
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
