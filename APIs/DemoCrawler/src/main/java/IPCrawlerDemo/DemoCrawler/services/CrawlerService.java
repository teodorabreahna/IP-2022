package IPCrawlerDemo.DemoCrawler.services;

import IPCrawlerDemo.DemoCrawler.backend.crawlerprocessing.TextProcesser;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.GetTweet;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.OutputObj;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.TweetObj;
import IPCrawlerDemo.DemoCrawler.models.CrawlerInputObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrawlerService {

    public List<OutputObj> processInfo(CrawlerInputObject crawlerInputObject) {

        return doSomeStuff(crawlerInputObject.getConcept1(), crawlerInputObject.getConcept2());
    }

    private List<OutputObj> doSomeStuff(String concept1, String concept2)
    {
        //prelucrati si apelati api-urile etc
        TextProcesser o= new TextProcesser();
        String[] inputs = new String[2];
        inputs[0]=concept1;
        inputs[1]=concept2;
        try {
            GetTweet.main(inputs);
        } catch (IOException e) {
            e.printStackTrace();
        }
           FilterLanguages.filterJSON(); // language filter, comment to remove.

        try{

            ObjectMapper mapper = new ObjectMapper();
            List<TweetObj> finalList=Arrays.asList(mapper.readValue(Paths.get("output_twitter.json").toFile(), TweetObj[].class));
            String[] c1_texts=new String[2000];
            String[] c2_texts=new String[2000];
            int i = 0;
            int j =0;
            for(TweetObj obj:finalList)
            {
                if(obj.getTopic().equals(concept1)){
                    c1_texts[i] = obj.getText();
                                    i++;
                }else if(obj.getTopic().equals(concept2)){
                    c2_texts[j] = obj.getText();
                    j++;
                }

            }
            OutputObj c1_finalopt = o.process(c1_texts,concept1);
            OutputObj c2_finalopt = o.process(c2_texts,concept2);
           List<OutputObj> a = new ArrayList<>();
           a.add(c1_finalopt);
           a.add(c2_finalopt);
           //System.out.println(a);
           return a;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
