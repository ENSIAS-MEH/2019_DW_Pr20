package Model;

public class Ville {
    private int idVille;
    private String nomVille;

    public Ville() {
    }

    public Ville(int idVille, String nomVille) {
        this.idVille = idVille;
        this.nomVille = nomVille;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "****Ville{" +
                "\n\tidVille=" + idVille +
                "\n\tnomVille='" + nomVille + '\'' +
                '}';
    }
}
