package workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    // Method addExercise(Exercise exercise) –
    // adds an entity to the exercises
    // If there is still space on the workout sheet (exerciseCount).
    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    // Method removeExercise(String name, String muscle) –
    // removes the exercise by given name and muscle,
    // if such exists, and returns boolean.
    public boolean removeExercise(String name, String muscle) {
        return this.exercises.removeIf(e -> e.getName().equals(name) && e.getMuscle().equals(muscle));
    }

    // Method getExercise(String name, String muscle) –
    // returns the exercise with the given name
    // and muscle or null if there is no such exercise.
    public Exercise getExercise(String name, String muscle) {
        return this.exercises.stream()
                             .filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                             .findFirst()
                             .orElse(null);
    }

    // Method getMostBurnedCaloriesExercise() –
    // returns the exercise which is burned the most calories or null if there are no exercises.
    public Exercise getMostBurnedCaloriesExercise() {

        return this.exercises.stream()
                             .max(Comparator.comparingInt(Exercise::getBurnedCalories))
                             .orElse(null);


        //        Exercise exercise = null;
        //        int calories = 0;
        //
        //        if (this.exercises.size() > 0) {
        //            for (Exercise ex : this.exercises) {
        //                if (ex.getBurnedCalories() > calories) {
        //                    calories = ex.getBurnedCalories();
        //                }
        //            }
        //
        //            for (Exercise ex : this.exercises) {
        //                if (ex.getBurnedCalories() == calories) {
        //                    exercise = ex;
        //                    break;
        //                }
        //            }
        //        }
        //
        //        return exercise;
    }

    // Getter getExerciseCount() – returns the number of exercises.
    public int getExerciseCount() {
        return this.exercises.size();
    }

    // getStatistics() – returns a String in the following format:
    //"Workout type: {workout type}
    //Exercise: {Exercise1}
    //Exercise: {Exercise2}
    //(…)"
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s", this.type));

        this.exercises.forEach(exercise -> {
            sb.append(System.lineSeparator());
            sb.append(exercise);
        });

        return sb.toString();
    }
}
