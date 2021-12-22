package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Jdk14Test {

    @Test
    public void stringIndentDemo() {
        assertThat(isHolidayOld("FRIDAY")).isEqualTo(isHolidayNew("FRIDAY"));
    }

    private boolean isHolidayOld(String day) {
        boolean isTodayHoliday;
        switch (day) {
            case "MONDAY":
            case "TUESDAY":
            case "WEDNESDAY":
            case "THURSDAY":
            case "FRIDAY":
                isTodayHoliday = false;
                break;
            case "SATURDAY":
            case "SUNDAY":
                isTodayHoliday = true;
                break;
            default:
                throw new IllegalArgumentException("What's a " + day);
        }
        return isTodayHoliday;
    }

    private boolean isHolidayNew(String day) {
        return switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new IllegalArgumentException("What's a " + day);
        };
    }


    @Test
    public void multiline() {
        assertThat("""
                l1; \
                l2;
                l3;
                    """
        ).isEqualTo("l1; l2;\nl3;\n");
    }


    // preview Pattern Matching for instanceof (JEP 305)

}
