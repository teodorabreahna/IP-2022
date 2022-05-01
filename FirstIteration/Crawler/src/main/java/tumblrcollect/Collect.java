package tumblrcollect;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

public class Collect extends Connect {
    public void getTags(JumblrClient client, String tag){
        for(Post post : client.tagged(tag)){
            post.getId();
        }
    }
    public void followBlog(JumblrClient client, String blogname){
        Blog blog = client.blogInfo(blogname);
        blog.follow();
    }
}
