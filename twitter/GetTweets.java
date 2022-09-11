import java.util.*;
import twitter4j.*;
import twitter4j.conf.*;

public class GetTweets {

	public static void main(String[] args)
	{
		try {
			ConfigurationBuilder	cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("zRhe6vdl6NfWyNyoiSSCw")
			  .setOAuthConsumerSecret("AxXk3sYsxGUQnom3YMOxfxSxWhBlfamBRnnMeQRhXE")
			  .setOAuthAccessToken("22276422-vQdw7Icgc4uHLJEn9ZDSGjqQWzEZfgZlkUCln5XZb")
			  .setOAuthAccessTokenSecret("cxHZCvjfF3hCtmZHrYwerwU96I9cTJYN1g7dRwaySQgXP");

			TwitterFactory	tf = new TwitterFactory(cb.build());
			Twitter			twitter = tf.getInstance();
			int				nTweets = 0;
	
			System.out.println("-- home timeline");
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("Showing home timeline.");
			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" +
						status.getText());
				}

			System.out.printf("%n-- hashtag%n");
			Query query = new Query("q=#obamacare");
			query.count(100);
			QueryResult result = twitter.search(query);
			for (Status status : result.getTweets()) {
				System.out.printf("%-20s%s%n", status.getUser().getScreenName(), status.getText());
				nTweets++;
				}
			System.out.printf("%nretrieved %d tweets%n", nTweets);
		} catch (TwitterException e) {
			System.out.println(e);
		}
	}

}
