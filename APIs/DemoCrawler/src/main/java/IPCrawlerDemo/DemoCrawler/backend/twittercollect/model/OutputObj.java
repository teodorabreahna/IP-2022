package IPCrawlerDemo.DemoCrawler.backend.twittercollect.model;

import java.util.List;

public class OutputObj {
    private List<String> nouns;
    private List<String> adj;
    private List<String> verb;
    private String topic;

    public OutputObj(List<String> nouns, List<String> adj, List<String> verb, String topic) {
        this.nouns = nouns;
        this.adj = adj;
        this.verb = verb;
        this.topic = topic;
    }

    public List<String> getNouns() {
        return nouns;
    }

    public void setNouns(List<String> nouns) {
        this.nouns = nouns;
    }

    public List<String> getAdj() {
        return adj;
    }

    public void setAdj(List<String> adj) {
        this.adj = adj;
    }

    public List<String> getVerb() {
        return verb;
    }

    public void setVerb(List<String> verb) {
        this.verb = verb;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
