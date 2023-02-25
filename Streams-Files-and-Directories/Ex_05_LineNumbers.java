import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_05_LineNumbers {
    public static void main(String[] args) throws IOException {

        String filePath = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        List<String> allLines;
        allLines = Files.readAllLines(Path.of(filePath));

        PrintWriter writer = new PrintWriter("output_line_numbers.txt");
        int lineNumber = 1;
        for (String line : allLines) {
            writer.println(lineNumber + ". " + line);
            lineNumber++;
        }
        writer.close();
    }
}
