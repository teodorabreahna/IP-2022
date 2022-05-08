package IPCrawlerDemo.DemoCrawler.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrawlerInputObject {
    private String concept1;
    private String concept2;

    public String getConcept1() {
        return concept1;
    }

    public void setConcept1(String concept1) {
        this.concept1 = concept1;
    }

    public String getConcept2() {
        return concept2;
    }

    public void setConcept2(String concept2) {
        this.concept2 = concept2;
    }
}
