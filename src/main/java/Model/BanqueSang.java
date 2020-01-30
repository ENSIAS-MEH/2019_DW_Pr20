package Model;

public class BanqueSang {
    private int idBS;
    private String nomBS;
    private String emailBS;
    private String teleBS;
    private String passwordBS;
    private String adresseBS;
    private int idVille;

    public BanqueSang(int idBS, String nomBS, String emailBS, String teleBS, String passwordBS, String adresseBS, int idVille) {
        this.idBS = idBS;
        this.nomBS = nomBS;
        this.emailBS = emailBS;
        this.teleBS = teleBS;
        this.passwordBS = passwordBS;
        this.adresseBS = adresseBS;
        this.idVille = idVille;
    }

    public BanqueSang(String nomBS, String emailBS, String teleBS, String passwordBS, String adresseBS, int idVille) {
        this.nomBS = nomBS;
        this.emailBS = emailBS;
        this.teleBS = teleBS;
        this.passwordBS = passwordBS;
        this.adresseBS = adresseBS;
        this.idVille = idVille;
    }

    public BanqueSang() {

    }

    public int getIdBS() {
        return idBS;
    }

    public void setIdBS(int idBS) {
        this.idBS = idBS;
    }

    public String getNomBS() {
        return nomBS;
    }

    public void setNomBS(String nomBS) {
        this.nomBS = nomBS;
    }

    public String getEmailBS() {
        return emailBS;
    }

    public void setEmailBS(String emailBS) {
        this.emailBS = emailBS;
    }

    public String getTeleBS() {
        return teleBS;
    }

    public void setTeleBS(String teleBS) {
        this.teleBS = teleBS;
    }

    public String getPasswordBS() {
        return passwordBS;
    }

    public void setPasswordBS(String passwordBS) {
        this.passwordBS = passwordBS;
    }

    public String getAdresseBS() {
        return adresseBS;
    }

    public void setAdresseBS(String adresseBS) {
        this.adresseBS = adresseBS;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    @Override
    public String toString() {
        return "***BanqueSang{" +
                "\n\tidBS=" + idBS +
                "\n\tnomBS='" + nomBS + '\'' +
                "\n\temailBS='" + emailBS + '\'' +
                "\n\tteleBS='" + teleBS + '\'' +
                "\n\tpasswordBS='" + passwordBS + '\'' +
                "\n\tadresseBS='" + adresseBS + '\'' +
                "\n\tidVille=" + idVille +
                '}';
    }
}
