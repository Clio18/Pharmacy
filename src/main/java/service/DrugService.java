package service;

import dao.DrugDAO;
import model.Drug;
import source.MockDrugBase;

import java.util.List;

public class DrugService {

    private DrugDAO drugDAO;


    public List<Drug> getAll() {
        return drugDAO.getAll();
    }

    public Drug findDrugByName(String name){
        return drugDAO.findByName(name);
    }
    public Drug findDrugById(int id){
        return drugDAO.findById(id);
    }

    public List<Drug> getDrugsByPrice(double min, double max) {
        return drugDAO.findDrugsByPrice(min, max);
    }

}
