package IPCrawlerDemo.DemoCrawler.backend.twittercollect;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.TweetObj;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DeleteUsers {

    static ObjectMapper mapper = new ObjectMapper();
    static List<TweetObj> faList;

    static {
        try {
            faList = Arrays.asList(mapper.readValue(Paths.get("output_twitter.json").toFile(), TweetObj[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser() {
     for(TweetObj tobj : faList) {

         StringBuilder atext = new StringBuilder(tobj.getText());
         for (int x = 0; x < atext.length(); x++) {
             if (atext.charAt(x) == '@')
                 while (atext.charAt(x) != ' ') {
                     atext.deleteCharAt(x);
                     x++;
                 }
             //System.out.println(atext);


         }
         tobj.setText(String.valueOf(atext));
     }
    }


}
