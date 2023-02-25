import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex_04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));

        int vowelsCount = 0;
        int otherSymbolsCount = 0;
        int punctuationCount = 0;

        Set<Character> vowels = getVowels();
        Set<Character> punctuationMarks = getPunctMarks();

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' ') {
                    continue;
                }
                if(vowels.contains(currentSymbol)) {
                    vowelsCount++;
                } else if (punctuationMarks.contains(currentSymbol)) {
                    punctuationCount++;
                } else {
                    otherSymbolsCount++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_4_countchartypes"));
        writer.write("Vowels: " + vowelsCount);
        writer.newLine();
        writer.write("Other symbols: " + otherSymbolsCount);
        writer.newLine();
        writer.write("Punctuation: " + punctuationCount);
        writer.close();
    }

    private static Set<Character> getPunctMarks() {
        Set<Character> punctMarks = new HashSet<>();
        punctMarks.add('.');
        punctMarks.add('?');
        punctMarks.add('!');
        punctMarks.add(',');
        return punctMarks;
    }

    private static Set<Character> getVowels() {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
