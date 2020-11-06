package exception;

public class DrugNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Drug not exist";
    }
}
