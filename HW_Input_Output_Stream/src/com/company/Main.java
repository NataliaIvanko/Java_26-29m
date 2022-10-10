package com.company;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        // По ссылке https://drive.google.com/file/d/1XZrLLuJlHK3n35NwQAnY9t1nSwZ3-piq/view?usp=sharing находится файл file.dat .
        // Ваша задача скачать этот файл (кстати, вы можете сделать это из Java программы, но если сложно можно просто скачать).
        // Ваша программа  должна записать в отдельный файл первые 601 байт, затем в отдельный файл записать следующие 57053 байта
        // и оставшиеся 22494 байта записать в следующий файл. Если все сделано правильно, у вас должно получиться 3 файла.

    writeThreeFiles();

        // The word is excellent

     System.out.println(readAWord("Main.class"));
     System.out.println(readAWord("file2.dat"));
     System.out.println(readAWord("file3.dat"));
     System.out.println(readAWord("pic .gif"));
     System.out.println(readAWord("Cat_pic.jpg"));

    }

    public static void writeThreeFiles() throws IOException {
        try (InputStream is = new BufferedInputStream(new FileInputStream("file.dat"));

             OutputStream os = new BufferedOutputStream(new FileOutputStream("Main.class"));) {
            int count = 0;
            int data;

            while ((data = is.read()) != -1 && count <= 601 ) {
                count++;
                os.write(data);

            }
            os.flush();

            OutputStream os1 = new BufferedOutputStream(new FileOutputStream("file2.dat"));

                while ((data = is.read()) != -1   && count < 57652) {
                    count++;
                    os1.write(data);

                }
                os1.flush();
            OutputStream os2 = new BufferedOutputStream(new FileOutputStream("file3.dat"));

            while ((data = is.read()) != -1) {
                count++;
                os2.write(data);

            }
            os2.flush();

            } catch(IOException e){
                e.printStackTrace();

            }
        }
        //В одном из этих файлов лежит gif картина, в другом jpg картинка, еще в одном скомпилированный .class файл java программы.
    // Вам нужно написать программу, которая определит, в каком файле что лежит.
    // Сделать это можно используя так называемые сигнатуры файлов: gif должен начинаться с шестнадцатеричной  последовательности байт 47 49 46 38 39 61
    // jpeg с последовательности ff= 255 d8 = 216  java .class файл с шестнадцатеричной  последовательности ca fe ba be
    //Сохраните файл, опознанный как .class файл под именем Main.class и запустите его из командной строки. Прочитайте кодовое слово.

    public static String readAWord (String fileName){
       boolean isGif = true;
       boolean isJpeg = true;
       boolean isJava = true;

       String str = "other";

        try {
            InputStream is = new BufferedInputStream(new FileInputStream(fileName));
            int count = 0;
            int data;
            while((data = is.read()) != -1 && count< 6){
                //47 49 46 38 39 61
            //    System.out.println(data);
                if (count == 0){
                    if(data != 71) isGif = false;
                     if(data != 255)  isJpeg = false;
                     if(data != 202) isJava = false;
                }
                if(count == 1){
                    if(data != 73) isGif = false;
                    if(data != 216)  isJpeg = false;
                    if(data != 254) isJava = false;
                }
                if(count == 2){
                    if(data != 70) isGif = false;
                    if(data != 186) isJava = false;
                }
                if(count == 3){
                    if(data != 56) isGif = false;
                    if(data != 190) isJava = false;
                }
                if(count == 4) {
                    if (data != 57) isGif = false;
                }
                if(count == 5) {
                    if (data != 97) isGif = false;
                }
                count++;
                System.out.println(data);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(isJpeg) return "Jpg";
        if(isGif) return "Gif";
        if(isJava)return "Java";
        return str;

    }

        }





