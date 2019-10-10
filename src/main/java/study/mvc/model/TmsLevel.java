package study.mvc.model;

import study.core.exception.ArgumentResolverException;

import java.util.Arrays;

public enum TmsLevel {
    ION(1),
    BRONZE(2),
    SILVER(3),
    GOLD(4),
    PLATINUM(5),
    DIAMOND(6),
    MASTER(7);

    private int level;

    TmsLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isEqual(int level) {
        return this.level == level;
    }

    public static TmsLevel getTmsLevel(int level) {
        return Arrays.stream(values())
                .filter(tmsLevel -> tmsLevel.isEqual(level))
                .findAny()
                .orElseThrow(ArgumentResolverException::new);
    }
}
