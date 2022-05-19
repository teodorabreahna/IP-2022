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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class FilterLanguages {
    static List<CrawlerOutputObject> tweetObjects = null;

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

    public static void filterJSON() {
        System.out.println("Reading the JSON file, waiting to filter.");
        readJSON();
        try {
            Set<String> dictionary = new HashSet<>(Files.readAllLines(Paths.get("dictionary.txt")));
            //System.out.println(dictionary);
            for (CrawlerOutputObject s : tweetObjects) {
                String copy = s.getText();
                String[] split = copy.split(" |,|\\.");
                int freq = 0;
                for (String word : split) {
                    word = word.toLowerCase(Locale.ROOT);
                    if (!dictionary.contains(word)) {
                        //System.out.println(word + " NOT in dictionary");
                        freq++;
                    }

                    if (freq > s.getText().length()/2) {
                        tweetObjects.remove(s);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("dictionary not found or sth.");
            e.printStackTrace();
        }
        System.out.println("Filtering JSON object.");
        ObjectMapper tweetMapper = new ObjectMapper();
        try {
            System.out.println("Writing to filtered JSON file.");
            tweetMapper.writeValue(new File("output_twitter.json"), tweetObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        filterJSON();
    }

}
