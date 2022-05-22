package IPCrawlerDemo.DemoCrawler.backend.crawlerprocessing;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.FinalOpt;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.OutputObj;
import IPCrawlerDemo.DemoCrawler.models.FilterOutputObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TextProcesser {
    public FinalOpt process(String[] text, String topic) {
        ObjectMapper mapper = new ObjectMapper();
        FinalOpt opt = new FinalOpt();
        try {
            SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
            String[] tokens={""};
            for(int i=0;i< text.length;i++) {

                if(text[i]!=null) {
                    String[] tok = tokenizer.tokenize(text[i]);
                    tokens = ArrayUtils.addAll(tokens, tok);
                }
            }
            InputStream inputStreamPOSTagger = new FileInputStream("en-pos-maxent.bin");
            POSModel posModel = new POSModel(inputStreamPOSTagger);
            POSTaggerME posTagger = new POSTaggerME(posModel);

            List<String> nouns = new ArrayList<>();
            List<String> verbs = new ArrayList<>();
            List<String> adjectives = new ArrayList<>();

            for(int i =0;i<tokens.length;i++)
            {
                tokens[i]=tokens[i].replaceAll("[^a-zA-Z0-9]" ,"");
            }
            for(int i =0;i<tokens.length;i++)
            {
                if(tokens[i].contains(""))
                {
                    ArrayUtils.removeElement(tokens, tokens[i]);
                }
            }

            for (String s : tokens) {
                String[] copy = new String[1];
                copy[0] = s;
                String[] tag;
                      tag = posTagger.tag(copy);
                switch (tag[0]) {
                    case "NN" : nouns.add(s);
                    case "NNP": nouns.add(s);
                    case "VB" : verbs.add(s);
                    case "VBD": verbs.add(s);
                    case "VBZ": verbs.add(s);
                    case "VBG": verbs.add(s);
                    case "VBN": verbs.add(s);
                    case "JJ" : adjectives.add(s);
                }
            }
            OutputObj nounsObj = new OutputObj(nouns, topic,"nouns");
            OutputObj adjObj = new OutputObj(adjectives,topic,"adjectives");
            OutputObj vrbObj = new OutputObj(verbs, topic, "verbs");
            opt.add(nounsObj);
            opt.add(adjObj);
            opt.add(vrbObj);
            mapper.writeValue(new File("pos.json"),opt);
            return opt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TextProcesser n = new TextProcesser();
       // n.process("In Europe, “rewilding” is aiding the reintroduction of key animal species, including bison. Visitors to the forests and meadows of western Romania are helping to track the new species.", "Romania");
    }
}
