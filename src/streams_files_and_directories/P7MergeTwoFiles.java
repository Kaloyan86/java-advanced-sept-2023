package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P7MergeTwoFiles {

    public static void main(String[] args) {

        String inputPath1 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputPath2 = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String outputPath = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";


        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inputPath1));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inputPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line = reader1.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader1.readLine();
            }

            line = reader2.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader2.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
