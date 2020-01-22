package Model;

import java.sql.Timestamp;

public class Planning {
    private int idConvoi;
    private int idVille;
    private Timestamp dateConvoi_debut;
    private Timestamp dateConvoi_fin;

    public Planning() {

    }

    public Planning(int idConvoi, int idVille, Timestamp dateConvoi_debut, Timestamp dateConvoi_fin) {
        this.idConvoi = idConvoi;
        this.idVille = idVille;
        this.dateConvoi_debut = dateConvoi_debut;
        this.dateConvoi_fin = dateConvoi_fin;
    }

    public int getIdConvoi() {
        return idConvoi;
    }

    public void setIdConvoi(int idConvoi) {
        this.idConvoi = idConvoi;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public Timestamp getDateConvoi_debut() {
        return dateConvoi_debut;
    }

    public void setDateConvoi_debut(Timestamp dateConvoi_debut) {
        this.dateConvoi_debut = dateConvoi_debut;
    }

    public Timestamp getDateConvoi_fin() {
        return dateConvoi_fin;
    }

    public void setDateConvoi_fin(Timestamp dateConvoi_fin) {
        this.dateConvoi_fin = dateConvoi_fin;
    }
}
