package dao;

import exception.DrugNotFoundException;
import model.Drug;
import source.MockDrugBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrugDAO implements Dao<Drug> {
    private MockDrugBase drugsStorage;
    static int counter = 0;

    public DrugDAO(List<Drug> drugs) {
        drugsStorage = new MockDrugBase(drugs);
    }

    @Override
    public boolean save(Drug drug) {
        boolean flag = false;
        if (drugsStorage.getPharmacy().isEmpty()){
            drugsStorage.getPharmacy().add(drug);
        } else {
            for (Drug d : drugsStorage.getPharmacy()) {
                if (d.getId() == drug.getId()) {
                    return flag;
                }
            }
            counter++;
            drug.setId(counter);
            drugsStorage.getPharmacy().add(drug);
        }
        flag = true;
        return flag;

    }

    @Override
    public Drug findById(int id) {
        Drug targetDrug = null;

        for (Drug drug : drugsStorage.getPharmacy()) {
            if (drug.getId() == id) {
                try {
                    targetDrug = (Drug) drug.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return targetDrug;
    }

    @Override
    public List<Drug> getAll() {
        List<Drug> pharmacyForRequest = new ArrayList<>();
        for (Drug drug : drugsStorage.getPharmacy()) {
            pharmacyForRequest.add(drug);
        }
        return pharmacyForRequest;
    }


    @Override
    public void update(Drug drug) {
        Drug drugForUpdate = null;
        for (Drug d : drugsStorage.getPharmacy()) {
            if (d.getId() == drug.getId()) {
                drugForUpdate = d;
            }
        }

        if (drugForUpdate != null) {
            drugForUpdate.setName(drug.getName());
            drugForUpdate.setPrice(drug.getPrice());
            drugForUpdate.setManufacturer(drug.getManufacturer());
            drugForUpdate.setDosageForm(drug.getDosageForm());
            drugForUpdate.setDescription(drug.getDescription());
            drugForUpdate.setAvailable(drug.isAvailable());
        } else try {
            throw new DrugNotFoundException();
        } catch (DrugNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Iterator<Drug> iterator = drugsStorage.getPharmacy().iterator();
        while (iterator.hasNext()) {
            int idForRemove = iterator.next().getId();
            if (idForRemove == id) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }


    public Drug findByName(String name) {
        Drug targetDrug = new Drug();
        for (Drug drug : drugsStorage.getPharmacy()) {
            if (drug.getName().equals(name)) {
                try {
                    targetDrug = (Drug) drug.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return targetDrug;

    }

    public List<Drug> findDrugsByPrice(double min, double max) {
        List<Drug> targetDrugs = new ArrayList<>();
        for (Drug drug : drugsStorage.getPharmacy()) {
            if (drug.getPrice() > min && drug.getPrice() < max) {
                targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
