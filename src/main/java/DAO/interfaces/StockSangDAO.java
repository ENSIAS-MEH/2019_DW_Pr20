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

    //La quantité du  sang dans le stock pour chaque BanqueDuSang (Total)
    public int stockPerBanque(int idBS);
    public List<Integer> AllstocStatistic();
    public List<Integer> statsByVille(int idVille);
    public List<Integer> statsByBanque(int idBanque);
}
