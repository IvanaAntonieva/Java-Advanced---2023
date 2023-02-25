import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_01_SumLines {
    public static void main(String[] args) throws IOException {

        String pathToTheFile  = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(pathToTheFile));

        allLines.forEach(line -> {
                    int sum = 0;
                    for (char symbol : line.toCharArray()) {
                        sum += (int) symbol;
                    }
            System.out.println(sum);
                });
    }
}
