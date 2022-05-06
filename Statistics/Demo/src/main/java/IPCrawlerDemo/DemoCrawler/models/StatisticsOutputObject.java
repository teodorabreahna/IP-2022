package IPCrawlerDemo.DemoCrawler.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
public class StatisticsOutputObject {
    String concept1;
    String def1;
    String chart1;
    String concept2;
    String def2;
    String chart2;
    List<String> intersect;
    List<String> diferit1;
    List<String> diferit2;

}
