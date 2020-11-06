package exception;

public class DrugNotSavedException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Drug not saved";
    }
}
