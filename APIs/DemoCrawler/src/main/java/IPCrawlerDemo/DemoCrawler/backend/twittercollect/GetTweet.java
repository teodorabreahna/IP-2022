package IPCrawlerDemo.DemoCrawler.backend.twittercollect;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.TweetObj;
import com.fasterxml.jackson.databind.ObjectMapper;
import twitter4j.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetTweet {
    public static void main(String[] args) throws  IOException ,RuntimeException{
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<TweetObj> jsonTweets = new ArrayList<>();
        if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            ArrayList<Query> queries = new ArrayList<>();
            ArrayList<QueryResult> queryResults = new ArrayList<>(args.length);
            for (String arg : args) {
                queries.add(new Query(arg));
            }

            for(int i=0;i<queries.size();i++) {
                int k=0;
                System.out.println("Queried:"+queries.get(i).getQuery());
                queryResults.add(twitter.search(queries.get(i)));
                List<Status> allTweets = queryResults.get(i).getTweets();
                List<Status> tweets =  new ArrayList<>();
                do {


                    for (Status tweet : allTweets) {
                        if (tweet.getLang().equalsIgnoreCase("en")) {
                            if (!tweet.getText().contains("RT")) {
                                tweets.add(tweet);
                            }
                        }
                    }
                    for (Status tweet : tweets) {
                        jsonTweets.add(new TweetObj(tweet.getUser().getScreenName(),tweet.getText(),args[i]));
                    }
                    k++;

                } while ((queries.set(i,queryResults.get(i).nextQuery()))!= null && k<5);
                System.out.println("Done writing output for "+args[i]+" in the JSON file.");
            }
            mapper.writeValue(new File("output_twitter.json"),jsonTweets);

        } catch (TwitterException te) {
            TweetObj x = new TweetObj("NULL","NULL","NULL");
            mapper.writeValue(new File("output_twitter.json"),x);
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            //System.exit(-1);
        }catch (RuntimeException te) {
            TweetObj x = new TweetObj("NULL","NULL","NULL");
            mapper.writeValue(new File("output_twitter.json"),x);
            te.printStackTrace();
            System.out.println("error");}
    }
}
