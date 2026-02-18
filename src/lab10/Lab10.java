package lab10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Lab10 {
    public static void main(String[] args) {
        //task1
        String fileName1 = "test.txt";
        List<String> fileLines = readFileToList(fileName1);
        System.out.println("Содержимое файла:");
        for (String line : fileLines) {
            System.out.println(line);
        }
        //task2
        String fileName2 = "output.txt";
        String message = "Эта строка будет записана в файл";
        writeToFile(fileName2, message);

        //task3
        String resultFile = "merged.txt";
        mergeTwoFiles(fileName1, fileName2, resultFile);

        //task4
        String inputFileName = "merged.txt";
        String outputFileName = "censored.txt";
        processFileWithFilter(inputFileName, outputFileName);
    }

    //task1
    public static List<String> readFileToList(String fileName) {
        Path path = Paths.get(fileName);
        List<String> result = new ArrayList<>();
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return result;
    }

    //task2
    public static void writeToFile(String fileName, String content) {
        Path path = Paths.get(fileName);
        try {
            Files.writeString(path, content);
            System.out.println("Запись в файл " + fileName + " успешно завершена.");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при записи: " + e.getMessage());
        }
    }

    //task3
    public static void mergeTwoFiles(String path1, String path2, String destination) {
        List<String> firstContent = readFileToList(path1);
        List<String> secondContent = readFileToList(path2);
        List<String> mergedList = new ArrayList<>(firstContent);
        mergedList.addAll(secondContent);
        try {
            Files.write(Paths.get(destination), mergedList);
            System.out.println("Файлы успешно склеены в: " + destination);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении результата: " + e.getMessage());
        }
    }

    //task4
    public static void processFileWithFilter(String source, String destination) {
        List<String> originalLines = readFileToList(source);
        List<String> processedLines = new ArrayList<>();
        for (String line : originalLines) {
            String filteredLine = line.replaceAll("[^a-zA-Z0-9а-яА-Я\\s]", "\\$");
            processedLines.add(filteredLine);
        }
        String finalContent = String.join(System.lineSeparator(), processedLines);
        writeToFile(destination, finalContent);
    }
}
