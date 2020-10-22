package service;
import dao.DrugDAO;
import model.Drug;

import java.util.List;

public class DrugService {

private DrugDAO drugDAO;

public List<Drug> getAll(){
    return drugDAO.getAll();
}
public Drug findDrugByName(String name) throws CloneNotSupportedException {
    return drugDAO.findByName(name);
}

public List<Drug> getDrugsByPrice(double min, double max){
 return drugDAO.findDrugsByPrice(min, max);
}

}
