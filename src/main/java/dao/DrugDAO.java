package dao;

import model.Drug;
import source.MockDrugBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrugDAO implements Dao<Drug> {
   private MockDrugBase mockDrugBase;

    public DrugDAO(List<Drug> drugs) {
        mockDrugBase = new MockDrugBase();
        this.mockDrugBase.setPharmacy(drugs);

    }

    public MockDrugBase getMockDrugBase() {
        return mockDrugBase;
    }

    public void setMockDrugBase(MockDrugBase mockDrugBase) {
        this.mockDrugBase = mockDrugBase;
    }

    @Override
    public Drug get(int id) throws CloneNotSupportedException {
        Drug targetDrug = new Drug();
        for(Drug drug:mockDrugBase.getPharmacy()){
            if (drug.getId()==id){
                targetDrug = (Drug) drug.clone();
            }
        }
        return targetDrug;
    }

    @Override
    public List getAll() {
        List<Drug> pharmacyForRequest = new ArrayList<>();
        for (Drug drug:mockDrugBase.getPharmacy()){
            pharmacyForRequest.add(drug);
        }
        return pharmacyForRequest;
    }


    @Override
    public void update(Drug drug) {
        for (Drug oldDrug: mockDrugBase.getPharmacy()){
            if (drug.getId()==oldDrug.getId()){
                oldDrug.setName(drug.getName());
                oldDrug.setPrice(drug.getPrice());
                oldDrug.setManufacturer(drug.getManufacturer());
                oldDrug.setDosageForm(drug.getDosageForm());
                oldDrug.setDescription(drug.getDescription());
                oldDrug.setAvailable(drug.isAvailable());
            }
        }

    }

    @Override
    public void delete(int id) {
        Iterator<Drug>iterator = mockDrugBase.getPharmacy().iterator();
        while (iterator.hasNext()){
            int idForRemove = iterator.next().getId();
            if(idForRemove==id){
                iterator.remove();
            }
        }
    }

    @Override
    public void save(Drug drug) {
        mockDrugBase.getPharmacy().add(drug);

    }

    public Drug findByName(String name) throws CloneNotSupportedException {
        Drug targetDrug = new Drug();
        for(Drug drug:mockDrugBase.getPharmacy()){
            if (drug.getName().equals(name)){
               targetDrug = (Drug) drug.clone();
            }
        }
        return targetDrug;

    }

    public List<Drug> findDrugsByPrice(double min, double max) {
       List <Drug> targetDrugs = new ArrayList<>();
        for(Drug drug:mockDrugBase.getPharmacy()){
            if (drug.getPrice()>min&&drug.getPrice()<max){
              targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
