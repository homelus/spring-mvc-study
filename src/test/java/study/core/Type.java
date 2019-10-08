package study.core;

import java.util.Arrays;

/**
 * @author playjun
 * @since 2019 10 07
 */
public enum Type {

    A(1),
    B(2),
    O(3),
    AB(4),
    ;

    private int id;

    Type(int id) {
        this.id = id;
    }

    public boolean match(int id) {
        return this.id == id;
    }

    public static Type convert(int id) {
        return Arrays.stream(Type.values())
                .filter(t -> t.match(id))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
