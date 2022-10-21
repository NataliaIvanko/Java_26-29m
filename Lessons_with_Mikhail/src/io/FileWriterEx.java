package io;


import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {


    public static void main(String[] args) throws IOException {
//использовать относительные пути, потому как абсолютные могут быть у всех очень разные
        String s = "The best of the BBC, with the latest news and sport headlines, weather, TV & radio highlights and" +
                " much more from across the whole of BBC Online.";

        String s1 = "!!!!!!!!";

        FileWriter writer = null;
        try{
            writer = new FileWriter("Hey.txt", true);

          /*  for (int i = 0; i < s.length(); i++) {
                writer.write(s.charAt(i));
            }

           */

           writer.write(s1);
            System.out.println("Done!");
        }catch(IOException e){
            throw new RuntimeException(e);
        }finally{

            writer.close();
        }

    }

//try-with-resources - we do not need to close the method
    //в скобках пишем тот ресурс, кторый надо закрывать, потом пишем код. то, что в скобках, джава закрывает сама
}
