package Model;

public class Donnateur {
    private int idDonnateur;
    private String cin;
    private String nomD;
    private String prenomD;
    private String teleD;
    private String emailD;
    private String passwordD;
    private int idVille;
    private int idGS;   //groupe sangin

    public Donnateur(){
        super();
    }

    public Donnateur(int idDonnateur, String cin, String nomD, String prenomD, String teleD, String emailD, String passwordD, int idVille, int idGS) {
        this.idDonnateur = idDonnateur;
        this.cin = cin;
        this.nomD = nomD;
        this.prenomD = prenomD;
        this.teleD = teleD;
        this.emailD = emailD;
        this.passwordD = passwordD;
        this.idVille = idVille;
        this.idGS = idGS;
    }

    public int getIdDonnateur() {
        return idDonnateur;
    }

    public void setIdDonnateur(int idDonnateur) {
        this.idDonnateur = idDonnateur;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    public String getPrenomD() {
        return prenomD;
    }

    public void setPrenomD(String prenomD) {
        this.prenomD = prenomD;
    }

    public String getTeleD() {
        return teleD;
    }

    public void setTeleD(String teleD) {
        this.teleD = teleD;
    }

    public String getEmailD() {
        return emailD;
    }

    public void setEmailD(String emailD) {
        this.emailD = emailD;
    }

    public String getPasswordD() {
        return passwordD;
    }

    public void setPasswordD(String passwordD) {
        this.passwordD = passwordD;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public int getIdGS() {
        return idGS;
    }

    public void setIdGS(int idGS) {
        this.idGS = idGS;
    }

    @Override
    public String toString() {
        return "****Donnateur{" +
                "\n\tidDonnateur=" + idDonnateur +
                "\n\tcin='" + cin + '\'' +
                "\n\tnomD='" + nomD + '\'' +
                "\n\tprenomD='" + prenomD + '\'' +
                "\n\tteleD='" + teleD + '\'' +
                "\n\temailD='" + emailD + '\'' +
                "\n\tpasswordD='" + passwordD + '\'' +
                "\n\tidVille=" + idVille +
                "\n\tidGS=" + idGS +
                '}';
    }
}
