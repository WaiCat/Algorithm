package Algorithm.LeetCode.Week06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Destination_City {

  public static void main(String[] args) {
    List<List<String>> paths1 = Arrays.asList(
        Arrays.asList("London", "New York"),
        Arrays.asList("New York", "Lima"),
        Arrays.asList("Lima", "Sao Paulo")
    );
    System.out.println("Example 1: " + destCity(paths1)); // "Sao Paulo"

    List<List<String>> paths2 = Arrays.asList(
        Arrays.asList("B", "C"),
        Arrays.asList("D", "B"),
        Arrays.asList("C", "A")
    );
    System.out.println("Example 2: " + destCity(paths2)); // "A"

    List<List<String>> paths3 = List.of(
        Arrays.asList("A", "Z")
    );
    System.out.println("Example 3: " + destCity(paths3)); // "Z"
  }

  public static String destCity(List<List<String>> paths) {
    Set<String> start = new HashSet<>();
    Set<String> end = new HashSet<>();
    for (List<String> path : paths) {
      start.add(path.get(0));
      end.add(path.get(1));
    }

    for (String e : end) {
      if (!start.contains(e)) {
        return e;
      }
    }

    return "";
  }
}
