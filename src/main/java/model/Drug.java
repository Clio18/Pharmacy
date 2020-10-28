package model;

public class Drug implements Cloneable {
    private String description;
    private String name;
    private Double price;
    private boolean available;
    public DosageForm dosageForm;
    private String manufacturer;
    private int id;

    public Drug(String description, String name, Double price, boolean available, DosageForm dosageForm, String manufacturer, int id) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.available = available;
        this.dosageForm = dosageForm;
        this.manufacturer = manufacturer;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
