package tumblrcollect;


import com.tumblr.jumblr.JumblrClient;

public class Main {
    public static void main(String[] args){
        Connect c = new Connect();
        Collect t = new Collect();
        JumblrClient client = c.newClient();
        //t.getTags(client,"gif"); - have to figure out why it throws the error
        t.followBlog(client,"seejohnrun.tumblr.com");
    }
}
