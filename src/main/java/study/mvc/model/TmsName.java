package study.mvc.model;

import java.util.StringJoiner;

public class TmsName {

    private String name;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TmsName.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("title='" + title + "'")
                .toString();
    }
}
