package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AlerteBesoin {
    private int idBS; //banque du sang
    private List<Integer> listGS = new ArrayList<>(); //liste des groupes de sang
    private Timestamp dateAlerte;
    private String descriptionAlerte;
    private boolean enable;

    public AlerteBesoin(int idBS, List<Integer> listGS, Timestamp dateAlerte, String descriptionAlerte, boolean enable) {
        this.idBS = idBS;
        this.listGS = listGS;
        this.dateAlerte = dateAlerte;
        this.descriptionAlerte = descriptionAlerte;
        this.enable=enable;
    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    public List<Integer> getListGS() {
        return listGS;
    }

    public void setListGS(List<Integer> listGS) {
        this.listGS = listGS;
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
                "\n\tidBS=" + idBS +
                "\n\tlistGS=" + listGS +
                "\n\tdateAlerte=" + dateAlerte +
                "\n\tdescriptionAlerte='" + descriptionAlerte + '\'' +
                "\n\tenable=" + enable +
                '}';
    }
}
