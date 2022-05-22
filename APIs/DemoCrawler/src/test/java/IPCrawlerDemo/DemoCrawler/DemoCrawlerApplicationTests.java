package IPCrawlerDemo.DemoCrawler;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.FilterLanguages;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.services.CrawlerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
class DemoCrawlerApplicationTests {

	CrawlerService crawler;
	CrawlerInputObject input;
	FilterLanguages filter;

	@BeforeEach
	void setUp() {
		crawler = new CrawlerService();
		input = new CrawlerInputObject();
		input.setConcept1("car");
		input.setConcept2("man");
	}
	@Test
	@DisplayName("No data found/Wrong input")
	void testWrongInput() {
		assertNotNull(crawler.processInfo(input));
	}

	@Test
	@DisplayName("Has content")
	void testContent(){
        assertNotEquals(0,crawler.processInfo(input).size());
		//assertEquals(1000,crawler.processInfo(input).size());
	}
    @Test
    @DisplayName("Request limit")
    void reqLimit(){
        String[] queries ={"man","woman","car","bike","nike","adidas","mercedes","lexus","iphone","samsung","levi9","beenear","angular","react","gandhi","hitler","java","javascript","facebook","instagram","facebook","twitter","redbull","monster","cola","pepsi"};
        for(int i=0;i< queries.length;i++)
        {

			input.setConcept1(queries[i]);
			input.setConcept2(queries[i+1]);
			assertNotNull(crawler.processInfo(input));
        }
    }
	@Test
	@DisplayName("Empty JSON")
	void blankJson(){
		assertNotNull(FilterLanguages.readJSON());
	}

    /*@Test
	@DisplayName("JSON input is correct")
	void arrayTest() throws IOException {
		ObjectMapper tweetMapper = new ObjectMapper();
		List<CrawlerOutputObject> tweetObjects = null;
		tweetObjects = tweetMapper.readValue(new File("output_twitter.json"), new TypeReference<List<CrawlerOutputObject>>() {
		});
		assertArrayEquals(tweetObjects,FilterLanguages.readJSON());
	}*/
	@Test
	void contextLoads() {
	}

}
