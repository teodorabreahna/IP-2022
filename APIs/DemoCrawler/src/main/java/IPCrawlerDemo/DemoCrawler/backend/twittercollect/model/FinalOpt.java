package IPCrawlerDemo.DemoCrawler.backend.twittercollect.model;

import java.util.ArrayList;
import java.util.List;

public class FinalOpt{
    private List<OutputObj> outputObjs = new ArrayList<>();

    public FinalOpt() {
    }

    public FinalOpt(List<OutputObj> outputObjs) {
        this.outputObjs = outputObjs;
    }

    public List<OutputObj> getOutputObjs() {
        return outputObjs;
    }

    public void setOutputObjs(List<OutputObj> outputObjs) {
        this.outputObjs = outputObjs;
    }

    public void add(OutputObj o){
        outputObjs.add(o);
    }
}
