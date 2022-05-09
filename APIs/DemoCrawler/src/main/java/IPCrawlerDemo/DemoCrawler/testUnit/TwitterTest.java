package IPCrawlerDemo.DemoCrawler.testUnit;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.GetTweet;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.services.CrawlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TwitterTest {
    CrawlerService crawler;
    CrawlerInputObject input;
    @BeforeEach
    void setUp() {
        crawler = new CrawlerService();
        input = new CrawlerInputObject();
        input.setConcept1("car");
        input.setConcept2("man");
    }
    @Test
    @DisplayName("No data found/Wrong input")
    void testWrongInput() throws IOException {
        assertNotNull(crawler.processInfo(input));
    }
    @Test
    @DisplayName("Has content")
    void testContent(){
        assertEquals(1000,crawler.processInfo(input).size());
    }
    
}
