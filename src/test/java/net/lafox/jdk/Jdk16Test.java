package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

final class Jdk16Test {

    @Test
    public void dayPeriodSupport() {
        LocalTime date = LocalTime.parse("15:25:08.690791");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h B");

        assertThat(date.format(formatter)).isEqualTo("3 in the afternoon");
    }

    @Test
    public void streamToList() {
        List<String> integersAsString = List.of("1", "2", "3");
        List<Integer> ints = integersAsString.stream().map(Integer::parseInt).toList();

        assertThat(ints).isEqualTo(List.of(1, 2, 3));
    }

   //inner classes in records. Hm...

}



