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
 //{"user":"username1","text":"ana are mere :(","topic":"mere"}
    String user;
    String text;
    String topic;
}
