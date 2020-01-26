package Model;

import java.sql.Timestamp;

public class AlerteBesoin {
    private int idAlerte;
    private GroupeSangin GS;
    private int idBS; //banque du sang
    //private int idGS;
    private Timestamp dateAlerte;
    private String descriptionAlerte;
    private boolean enable;

    public AlerteBesoin() {
    }

    public AlerteBesoin(int idAlerte,int idBS, Timestamp dateAlerte, String descriptionAlerte, boolean enable) {
        this.idAlerte = idAlerte;
        this.idBS = idBS;
        this.dateAlerte = dateAlerte;
        this.descriptionAlerte = descriptionAlerte;
        this.enable = enable;
    }

    public int getIdAlerte() {
        return idAlerte;
    }

    public void setIdAlerte(int idAlerte) {
        this.idAlerte = idAlerte;
    }

    public GroupeSangin getGS() {
        return GS;
    }

    public void setGS(GroupeSangin GS) {
        this.GS = GS;
    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    public Timestamp getDateAlerte() {
        return dateAlerte;
    }

    public void setDateAlerte(Timestamp dateAlerte) {
        this.dateAlerte = dateAlerte;
    }

    public String getDescriptionAlerte() {
        return descriptionAlerte;
    }

    public void setDescriptionAlerte(String descriptionAlerte) {
        this.descriptionAlerte = descriptionAlerte;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "***AlerteBesoin{" +
                "\n\tidAlerte=" + idAlerte +
                "\n\tidBS=" + idBS +
                "\n\tidGS=" + GS.getIdGS() +
                "\n\tdateAlerte=" + dateAlerte +
                "\n\tdescriptionAlerte='" + descriptionAlerte + '\'' +
                "\n\tenable=" + enable +
                '}';
    }
}
