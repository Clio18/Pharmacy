package model;

import java.util.Objects;

public class Drug implements Cloneable {
    private String description;
    private String name;
    private Double price;
    private boolean available;
    private DosageForm dosageForm;
    private String manufacturer;
    private int id;


//    public Drug(String description, String name, Double price, boolean available, DosageForm dosageForm, String manufacturer) {
//
//        this.description = description;
//        this.name = name;
//        this.price = price;
//        this.available = available;
//        this.dosageForm = dosageForm;
//        this.manufacturer = manufacturer;
//    }
//
//    public Drug() {
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public DosageForm getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(DosageForm dosageForm) {
        this.dosageForm = dosageForm;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //        this.description = description;
//        this.name = name;
//        this.price = price;
//        this.available = available;
//        this.dosageForm = dosageForm;
//        this.manufacturer = manufacturer;

    public static class Builder{
        Drug drug;
        public Builder(){
            drug = new Drug();
        }
        public Builder withName(String name){
            drug.name=name;
            return this;
        }
        public Builder withDescription(String description){
            drug.description=description;
            return this;
        }
        public Builder withPrice(Double price){
            drug.price=price;
            return this;
        }
        public Builder withAvailable(Boolean available){
            drug.available=available;
            return this;
        }
        public Builder withManufacturer(String manufacturer){
            drug.manufacturer=manufacturer;
            return this;
        }
        public Builder withDosageForm(DosageForm dosageForm){
            drug.dosageForm=dosageForm;
            return this;
        }
        public Drug build(){
            return drug;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return isAvailable() == drug.isAvailable() &&
                getId() == drug.getId() &&
                Objects.equals(getDescription(), drug.getDescription()) &&
                Objects.equals(getName(), drug.getName()) &&
                Objects.equals(getPrice(), drug.getPrice()) &&
                getDosageForm() == drug.getDosageForm() &&
                Objects.equals(getManufacturer(), drug.getManufacturer());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDescription(), getName(), getPrice(), isAvailable(), getDosageForm(), getManufacturer(), getId());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", dosageForm=" + dosageForm +
                ", manufacturer='" + manufacturer + '\'' +
                ", id=" + id +
                '}';
    }
}
