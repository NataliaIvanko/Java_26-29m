package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WatchServiceHW2 {

    public static final String DIR_PATH = "D:\\TaskFolderTest1\\";
    public static final String mainDirectory = "D:\\";

    public static void main(String[] args) throws IOException {

        moveFilesToAppropriateDir();

    }

    public static void moveFilesToAppropriateDir() throws IOException {
        List<String> files = new ArrayList<>();
        String place = "";
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path directory = Paths.get(DIR_PATH);
        Path mainDir = Paths.get(mainDirectory);
        WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {

            String command = getConsoleMessage("Enter a command: exit to exit the programme, list to get the list of the processed files");
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                Path file = (Path) event.context();
                try {
                    Files.move(Path.of(directory + "\\" + file), Path.of(mainDir + "\\" + checkFileExtension(file.toString()) + "\\" + file));//Если не переношу файл в папку, за которой наблюдает watchS.,
                    // а создаю прямо в ней, то не успеваю переназвать, при создании ошибка -  файл существует в destination папке

                    place = Path.of(mainDir + "\\" + checkFileExtension(file.toString()) + "\\" + file).toString();

                } catch (FileSystemException e) {
                    Files.createDirectory(Paths.get(mainDir + "\\" + checkFileExtension(file.toString())));
                    Files.move(Path.of(directory + "\\" + file), Path.of(mainDir + "\\" + checkFileExtension(file.toString()) + "\\" + file));

                    place = Path.of(mainDir + "\\" + checkFileExtension(file.toString()) + "\\" + file).toString();
                }
            }
            files.add(place);
            Boolean exitMode = false;
            switch (command) {
                case "exit":
                    exitMode = true;
                    break;
                case "list":

                    files.forEach(System.out::println);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            if (exitMode) break;

        }
    }

    public static String checkFileExtension(String name) {
        String fileName = new File(name).getName();
        int index = fileName.lastIndexOf(".");
        return (index == -1) ? "" : fileName.substring(index + 1);
    }

    public static String getConsoleMessage(String caption) {
        System.out.println(caption);
        return new Scanner(System.in).nextLine();

    }
}
