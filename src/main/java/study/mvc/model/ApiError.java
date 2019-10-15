package study.mvc.model;

import java.util.List;

public class ApiError {

    private List<String> errors;

    public ApiError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
