import java.io.File;

public class Ex_08_GetFolderSize {
    public static void main(String[] args) {

        String pathToFolder = "D:\\Java Advanced - януари 2023\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathToFolder);
        File[] folderFiles = folder.listFiles();
        int folderSize = 0;
        if (folderFiles != null) {
            for (File file : folderFiles) {
                folderSize += file.length();
            }
        }
        System.out.println("Folder size: " + folderSize);
    }
}
