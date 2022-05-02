package twittercollect;

import com.fasterxml.jackson.databind.ObjectMapper;
import twitter4j.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JSONException, IOException  {
        JSONObject obj = new JSONObject();
        FileWriter file = new FileWriter("output_twitter.json");
        BufferedWriter writer = new BufferedWriter(file);
        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(args[0]);
            QueryResult result;
            int tweet_count=0;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                        if(tweet.getLang().equalsIgnoreCase("en")) {
                            if(!tweet.getText().contains("RT")) {
                                obj.put("user", tweet.getUser().getScreenName());
                                obj.put("tweet", tweet.getText());
                                obj.put("tweet_id",tweet.getId());

                                writer.write(obj.toString());
                                System.out.println("Successfully Copied JSON Object to file...");
                                System.out.println("\nJSON Object: " + obj);
                                writer.write("\n");
                            }
                        }
                }
            tweet_count++;
            } while ((query = result.nextQuery()) != null && tweet_count<3);
            writer.close();
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
    }

