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
            TwitterAlerte t = new TwitterAlerte(s.getId(),s.getUser().getScreenName(),s.getText(),s.getUser().getProfileImageURL(),s.getCreatedAt());
            Alertes.add(t);
        }
        return Alertes;
    }

    public void updateTweet(String s) {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            twitter.updateStatus(s +"\n#Donation_du_sang #dir_lkhir_tl9ah");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws TwitterException {
        /*TwitterMethods tm = new TwitterMethods();
        tm.updateTweet("donatioooooooooooooooooon");*/
        /*TwitterMethods t = new TwitterMethods();
        for(TwitterAlerte tw: t.getAllTweet()){
            System.out.println(tw);
        }*/

    }
}
