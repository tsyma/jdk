package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Jdk12Test {

    @Test
    public void stringIndentDemo() {
        String text = "line 1!\nline 2!".indent(4);

        assertThat(text).isEqualTo("    line 1!\n    line 2!\n");
    }

    @Test
    public void stringTransformDemo() {
        String text = "BlueCat";
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

        assertThat(transformed).isEqualTo("taCeulB");
    }

    @Test
    public void givenIdenticalFiles_thenShouldNotFindMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12");
        Files.writeString(filePath2, "Java 12");

        long mismatch = Files.mismatch(filePath1, filePath2);
        assertThat(mismatch).isEqualTo(-1);
    }

    @Test
    public void givenDifferentFiles_thenShouldFindMismatch() throws IOException {
        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12");
        Files.writeString(filePath4, "Java 12 DIFFERENCE_HERE!!!");

        long mismatch = Files.mismatch(filePath3, filePath4);
        assertThat(mismatch).isEqualTo(7);
    }

    @Test
    public void givenSetOfNumbers_thenCalculateAverage() {
        double mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(
                        Collectors.summingDouble(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count)
                );
        assertThat(mean).isEqualTo(3.0);
    }

}
