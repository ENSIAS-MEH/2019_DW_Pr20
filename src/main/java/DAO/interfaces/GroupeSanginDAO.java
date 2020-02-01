package DAO.interfaces;

import Model.GroupeSangin;

import java.util.List;

public interface GroupeSanginDAO {

    public GroupeSangin findGroupSanginById(int idGS);
    public GroupeSangin findGroupSanginByName(String name);
    public List<GroupeSangin> findAll();

    public String getGSNameByID(int idGS);

}
