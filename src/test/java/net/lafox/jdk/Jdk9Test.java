package net.lafox.jdk;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Jdk9Test {

    @Test
    void immutableCollections() {
        assertThat(Set.of("key1", "key2", "key3")).hasSize(3);
        assertThat(List.of("key1", "key2", "key3")).hasSize(3);
        assertThat(Map.of("key1", "val1", "key2", "val2").values()).hasSize(2);

        assertThrows(UnsupportedOperationException.class, () ->
                Set.of("key1", "key2", "key3").add("AAAAAAAAAA")
        );

    }

    @Test
    void processInformation() {
        ProcessHandle self = ProcessHandle.current();
        long pid = self.pid();
        ProcessHandle.Info procInfo = self.info();

        Optional<String[]> arguments = procInfo.arguments();
        Optional<String> commandLine = procInfo.commandLine();
        Optional<Instant> startTime = procInfo.startInstant();
        Optional<Duration> cpuUsage = procInfo.totalCpuDuration();
    }

    @Test
    void a() {
        List<String> filteredList = List.of(Optional.of("a"), Optional.of("b"))
                .stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
    }

    @Test
    void httpClient() throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        HttpResponse.BodyHandler<Path> bodyHandler = (rspInfo) -> HttpResponse.BodySubscribers
                .ofFile(Paths.get("Jdk9Test.java"));

        HttpClient
                .newHttpClient()
                .sendAsync(request, bodyHandler)
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println);
    }

}
