package Model;

import java.sql.Timestamp;

public class Convoi {
    private int idConvoi;
    private String titreConvoi;
    private String desciption;
    private int idBS;  //banque du sang

    public Convoi(int idConvoi, String titreConvoi, String desciption, Timestamp dateConvoi, int idBS) {
        this.idConvoi = idConvoi;
        this.titreConvoi = titreConvoi;
        this.desciption = desciption;
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
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
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
                "\n\tdesciption='" + desciption + '\'' +
                "\n\tidBS=" + idBS +
                '}';
    }
}
