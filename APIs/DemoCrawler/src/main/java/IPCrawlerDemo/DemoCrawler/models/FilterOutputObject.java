package IPCrawlerDemo.DemoCrawler.models;

import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.FinalOpt;
import IPCrawlerDemo.DemoCrawler.backend.twittercollect.model.OutputObj;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Data
@AllArgsConstructor
public class FilterOutputObject {
    private List<FinalOpt> concepts = new ArrayList<>();

    public FilterOutputObject() {
    }


    public List<FinalOpt> getOutputObjs() {
        return concepts;
    }

    public void setOutputObjs(List<FinalOpt> outputObjs) {
        this.concepts = outputObjs;
    }

    public void add(FinalOpt o){
        concepts.add(o);
    }
}
