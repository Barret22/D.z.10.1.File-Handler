package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private final static String BASE_PATH = "files/";

    public String writeFile(String fileName, String fileContent) {
        try (FileWriter fw = new FileWriter(BASE_PATH + fileName + ".txt")) {
            fw.write(fileContent);  // Записываем контент в файл
            return "Success.";
        } catch (IOException e) {
            return "Error writing file: " + e.getMessage();  // В случае ошибки возвращаем сообщение
        }
    }

    public String readFile(String path) {
        try (FileReader reader = new FileReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            int sym;
            while ((sym = reader.read()) != -1) {
                stringBuilder.append((char) sym);  // Читаем символы и добавляем их в StringBuilder
            }
            return stringBuilder.toString();  // Возвращаем прочитанное содержимое
        } catch (IOException ex) {
            return "Error reading file: " + ex.getMessage();  // В случае ошибки выводим сообщение
        }
    }
}

