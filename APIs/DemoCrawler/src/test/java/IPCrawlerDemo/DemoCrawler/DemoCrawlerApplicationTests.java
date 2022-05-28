package IPCrawlerDemo.DemoCrawler;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.FilterLanguages;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.GetTweet;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import IPCrawlerDemo.DemoCrawler.services.CrawlerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ResponseBody
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
class DemoCrawlerApplicationTests {

	CrawlerService crawler;
	CrawlerInputObject input;
	FilterLanguages filter;

	GetTweet tweet;

	@BeforeEach
	void setUp() {
		crawler = new CrawlerService();
		input = new CrawlerInputObject();
		filter = new FilterLanguages();
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
       // assertNotEquals(0,crawler.processInfo(input).size());
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

	@Test
	@DisplayName("Filter JSON")
	void filterJSONTest() {
		FilterLanguages.filterJSON();
		assertNotNull(FilterLanguages.getTweetObjects());
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

	@Test
	@DisplayName("FilterLanguages")
	void filterLanguagesTest(){
		//String content = String.valueOf(new GetTweet());
		//System.out.println("The length is: " + content.length());
		List<CrawlerOutputObject> beforeFilterObjects = null;
		List<CrawlerOutputObject> afterFilterObjects = null;

		try{
			ObjectMapper beforeFilter = new ObjectMapper();
			beforeFilterObjects = beforeFilter.readValue(new File("output_twitter.json"), new TypeReference<List<CrawlerOutputObject>>() {
			});
			FilterLanguages.filterJSON();

			ObjectMapper afterFilter = new ObjectMapper();
			afterFilterObjects = afterFilter.readValue(new File("output_twitter.json"), new TypeReference<List<CrawlerOutputObject>>() {
			});
		}
		catch(IOException e){
			e.printStackTrace();
		}

		//System.out.println("size before is " + beforeFilterObjects.size());
		//System.out.println("size after is " + afterFilterObjects.size());

		//assertNotEquals(beforeFilterObjects.size(), afterFilterObjects.size());
		assertEquals(beforeFilterObjects.size(), afterFilterObjects.size());





	}

	@Test
	@DisplayName("TextProcessor")
	void textProcessorTest()
	{
		/*
			// Define the topic.
			String topic = "topic";

			// Declare variables for the expected output.
			List<String> correctNouns = new ArrayList<>();
			List<String> correctVerbs = new ArrayList<>();
			List<String> correctAdjectives = new ArrayList<>();

			// Define the expected output.
			correctNouns.add("thisNN");
			correctNouns.add("isNNP");
			correctNouns.add("oneNN");

			correctVerbs.add("uglyVB");
			correctVerbs.add("textVBD");
			correctVerbs.add("andVBZ");
			correctVerbs.add("bigVBG");
			correctVerbs.add("longVBN");
			correctVerbs.add("sameVB");

			correctAdjectives.add("textJJ");
			correctAdjectives.add("forJJ");

			// Create the object for the expected output.
			OutputObj expectedOutput = new OutputObj(correctNouns, correctAdjectives, correctVerbs, topic);

			// Test the function.
			TextProcesser textProcessor;
			OutputObj realOutput = textProcessor.process(["thisNN isNNP uglyVB textVBD andVBZ bigVBG longVBN textJJ", "sameVB forJJ thisJJ oneNN"], "topic");

			// Make the assert.
			assertEquals(expectedOutput, realOutput);
		*/
	}
}
