package tumblrcollect;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;

import java.util.List;

public class Collect extends Connect {
    public void getTags(JumblrClient client, String tag){
        for(Post post : client.tagged(tag)){
            post.getId();
        }
    }
    public String followBlog(JumblrClient client, String blogname){
        Blog blog = client.blogInfo(blogname);
        blog.follow();
        return "I have followed " + blogname;
    }

    public List<Post> getBlogPosts(JumblrClient client, String blogname){
        Blog blog = client.blogInfo(blogname);
        List<Post> posts = blog.posts();
        return posts;
    }
}
