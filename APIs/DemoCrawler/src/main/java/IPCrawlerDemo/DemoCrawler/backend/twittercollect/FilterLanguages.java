package IPCrawlerDemo.DemoCrawler.backend.twittercollect;

import IPCrawlerDemo.DemoCrawler.models.CrawlerOutputObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FilterLanguages {
        static List<CrawlerOutputObject> tweetObjects = null;

    private static List<CrawlerOutputObject> readJSON() {
        try {
            ObjectMapper tweetMapper = new ObjectMapper();
            tweetObjects = tweetMapper.readValue(new File("output_twitter.json"), new TypeReference<List<CrawlerOutputObject>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tweetObjects;
    }

    public static void filterJSON(){
        System.out.println("Reading the JSON file, waiting to filter.");
        readJSON();
        for(CrawlerOutputObject s: tweetObjects){
            System.out.println("Filtering JSON object.");
            String copy = s.getText();
            byte[] copyBytes = copy.getBytes();
            String asciiEncodedString = new String(copyBytes, StandardCharsets.US_ASCII);
            char questionmark = '�';
            Integer freq = 0;
            for(int i = 0; i<asciiEncodedString.length(); i++){
                if(questionmark == asciiEncodedString.charAt(i))
                    ++freq;
            }
            if(freq>(asciiEncodedString.length())/2){
                tweetObjects.remove(s);
            }
        }
        ObjectMapper tweetMapper = new ObjectMapper();
        try{
            System.out.println("Writing to filtered JSON file.");
            tweetMapper.writeValue(new File("output_twitter.json"), tweetObjects);
        } catch (IOException e){
            e.printStackTrace();
        }
    }



//    public static void main(String args[]){
//        filterJSON();
//    }

}
