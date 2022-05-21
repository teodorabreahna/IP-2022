package IPCrawlerDemo.DemoCrawler.backend.crawlerprocessing;

import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonProcesser {

    static List<CrawlerOutputObject> tweetObjects = null;
    // we will read the current json object here, after it has been created by the main crawler http request
    public static List<CrawlerOutputObject> readJSON() {

        try {
            ObjectMapper tweetMapper = new ObjectMapper();
            tweetObjects = tweetMapper.readValue(new File("output_twitter.json"), new TypeReference<List<CrawlerOutputObject>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tweetObjects;
    }
    // now we will process said object, going from an array of many output objects per tweet, to only one
}
