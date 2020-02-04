package util;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;

public class TwitterMethods {

    public List<TwitterAlerte> getAllTweet() throws TwitterException {
        List<TwitterAlerte> Alertes = new ArrayList<>();
        Twitter twitter = new TwitterFactory().getInstance();
        List<Status> statuts = twitter.getUserTimeline();

        for(Status s : statuts){
            TwitterAlerte t = new TwitterAlerte(s.getId(),s.getUser().getScreenName(),s.getText(),s.getCreatedAt());
            Alertes.add(t);
        }
        return Alertes;
    }

    public static void main(String[] args) throws TwitterException {
        TwitterMethods t = new TwitterMethods();
        for(TwitterAlerte tw: t.getAllTweet()){
            System.out.println(tw);
        }

    }
}
