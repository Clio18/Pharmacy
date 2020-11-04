package exception;

public class DrugNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Drug not exist";
    }
}
