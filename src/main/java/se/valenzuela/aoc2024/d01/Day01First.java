package se.valenzuela.aoc2024.d01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Day01First {

    private List<Long> first = new ArrayList<>();
    private List<Long> second = new ArrayList<>();

    public static void main(String[] args) {
        new Day01First().readFromFile();
    }

    public void readFromFile() {
        try {
            Files.readAllLines(Path.of("src/main/resources/d01-1/input")).forEach(line -> {
                String[] split = line.split("\\s");
                Long firstNumber = Long.valueOf(split[0]);
                Long secondNumber = Long.valueOf(split[3]);

                first.add(firstNumber);
                second.add(secondNumber);
            });

            first = first.stream().sorted().toList();
            second = second.stream().sorted().toList();

            long sum = 0;
            for (int i = 0; i < first.size(); i++) {
                long difference = Math.abs(first.get(i) - second.get(i));
                sum += difference;
            }
            System.out.println("Sum: " + sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
