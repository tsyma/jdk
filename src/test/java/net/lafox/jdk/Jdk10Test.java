package net.lafox.jdk;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class Jdk10Test {

    @Test
    public void copyOfDemo() {
        List<Integer> copyList = List.copyOf(Set.of(1, 2, 3));
        Set<Integer> copySet = Set.copyOf(List.of(1, 2, 3));
        Map<Integer, Object> copyMap = Map.copyOf(Map.of(1, "1", 2, "2"));

        assertThrows(UnsupportedOperationException.class, () ->
                copyList.add(4)
        );
    }


    @Test
    public void orElseThrowDemo() {
        assertThrows(NoSuchElementException.class, () ->
                List.of(1)
                        .stream()
                        .filter(i -> i % 2 == 0)
                        .findFirst()
                        .orElseThrow()
        );
    }

    @Test
    public void toUnmodifiable() {
        ArrayList<String> mutableList = new ArrayList<>();
        mutableList.add("a1");
        List<String> immutableList = mutableList.stream().collect(Collectors.toUnmodifiableList());

        assertThrows(UnsupportedOperationException.class, () ->
                immutableList.add("a2")
        );
    }


}
