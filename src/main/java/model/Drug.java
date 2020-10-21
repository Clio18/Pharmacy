package model;

public class Drug {
    private String description;
    private Double price;
    private boolean available;
    public DosageForm dosageForm;
    private String manufacturer;

    public Drug(String description, Double price, boolean available, DosageForm dosageForm, String manufacturer) {
        this.description = description;
        this.price = price;
        this.available = available;
        this.dosageForm = dosageForm;
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
