package dao;

import model.Drug;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DrugDAO implements Dao {

    //mock
   private List<Drug> pharmacy = new ArrayList<>();

    @Override
    public Optional get(long id) {
        return Optional.empty();
    }

    @Override
    public List getAll() {
        //should be checked for null
        return pharmacy;
    }

    @Override
    public void save(Object o) {
        if (o.getClass().getSimpleName().equals("Drug")){
            pharmacy.add((Drug) o);
        }
        //if not - error

    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {
        if (o.getClass().getSimpleName().equals("Drug")){
            //if pharmacy has o
            pharmacy.remove(o);
        }
        //if not - error
    }

    public Drug findByName(String name) {
        Drug targetDrug = new Drug();
        for(Drug drug:pharmacy){
            if (drug.getName().equals(name)){
                targetDrug.setAvailable(drug.isAvailable());
                targetDrug.setDescription(drug.getDescription());
                targetDrug.setDosageForm(drug.getDosageForm());
                targetDrug.setManufacturer(drug.getManufacturer());
                targetDrug.setName(drug.getName());
                targetDrug.setPrice(drug.getPrice());
            }
        }
        return targetDrug;

    }

    public List<Drug> findDrugsByPrice(Double min, double max) {
       List <Drug> targetDrugs = new ArrayList<>();
        for(Drug drug:pharmacy){
            if (drug.getPrice()>min&&drug.getPrice()<max){
              targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
