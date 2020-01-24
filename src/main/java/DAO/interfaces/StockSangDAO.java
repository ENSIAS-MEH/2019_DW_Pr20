package DAO.interfaces;

import Model.StockSang;

import java.util.List;

public interface StockSangDAO {
    public StockSang findStockById(int idBs,int idGS);
    public List<StockSang> findStockByBanqueSang(int idBS);
    public List<StockSang> findStockByGroupSang(int idGS);
    public List<StockSang> findAll();
    public void ajouterStockSang(StockSang stockSang);
    public void updateStockSang(StockSang stockSang);
    public void deleteStockSang(StockSang stockSang);
}
