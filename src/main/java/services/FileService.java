package services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileService {
    public List<String> readFile() throws FileNotFoundException {

        File file = new File(getClass().getResource("/text.txt").getFile());
        StringBuilder stringBuilder = new StringBuilder();
        final String pattern = "\\+\\d\\(\\d{3}\\) \\d{3} \\d{2} \\d{2}";
        Pattern r = Pattern.compile(pattern);
        List<String> resList = new ArrayList<>();

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            br.lines().forEach(stringBuilder::append);
            Matcher m = r.matcher(stringBuilder.toString());
            while (m.find()) {
                resList.add(m.group());
            }
            return resList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resList;
    }

    public boolean createFile(List<String> stringList) {

        File file = new File(System.getProperty("user.dir") + "/result.txt");
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            for (String string : stringList) {
                bw.write(string.replaceAll("[+()<\\[\\]> ]", "") + "\n");
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
