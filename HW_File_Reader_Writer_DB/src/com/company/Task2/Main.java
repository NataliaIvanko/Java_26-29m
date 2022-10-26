package com.company.Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String FILE_PATH = "file.txt";
    public static void main(String[] args) throws IOException {

            //Предлагаю написать маленькую файловую базу данных - программу для сохранения записей. Запись - это некий текст, который пользователь
            // желает сохранить и ключевое слово (номер, код …..) по которому программа впоследствии должна найти сохраненную запись.
            // Используя вашу программу, пользователь может добавить новую запись, добавить запись к существующему кодовому слову,
            // обновить запись для существующего кодового слова, удалить запись, просмотреть запись соответствующую кодовому слову.
            // Естественно, программа должна сохранять информацию в файле\файлах, чтобы при следующем запуске пользователь мог получить
            // ранее сохраненные записи. Для поиска\идентификации записи пользователь должен будет ввести ключевое слово,
            // которое было введено при сохранении записи. В данной задаче Вы можете самостоятельно выбрать структуру файлов для сохранения записей.

            while (true) {
             //   String dbfile= getConsoleMessage("File name?");
                String command = getConsoleMessage("Enter the command: exit/add/listAll/search/delete/update followed by a code word " +
                        "and the information");
                //   String command = getConsoleMessage("Please enter your code word and the text");
                Boolean exitMode = false;
                switch (command.split(" ")[0]) {
                    case "exit":
                        exitMode = true;
                        break;
                    case "add":
                        writeToFile(command.split(" ", 2)[1] +System.lineSeparator());
                        break;
                    case "update":
                        updateFile(command.split(" ", 2)[1]);
                    case "listAll":
                        readFromFile();
                        break;
                    case "search":
                        System.out.println(searchTheList(command.split(" ")[1]));
                        break;
                    case "delete":
                        deleteFromFile(command.split(" ")[1]);
                        break;
                    default:
                        System.out.println("Invalid input");

                }
                if (exitMode) break;


            }
        }

        public static String getConsoleMessage(String caption) {
            System.out.println(caption);
            return new Scanner(System.in).nextLine();

        }

        public static void readFromFile() {
            List<String> stringList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String textLine;
                while ((textLine = reader.readLine()) != null) {
                    stringList.add(textLine);

                }
                System.out.println(stringList);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void writeToFile(String message) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true))) {
                //  String line = "";

                writer.write(message);
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static void deleteFromFile(String lineToRemove) {
            File inputFile = new File("file.txt");
            File tempFile = new File("temp.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
                 BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                // String lineToRemove;
                String currentLine;
                while ((currentLine = reader.readLine()) != null) {
                    String trimmedLine = currentLine.trim();
                    if (trimmedLine.split(" ")[0].equals(lineToRemove)) continue;
                    writer.write(trimmedLine + System.lineSeparator());
                }

                writer.flush();
                writer.close();
                reader.close();

                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);

                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String searchTheList(String line) throws IOException {
            String res = "";
            Boolean resultFound = false;
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

                String data;
                while ((data = reader.readLine()) != null) {
                    if (data.split(" ")[0].equals(line)) {
                        res = data.split(" ", 2)[1];
                        resultFound = true;
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (!resultFound) res = "not found";

            return res;

        }


        public static void updateFile(String newInfo /*, String fileName*/) {

            File inputFile = new File("file.txt");// we use fileName if we save information in different files
            File tempFile = new File("temp.txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));
                 BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

                String currentLine;
                while ((currentLine = reader.readLine()) != null) {

                    if (currentLine.split(" ")[0].equals(newInfo.split(" ")[0])) {
                        currentLine = newInfo;
                    }
                    writer.write(currentLine + System.lineSeparator());
                }

                writer.flush();
                writer.close();
                reader.close();

                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

