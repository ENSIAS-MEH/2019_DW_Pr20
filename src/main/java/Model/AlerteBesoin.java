package Model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AlerteBesoin {
    private int idBS; //banque du sang
    //private List<Integer> listGS = new ArrayList<>(); //liste des groupes de sang
    /* pour l'alert, il vaut mieux spécifier idGS au lieux d'avoir une liste des groupes de sang*/
    private int idGS;
    private Timestamp dateAlerte;
    private String descriptionAlerte;
    private boolean enable;

    public AlerteBesoin(int idBS, int idGS, Timestamp dateAlerte, String descriptionAlerte, boolean enable) {
        this.idBS = idBS;
        this.idGS = idGS;
        this.dateAlerte = dateAlerte;
        this.descriptionAlerte = descriptionAlerte;
        this.enable = enable;
    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    public int getIdGS() {
        return idGS;
    }

    public void setIdGS(int idGS) {
        this.idGS = idGS;
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
}
