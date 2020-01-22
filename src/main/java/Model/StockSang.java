package Model;

public class StockSang {
    private int idBS;  //banque du sang
    private int idGS;  //groupe sangin
    private int quantite;

    public StockSang(int idBS, int idGS, int quantite) {
        this.idBS = idBS;
        this.idGS = idGS;
        this.quantite = quantite;
    }
    public StockSang(){

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "***StockSang{" +
                "\n\tidBS=" + idBS +
                "\n\tidGS=" + idGS +
                "\n\tquantite=" + quantite +
                '}';
    }
}
