package dao;

import exception.DrugNotFoundException;
import model.Drug;
import source.MockDrugBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrugDAO implements Dao<Drug> {
   private MockDrugBase drugsStorage;

    public DrugDAO(List<Drug> drugs) {
        drugsStorage = new MockDrugBase(drugs);
    }

    public MockDrugBase getDrugsStorage() {
        return drugsStorage;
    }

    public void setDrugsStorage(MockDrugBase drugsStorage) {
        this.drugsStorage = drugsStorage;
    }

    @Override
    public Drug findById(int id) throws CloneNotSupportedException {
        Drug targetDrug = null;
        for(Drug drug: drugsStorage.getPharmacy()){
            if (drug.getId()==id){
                targetDrug = (Drug) drug.clone();
            }
        }
        return targetDrug;
    }

    @Override
    public List getAll() {
        List<Drug> pharmacyForRequest = new ArrayList<>();
        for (Drug drug: drugsStorage.getPharmacy()){
            pharmacyForRequest.add(drug);
        }
        return pharmacyForRequest;
    }


    @Override
    public void update(Drug drug) throws DrugNotFoundException {
        Drug drugForUpdate = null;
        for (Drug d: drugsStorage.getPharmacy()){
            if (drug.getId()==d.getId()){
                d.setName(drug.getName());
                d.setPrice(drug.getPrice());
                d.setManufacturer(drug.getManufacturer());
                d.setDosageForm(drug.getDosageForm());
                d.setDescription(drug.getDescription());
                d.setAvailable(drug.isAvailable());
                drugForUpdate = d;
            }
        }
        if (drugForUpdate==null){
            throw new DrugNotFoundException();
        }
//        for (Drug oldDrug: drugsStorage.getPharmacy()){
//            if (drug.getId()==oldDrug.getId()){
//                oldDrug.setName(drug.getName());
//                oldDrug.setPrice(drug.getPrice());
//                oldDrug.setManufacturer(drug.getManufacturer());
//                oldDrug.setDosageForm(drug.getDosageForm());
//                oldDrug.setDescription(drug.getDescription());
//                oldDrug.setAvailable(drug.isAvailable());
//            }else {
//                throw new DrugNotFoundException();
//            }
//        }

    }

    @Override
    public void delete(int id) {
        Iterator<Drug>iterator = drugsStorage.getPharmacy().iterator();
        while (iterator.hasNext()){
            int idForRemove = iterator.next().getId();
            if(idForRemove==id){
                iterator.remove();
            }
        }
    }

    @Override
    public void save(Drug drug) {
        drugsStorage.getPharmacy().add(drug);

    }

    public Drug findByName(String name) throws CloneNotSupportedException {
        Drug targetDrug = new Drug();
        for(Drug drug: drugsStorage.getPharmacy()){
            if (drug.getName().equals(name)){
               targetDrug = (Drug) drug.clone();
            }
        }
        return targetDrug;

    }

    public List<Drug> findDrugsByPrice(double min, double max) {
       List <Drug> targetDrugs = new ArrayList<>();
        for(Drug drug: drugsStorage.getPharmacy()){
            if (drug.getPrice()>min&&drug.getPrice()<max){
              targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
