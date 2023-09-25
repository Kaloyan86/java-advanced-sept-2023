package streams_files_and_directories;

import java.io.File;

public class P8GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\Kaloyan\\Desktop\\java-advanced-sept-2023\\src\\streams_files_and_directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File directory = new File(path);
        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    size += file.length();
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
