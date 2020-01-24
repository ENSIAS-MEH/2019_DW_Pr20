package Model;

public class Admin {
    private int idAdmin;
    private String emailAdmin;
    private String passwordAdmin;

    public Admin() {
    }

    public Admin(int idAdmin, String emailAdmin, String passwordAdmin) {
        this.idAdmin = idAdmin;
        this.emailAdmin = emailAdmin;
        this.passwordAdmin = passwordAdmin;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", emailAdmin='" + emailAdmin + '\'' +
                ", passwordAdmin='" + passwordAdmin + '\'' +
                '}';
    }
}
