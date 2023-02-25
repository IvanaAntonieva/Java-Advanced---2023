import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_02_SumBytes {
    public static void main(String[] args) throws IOException {

        String pathToTheFile  = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;

        /*List<String> allLines = Files.readAllLines(Path.of(pathToTheFile));
        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        byte[] allBytes = Files.readAllBytes(Path.of(pathToTheFile));
        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
