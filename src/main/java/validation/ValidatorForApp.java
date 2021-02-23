package validation;

import java.util.List;

public interface ValidatorForApp<T> {
    public List<Alerts> validate(T t);
}
