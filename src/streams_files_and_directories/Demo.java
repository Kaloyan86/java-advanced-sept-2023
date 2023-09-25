package streams_files_and_directories;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        /*

        FileInputStream, FileOutputStream - Read and Write byte by byte

        FileReader, FileWriter - Read and Write character by character

        Scanner() - uses InputStream

        PrintWriter -  uses Writer

        BufferedReader, BufferedWriter - uses Reader and Writer

        */

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try(FileInputStream fileInputStream = new FileInputStream(path)) {

            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                System.out.print((char)oneByte);
               // System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
           System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("======= End of byte stream =======");

        try (FileReader fileReader = new FileReader(path)) {

            int asciiCode = fileReader.read();

            while (asciiCode != -1) {
                char symbol = (char) asciiCode;
                System.out.print(symbol);
                asciiCode = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
