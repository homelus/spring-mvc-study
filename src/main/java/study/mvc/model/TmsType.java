package study.mvc.model;

import study.core.exception.ArgumentResolverException;

import java.util.Arrays;

public enum TmsType {
    NORMAL("n"),
    RANKING("r"),
    SPECIAL("s");

    private String code;

    TmsType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public boolean isEqual(String code) {
        return this.code.equals(code);
    }

    public static TmsType getTmsType(String code) {
        return Arrays.stream(values())
                .filter(tmsType -> tmsType.isEqual(code))
                .findAny()
                .orElseThrow(ArgumentResolverException::new);
    }
}
