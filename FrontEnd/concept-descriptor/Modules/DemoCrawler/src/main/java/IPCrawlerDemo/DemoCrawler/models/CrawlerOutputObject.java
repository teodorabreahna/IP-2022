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
public class CrawlerOutputObject {
    String param1;
    String integer2;
    List<String> otherObjects;
}
