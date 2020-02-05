package DAO.interfaces;

import Model.Admin;
import Model.BanqueSang;

import java.util.List;

public interface BanqueSangDAO {
    public BanqueSang findBanqueSangById(int idBS);
    public BanqueSang findBanqueSangByName(String nomBS);
    public BanqueSang findBanqueSang(String mail, String password);
    public List<BanqueSang> findAllBanqueSang();
    public void ajouterBanqueSang(BanqueSang banqueSang);
    public void updateBanqueSang(BanqueSang banqueSang);
    public void deleteBanqueSang(int idBS);
    public boolean searchBanqueSangByName(String nom);
    public int countBanqueSang();
    public Admin getAdmin(String username, String password);
    public List<BanqueSang> findBanquesByVille(int idVille);
}
