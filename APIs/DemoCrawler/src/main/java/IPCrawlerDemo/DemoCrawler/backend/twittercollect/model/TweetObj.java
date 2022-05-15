package IPCrawlerDemo.DemoCrawler.backend.twittercollect.model;

public class TweetObj {
    private String user;
    private String text;
    private String topic;

    public TweetObj(String user, String text, String topic) {
        this.user = user;
        this.text = text;
        this.topic = topic;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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