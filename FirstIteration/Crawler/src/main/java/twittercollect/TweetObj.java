package twittercollect;

public class TweetObj {
    private String user;
    private String tweet;
    private String topic;

    public TweetObj(String user, String tweet, String topic) {
        this.user = user;
        this.tweet = tweet;
        this.topic = topic;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
