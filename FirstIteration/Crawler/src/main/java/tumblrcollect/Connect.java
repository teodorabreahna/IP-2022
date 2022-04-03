package tumblrcollect;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.User;

import java.util.List;

public class Connect {
    public JumblrClient newClient(){

        /**
         * The authentication to the API.
         */

        JumblrClient client = new JumblrClient(
                "uvrLjpdP7LfXWHAoqTx45v3ENsqHFCltnrxrzOKYaNjNmDANXf",
                "HwiVenpfbvcgaIm6SBqo8ZMEm72Ei2OpUXlaaVBs8yQEKijmXQ"
        );
        client.setToken(
                "KVHjWRp4bK1wWEexCXGOo1PVbYceBqSySp8RBSlrf3uoU9G5se",
                "yLVlgy3y0Cd7N56jCoB1RlOjCSnqDbAyR6bAPcRVTo04NCOUEL"
        );
        User user = client.user();
        System.out.println(user.getName());
        return client;
    }
}
