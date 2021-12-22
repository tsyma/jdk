package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

final class Jdk15Test extends Java15SealedClass {
    //  can be :   sealed, non-sealed or final
// take a look to Java15SealedClass
    @Test
    public void records() {
        Java15PersonClass a = new Java15PersonClass("a", 10);
        Java15PersonReccord b = new Java15PersonReccord("b", 10);

        assertThat(a.getAge()).isEqualTo(b.age());
    }

    @Test
    public void sealedClasses() {
        assertThat(new Jdk15Test()).isInstanceOfAny(Java15SealedClass.class);
    }
    @Test
    public void patternMatchingTypeChecks() {
        Object obj ="str";

        //old way
        if (obj instanceof String) {
            String name = (String) obj;
            name.substring(1);
        }

        //new way
        if (obj instanceof String name) {
            name.substring(1);
        }
    }

}



