public class Drug {
    private String description;
    private Double price;
    private boolean avaliable;
    public DOSAGE_FORM dosage_form;
    private String manufacturer;

    public Drug(String description, Double price, boolean avaliable, DOSAGE_FORM dosage_form, String manufacturer) {
        this.description = description;
        this.price = price;
        this.avaliable = avaliable;
        this.dosage_form = dosage_form;
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

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public DOSAGE_FORM getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(DOSAGE_FORM dosage_form) {
        this.dosage_form = dosage_form;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
