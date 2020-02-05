package Model;

public class GroupeSangin {
    private int idGS;
    private String nomGS;

    public GroupeSangin(int idGS, String nomGS) {
        this.idGS = idGS;
        this.nomGS = nomGS;
    }

    public GroupeSangin() {
    }

    public int getIdGS() {
        return idGS;
    }

    public void setIdGS(int idGS) {
        this.idGS = idGS;
    }

    public String getNomGS() {
        return nomGS;
    }

    public void setNomGS(String nomGS) {
        this.nomGS = nomGS;
    }

    @Override
    public String toString() {
        return "***GroupeSangin{" +
                "\n\tidGS=" + idGS +
                "\n\tnomGS='" + nomGS + '\'' +
                '}';
    }
}
