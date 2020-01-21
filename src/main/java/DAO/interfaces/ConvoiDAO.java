package DAO.interfaces;

import Model.Convoi;

import java.util.List;

public interface ConvoiDAO {

    Convoi findConvoiByID(int idConvoi);
    List<Convoi> allConvoi();
    List<Convoi> allConvoiByBanque(int idBS); //List des convoi organisés par un banque
    void addConvoi(Convoi convoi);
    void updateConvoi(Convoi convoi);
    void deleteConvoi(Convoi convoi);

}
