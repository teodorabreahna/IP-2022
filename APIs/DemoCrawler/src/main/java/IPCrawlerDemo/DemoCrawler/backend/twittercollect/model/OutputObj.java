package IPCrawlerDemo.DemoCrawler.backend.twittercollect.model;

import java.util.List;

public class OutputObj {
    private List<String> list;
    private String topic;
    private String partOfSpeech;

    public OutputObj(List<String> list, String topic, String partOfSpeech) {
        this.list = list;
        this.topic = topic;
        this.partOfSpeech = partOfSpeech;
    }

    public OutputObj(List<String> list) {
        this.list = list;
    }

    public OutputObj() {
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }
}
