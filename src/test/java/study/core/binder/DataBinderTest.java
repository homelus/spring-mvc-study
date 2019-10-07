package study.core.binder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;
import study.core.WebUser;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author playjun
 * @since 2019 10 07
 */
class DataBinderTest {

    @Test
    void defaultBinder() {
        WebUser webUser = new WebUser();
        DataBinder binder = new DataBinder(webUser);

        MutablePropertyValues mpvs = new MutablePropertyValues();
        mpvs.add("id", "orion");
        mpvs.add("name", "lay");
        mpvs.add("age", 21);

        binder.bind(mpvs);

        assertThat(webUser.getId()).isEqualTo("orion");
        assertThat(webUser.getName()).isEqualTo("lay");
        assertThat(webUser.getAge()).isEqualTo(21);
    }

    @Test
    void privateTest() {
        PrivateUser privateUser = new PrivateUser();
        DataBinder binder = new DataBinder(privateUser);

        MutablePropertyValues mpvs = new MutablePropertyValues();
        mpvs.add("id", "orion");
        mpvs.add("name", "lay");

        binder.bind(mpvs);

        assertThat(privateUser.getId()).isEqualTo("orion");
        assertThat(privateUser.getName()).isEqualTo(null);
    }

    private static class PrivateUser {
        private String id;
        private String name;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

}
