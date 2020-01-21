package DAO.interfaces;

import Model.BanqueSang;

import java.util.List;

public interface BanqueSangDAO {
    public BanqueSang findBanqueSangById(int idBS);
    public BanqueSang findBanqueSangByName(String nom);
    public BanqueSang findBanqueSangByEmail(String Email);
    public List<BanqueSang> findAllBanqueSang();
    public void ajouterBanqueSang(BanqueSang banqueSang);
    public void updateBanqueSang(BanqueSang banqueSang);
    public void deleteBanqueSang(int idBS);
    public boolean searchBanqueSangByName(String nom);

}
