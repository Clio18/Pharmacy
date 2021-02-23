package validation;

public enum Alerts {
    WRONG_NAME("This NAME isn't appropriate"),
    EMPTY_NAME("The value is missed"),
    GOOD("Pass!"),
    WRONG_FAMILY_NAME("This FAMILY NAME isn't appropriate"),
    WRONG_EMAIL("This EMAIL isn't appropriate"),
    WRONG_PHONE_NUMBER("This PHONE NUMBER isn't appropriate"),
    WRONG_USER("USER is empty"),
    WRONG_DRUG_NAME("This NAME for DRUG isn't appropriate"),
    WRONG_DRUG("DRUG is empty");
    private final String name;

    Alerts(String description) {
        name = description;
    }
    //метод для получения значения
    public String getValue() {
        return name;
    }
}
