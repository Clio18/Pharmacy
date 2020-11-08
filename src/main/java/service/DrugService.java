package service;
import dao.DrugDAO;
import model.Drug;
import java.util.List;

public class DrugService {
    private DrugDAO drugDAO = new DrugDAO();

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

    public void save(Drug drug) {
        drugDAO.save(drug);
    }
}
