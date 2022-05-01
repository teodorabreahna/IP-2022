package tumblrcollect;


import com.tumblr.jumblr.JumblrClient;

public class Main {
    public static void main(String[] args){
        Connect c = new Connect();
        Collect t = new Collect();
        JumblrClient client = c.newClient();
        //t.getTags(client,"gif"); - have to figure out why it throws the error
        System.out.println(t.followBlog(client,"seejohnrun.tumblr.com")); //this follows a blog
        //System.out.println(t.getBlogPosts(client, "seejohnrun.tumblr.com")); - throws error, facepalm
    }
}
