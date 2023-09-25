package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P2SumBytes {

    public static void main(String[] args) {
        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0;

        try (BufferedReader br = Files.newBufferedReader(Path.of(path))) {

            String line = br.readLine();

            while (line != null) {
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }
}
