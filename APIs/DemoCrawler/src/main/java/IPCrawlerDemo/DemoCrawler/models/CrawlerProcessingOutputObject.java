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
public class CrawlerProcessingOutputObject {
    //{"text":"ana are mere. ana are pere. ana are struguri :(","topic":"fructe"}
    // ana are mere - prop 1; ana are pere - prop 2; ana are struguri :( - prop 3
    String text;
    String topic;


    public CrawlerProcessingOutputObject() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
