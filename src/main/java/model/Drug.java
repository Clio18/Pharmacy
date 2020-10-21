package model;

public class Drug implements Cloneable {
    private String description;
    private String name;
    private Double price;
    private boolean available;
    public DosageForm dosageForm;
    private String manufacturer;

    public Drug(String description, String name, Double price, boolean available, DosageForm dosageForm, String manufacturer) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.available = available;
        this.dosageForm = dosageForm;
        this.manufacturer = manufacturer;
    }

    public Drug() {
    }

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
