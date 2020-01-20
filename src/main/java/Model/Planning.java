package Model;

import java.sql.Timestamp;

public class Planning {
    private int idConvoi;
    private int idVille;
    private Timestamp dateConvoi;

    public Planning(int idConvoi, int idVille, Timestamp dateConvoi) {
        this.idConvoi = idConvoi;
        this.idVille = idVille;
        this.dateConvoi = dateConvoi;
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

    public Timestamp getDateConvoi() {
        return dateConvoi;
    }

    public void setDateConvoi(Timestamp dateConvoi) {
        this.dateConvoi = dateConvoi;
    }

    @Override
    public String toString() {
        return "***Planning{" +
                "\n\tidConvoi=" + idConvoi +
                "\n\tidVille=" + idVille +
                "\n\tdateConvoi=" + dateConvoi +
                '}';
    }
}
