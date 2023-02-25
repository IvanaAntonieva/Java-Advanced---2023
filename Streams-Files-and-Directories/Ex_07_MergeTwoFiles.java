import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathFileOne = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathFileTwo = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        PrintWriter writer = new PrintWriter("mergedOutput.txt");

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathFileOne));
        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathFileTwo));
        allLinesFileOne.forEach(line -> writer.println(line));
        allLinesFileTwo.forEach(line -> writer.println(line));

        writer.close();
    }
}
