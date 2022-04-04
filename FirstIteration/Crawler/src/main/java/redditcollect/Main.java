package redditcollect;

import com.github.jreddit.entity.Submission;
import com.github.jreddit.retrieval.Submissions;
import com.github.jreddit.retrieval.params.SubmissionSort;
import com.github.jreddit.utils.restclient.HttpRestClient;
import com.github.jreddit.utils.restclient.RestClient;
import java.util.List;

public class Main {
    public static void main(String []args)
    {
        // Initialize REST Client
        RestClient restClient = new HttpRestClient();
        restClient.setUserAgent("bot/1.0 by name");
        // Connect the user
        // Handle to Submissions, which offers the basic API submission functionality
        Submissions subms = new Submissions(restClient);
        // Retrieve submissions of a submission
        List<Submission> submissionsSubreddit = subms.ofSubreddit("Mans", SubmissionSort.TOP, -1, 100, null, null, true);
        System.out.println(submissionsSubreddit);
    }
}

