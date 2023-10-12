package exam_preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClimbThePeaksExam14Dec2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> peaksQueue = new ArrayDeque<>(Arrays.asList("Vihren",
                                                                  "Kutelo",
                                                                  "Banski Suhodol",
                                                                  "Polezhan",
                                                                  "Kamenitza"));
        Map<String, Integer> peaksToClimb = new LinkedHashMap<>();
        peaksToClimb.put("Vihren", 80);
        peaksToClimb.put("Kutelo", 90);
        peaksToClimb.put("Banski Suhodol", 100);
        peaksToClimb.put("Polezhan", 60);
        peaksToClimb.put("Kamenitza", 70);

        List<String> climbedPeaks = new LinkedList<>();

        Deque<Integer> foodStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
              .map(Integer::parseInt)
              .forEach(foodStack::push);

        Arrays.stream(scanner.nextLine().split(", "))
              .map(Integer::parseInt)
              .forEach(staminaQueue::offer);

        while (!foodStack.isEmpty() && !staminaQueue.isEmpty() && !peaksToClimb.isEmpty()) {
            Integer dailyStamina = staminaQueue.poll();
            Integer dailyFood = foodStack.pop();

            int dailyLevel = dailyFood + dailyStamina;
            String currentPeak = peaksQueue.peek();

            if (dailyLevel >= peaksToClimb.get(currentPeak)) {
                peaksQueue.poll();
                peaksToClimb.remove(currentPeak);
                climbedPeaks.add(currentPeak);
            }
        }

        if (peaksToClimb.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!climbedPeaks.isEmpty()){
            System.out.println("Conquered peaks:");
            climbedPeaks.forEach(System.out::println);
        }
    }
}
