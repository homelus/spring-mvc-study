package study.mvc.model;

import java.util.StringJoiner;

public class TmsUser {

    private String name;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean startWithTms() {
        return name.startsWith("tms");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TmsUser.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("id='" + id + "'")
                .toString();
    }
}
