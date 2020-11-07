package dao;

import exception.DrugNotFoundException;
import exception.DrugNotSavedException;
import model.Drug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrugDAO implements Dao<Drug> {
     private List<Drug> drugList = new ArrayList<>();
    private static int counter = 0;

    public DrugDAO() {
    }

    @Override
    public Drug save(Drug drug) {
        if (drug == null) {
            throw new DrugNotSavedException();
        }
        counter++;
        drug.setId(counter);
        drugList.add(drug);
        try {
            return (Drug) drug.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Drug findById(int id) {
        for (Drug drug : drugList) {
            if (drug.getId() == id) {
                try {
                    return (Drug) drug.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<Drug> getAll() {
        List<Drug> pharmacyForRequest = new ArrayList<>();
        for (Drug drug : drugList) {
            try {
                pharmacyForRequest.add((Drug) drug.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return pharmacyForRequest;
    }


    @Override
    public void update(Drug drug) {
        Drug drugForUpdate = null;
        for (Drug d : drugList) {
            if (d.getId() == drug.getId()) {
                drugForUpdate = d;
            }
        }

        if (drugForUpdate == null) {
            throw new DrugNotFoundException();
        }
        drugForUpdate.setName(drug.getName());
        drugForUpdate.setPrice(drug.getPrice());
        drugForUpdate.setManufacturer(drug.getManufacturer());
        drugForUpdate.setDosageForm(drug.getDosageForm());
        drugForUpdate.setDescription(drug.getDescription());
        drugForUpdate.setAvailable(drug.isAvailable());
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Iterator<Drug> iterator = drugList.iterator();
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
        for (Drug drug : drugList) {
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
        for (Drug drug : drugList) {
            if (drug.getPrice() > min && drug.getPrice() < max) {
                targetDrugs.add(drug);
            }
        }
        return targetDrugs;

    }

}
