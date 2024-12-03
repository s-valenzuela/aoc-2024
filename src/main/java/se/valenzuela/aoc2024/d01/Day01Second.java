package se.valenzuela.aoc2024.d01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day01Second {

    private final List<Long> first = new ArrayList<>();
    private final Map<Long, Long> second = new HashMap<>();

    public static void main(String[] args) {
        new Day01Second().readFromFile();
    }

    public void readFromFile() {
        try {
            Files.readAllLines(Path.of("/home/valenzuela/repositories/aoc-2024/aoc-2024/src/main/resources/d01-2/input1")).forEach(line -> {
                String[] split = line.split("\\s");
                Long firstNumber = Long.valueOf(split[0]);
                Long secondNumber = Long.valueOf(split[3]);

                first.add(firstNumber);
                second.put(secondNumber, second.getOrDefault(secondNumber, 0L) + 1);
            });

            long sum = 0;
            for (Long aLong : first) {
                Long times = second.getOrDefault(aLong, 0L);
                sum += aLong * times;
            }
            System.out.println("Sum: " + sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
