package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

class Jdk11Test {

    @Test
    public  void stringFunctionsDemo() {
        String multilineString = "BlueCat.lafox.net \n \n provides \n some articles about Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
    }


    @Test
    public void newFileMethods() throws IOException {
        Path tempFile = Files.createTempFile(Path.of("/tmp"), "demo", ".txt");
        Path filePath = Files.writeString(tempFile, "Sample text");
        String fileContent = Files.readString(filePath);
        assertThat(fileContent).isEqualTo("Sample text");
    }

    @Test
    public  void toArrayDemo() {
        List<String> sampleList = List.of("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
    }

}
