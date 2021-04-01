import services.FileService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileService fileService = new FileService();
        List<String> stringList = new ArrayList<>();
        try {
            stringList = fileService.readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(stringList);
        boolean fileCreated = fileService.createFile(stringList);
        if (fileCreated)
            System.out.println("file created");
        else
            System.out.println("Error");
    }
}
