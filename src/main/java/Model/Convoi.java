package Model;

import java.sql.Timestamp;

public class Convoi {
    private int idConvoi;
    private String titreConvoi;
    private String description;
    private int idBS;  //banque du sang

    public Convoi() {

    }

    public Convoi(int idConvoi, String titreConvoi, String desciption, Timestamp dateConvoi, int idBS) {
        this.idConvoi = idConvoi;
        this.titreConvoi = titreConvoi;
        this.description = desciption;
        this.idBS = idBS;
    }

    public int getIdConvoi() {
        return idConvoi;
    }

    public void setIdConvoi(int idConvoi) {
        this.idConvoi = idConvoi;
    }

    public String getTitreConvoi() {
        return titreConvoi;
    }

    public void setTitreConvoi(String titreConvoi) {
        this.titreConvoi = titreConvoi;
    }

    public String getDesciption() {
        return description;
    }

    public void setDesciption(String desciption) {
        this.description = desciption;
    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    @Override
    public String toString() {
        return "***Convoi{" +
                "\n\tidConvoi=" + idConvoi +
                "\n\ttitreConvoi='" + titreConvoi + '\'' +
                "\n\tdesciption='" + description + '\'' +
                "\n\tidBS=" + idBS +
                '}';
    }
}
