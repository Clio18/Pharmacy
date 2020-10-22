package dao;

import model.Drug;

import java.util.ArrayList;
import java.util.List;

public class DrugDAO implements Dao {

    public DrugDAO() {

    }

    //mock
   private List<Drug> pharmacy = new ArrayList<>();

    @Override
    public Drug get(double id) {
        return null;
    }

    @Override
    public List getAll() {
        List<Drug> pharmacyForRequest = new ArrayList<>();
        for (Drug drug:pharmacy){
            pharmacyForRequest.add(drug);
        }
        return pharmacyForRequest;
    }


    @Override
    public void update(double id) {

    }

    @Override
    public void delete(double id) {

    }

    @Override
    public void save(Drug drug) {

    }


    public Drug findByName(String name) throws CloneNotSupportedException {
        Drug targetDrug = new Drug();
        for(Drug drug:pharmacy){
            if (drug.getName().equals(name)){
               targetDrug = (Drug) drug.clone();
            }
        }
        return targetDrug;

    }

    public List<Drug> findDrugsByPrice(double min, double max) {
       List <Drug> targetDrugs = new ArrayList<>();
        for(Drug drug:pharmacy){
            if (drug.getPrice()>min&&drug.getPrice()<max){
              targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
