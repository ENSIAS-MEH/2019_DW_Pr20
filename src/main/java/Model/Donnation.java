package Model;

import java.sql.Timestamp;

public class Donnation {
    private int idDonnateur;
    private int idBS; //banque du sang
    private Timestamp dateDonnation;

    public Donnation() {
        super();
    }

    public Donnation(int idDonnateur, int idBS, Timestamp dateDonnation) {
        this.idDonnateur = idDonnateur;
        this.idBS = idBS;
        this.dateDonnation = dateDonnation;
    }

    public int getIdDonnateur() {
        return idDonnateur;
    }

    public void setIdDonnateur(int idDonnateur) {
        this.idDonnateur = idDonnateur;
    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    public Timestamp getDateDonnation() {
        return dateDonnation;
    }

    public void setDateDonnation(Timestamp dateDonnation) {
        this.dateDonnation = dateDonnation;
    }

    @Override
    public String toString() {
        return "***Donnation{" +
                "\n\tidDonnateur=" + idDonnateur +
                "\n\tidBS=" + idBS +
                "\n\tdateDonnation=" + dateDonnation +
                '}';
    }
}
