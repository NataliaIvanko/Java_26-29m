package com.company.Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final String DIRECTORY_NAME = "C:\\Java\\Java_26-29m\\HW_File_Reader_Writer_DB";
    public static void main(String[] args) throws IOException {
        //1.               Допустим, у вас есть несколько файлов с именем   *.link (место * – может быть любое имя).
        // В каждом таком файле хранится ссылка или несколько ссылок на файлы в интернете.
        // Каждая ссылка это отдельная строка. Например, так:
        //
        //https://thumb.tildacdn.com/tild3437-3436-4334-a339-613839316538/-/resize/700x/-/format/webp/Frame_19.png
        //
        //https://thumb.tildacdn.com/tild3437-3436-4334-a339-613839316538/-/resize/700x/-/format/webp/Frame_20.png
        //
        // Ваша программа должна сформировать общий список: res.link из всех ссылок из всех доступных в текущей папке проекта файлов *.link
        //
        //В качестве более сложного варианта, можно искать все файлы *.link во всех подпапках начиная с определенной папки
        //
        //Подсказка (можно использовать методы класса java.io.File или, если хотите, методы java.nio.Files)

        getListOfFiles();

    }

    public static void getListOfFiles() throws IOException {

        List<File> filesExtensionLink = new ArrayList<>();

        File[] listOfFiles = new File(DIRECTORY_NAME).listFiles();
        if (listOfFiles.length != 0) {
            try {
                filesExtensionLink = Arrays.stream(listOfFiles)
                        .filter(file -> file.getName().endsWith(".link"))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        List<String> finalResult = new ArrayList<>();
        for (File file : filesExtensionLink) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                finalResult = reader.lines().collect(Collectors.toList());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        writeListOfFilesToANewFile(finalResult);


    }

    public static void writeListOfFilesToANewFile(List<String> finalResult) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("res.link"));

            for (String str : finalResult) {
                try {
                    writer.write(str + System.lineSeparator());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
