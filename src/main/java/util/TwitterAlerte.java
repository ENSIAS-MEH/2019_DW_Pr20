package util;

import twitter4j.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TwitterAlerte {
    private long IdStatus;
    private String ScreenName;
    private String Status;
    private String UrlImage;
    private Date dateTweet ;

    public TwitterAlerte(long idStatus, String screenName, String status, String urlImage, Date dateTweet) {
        IdStatus = idStatus;
        ScreenName = screenName;
        Status = status;
        UrlImage = urlImage;
        this.dateTweet = dateTweet;
    }

    public TwitterAlerte() {
    }

    public long getIdStatus() {
        return IdStatus;
    }

    public void setIdStatus(long idStatus) {
        IdStatus = idStatus;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String screenName) {
        ScreenName = screenName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getDateTweet() {
        return dateTweet;
    }

    public void setDateTweet(Date dateTweet) {
        this.dateTweet = dateTweet;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }

    @Override
    public String toString() {
        return "TwitterAlerte{" +
                "IdStatus=" + IdStatus +
                ", ScreenName='" + ScreenName + '\'' +
                ", Status='" + Status + '\'' +
                ", UrlImage='" + UrlImage + '\'' +
                ", dateTweet=" + dateTweet +
                '}';
    }
}
