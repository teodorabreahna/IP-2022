package IPCrawlerDemo.DemoCrawler.backend.twittercollect.model;

import java.util.ArrayList;
import java.util.List;

public class FinalOpt{
    private List<OutputObj> concepts = new ArrayList<>();

    public FinalOpt() {
    }

    public FinalOpt(List<OutputObj> outputObjs) {
        this.concepts = outputObjs;
    }

    public List<OutputObj> getOutputObjs() {
        return concepts;
    }

    public void setOutputObjs(List<OutputObj> outputObjs) {
        this.concepts = outputObjs;
    }

    public void add(OutputObj o){
        concepts.add(o);
    }
}
