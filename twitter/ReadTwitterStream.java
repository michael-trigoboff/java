import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
//import twitter4j.json.DataObjectFactory;

public class ReadTwitterStream
//	implements Runnable
{
	private String		fileName;
	private int			nTweetsRequested;
	private int			nTweetsReceived = 0;
	private String[]	filterKeywords;
	private PrintWriter	out;
	private boolean		stop = false;
	
	void endStream()
	{
		synchronized (this) {
			notify();
			}
	}

	public void run()
	{
		System.out.println(">>> thread starting");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("zRhe6vdl6NfWyNyoiSSCw")
				.setOAuthConsumerSecret(
						"AxXk3sYsxGUQnom3YMOxfxSxWhBlfamBRnnMeQRhXE")
				.setOAuthAccessToken(
						"22276422-vQdw7Icgc4uHLJEn9ZDSGjqQWzEZfgZlkUCln5XZb")
				.setOAuthAccessTokenSecret(
						"cxHZCvjfF3hCtmZHrYwerwU96I9cTJYN1g7dRwaySQgXP");
		cb.setJSONStoreEnabled(true);

		TwitterStream	twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

		StatusListener listener = new StatusListener() {
			public synchronized void onStatus(Status status) {
				if (stop)
					return;
				out.println(status.getText());
				// if you want JSON output instead:
				// out.println(DataObjectFactory.getRawJSON(status));
				if (++nTweetsReceived >= nTweetsRequested) {
					stop = true;
					endStream();
					}
			}

			public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
				System.err.println("status deletion notice id: "
						+ statusDeletionNotice.getStatusId());
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onScrubGeo(long userId, long upToStatusId) {
				System.err.println("scrub_geo event userId: " + userId
						+ " upToStatusId: " + upToStatusId);
			}

			public void onStallWarning(StallWarning warning) {
				System.err.println("stall warning: " + warning);
			}

			public void onException(Exception e) {
				System.err.println("exception: " + e);
				e.printStackTrace();
				endStream();
			}
		};
		
		twitterStream.addListener(listener);
		try {
			out = new PrintWriter(new File(fileName));
			System.out.println("--- stream starting");
			twitterStream.filter(new FilterQuery().track(filterKeywords));
			synchronized (this) {
				System.out.println("--- stream waiting");
				try { this.wait(); } catch (InterruptedException e) { }
				System.out.println("--- stream woke up");
				}
			twitterStream.cleanUp();
			out.close();
			System.out.println("--- stream done");
			}
		catch (IOException e) {
			System.err.println(e);
			}
		System.out.println(">>> thread done");
	}
	
	public static void main(String[] args)
	{
		ReadTwitterStream	rts = new ReadTwitterStream(); 

		rts.fileName = args[0];
		try {
			rts.nTweetsRequested = new Integer(args[1]);
			}
		catch (NumberFormatException e) {
			System.err.println(e);
			return;
			}
		rts.filterKeywords = new String[args.length - 2];
		for (int i = 0; i < rts.filterKeywords.length; i++)
			rts.filterKeywords[i] = args[i + 2];

		rts.run();

		System.out.println("--- main done");
	}
}
