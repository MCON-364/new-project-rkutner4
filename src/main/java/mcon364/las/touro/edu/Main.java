package mcon364.las.touro.edu;

import java.util.List;
import java.util.Optional;

public class Main {

    public static Optional<String> getUserName(String envVarName) {
        String value = System.getenv(envVarName);
        return Optional.ofNullable(value);
    }

    public static String getGreeting(String envVarName) {
        var name  = getUserName(envVarName);
        var sb =  new StringBuilder();
        sb.append("Hello ");
        sb.append(name.orElse("world"));
        return sb.toString();
    }

    public static int processValues(List<List<Integer>> data) {
        int count = 0;
        outerLoop:
        for (var row : data) {
            for (var value : row) {
                if (value == 0) {
                    continue outerLoop;
                }
                if (value == 99) {
                    break outerLoop;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getGreeting("USERNAME"));
        System.out.println(getGreeting("NO_SUCH_VAR"));

        List<List<Integer>> sampleData = List.of(
                List.of(5, 10, 15),
                List.of(20, 0, 25),
                List.of(30, 35, 40),
                List.of(45, 99, 50),
                List.of(55, 60, 65)
        );

        System.out.println("Processed values: " + processValues(sampleData));
    }
}