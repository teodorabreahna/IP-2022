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
            ArrayList<Query> queries = new ArrayList<>();
            ArrayList<QueryResult> queryResults = new ArrayList<QueryResult>(args.length);
            for (String arg : args) {
                queries.add(new Query(arg));
            }
            for(int i=0;i<queries.size();i++) {
                int k=0;
                System.out.println(queries.get(i));

                do {
                    queryResults.add(twitter.search(queries.get(i)));
                    List<Status> tweets =  queryResults.get(i).getTweets();
                    for (Status tweet : tweets) {
                        if(tweet.getLang().equalsIgnoreCase("en")) {
                            if (!tweet.getText().contains("RT")) {
                                obj.put("topic", args[i]);
                                obj.put("user", tweet.getUser().getScreenName());
                                obj.put("tweets", tweet.getText());
                                writer.write(obj.toString());
                                System.out.println("Successfully Copied JSON Object to File...");
                                System.out.println("\nJSON Object: " + obj);
                                writer.write("\n");
                            }
                        }
                    }
                    k++;
                } while ((queries.set(i,queryResults.get(i).nextQuery()))!= null && k<2);
            }
            writer.close();
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
    }

