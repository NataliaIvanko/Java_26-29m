package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderEx {
    public static void main(String[] args) throws IOException {

        try (FileReader fileReader = new FileReader("123.txt")) {

            int characters;
            while ((characters = fileReader.read()) != -1) { //-1 - конец текста, когда дойдем до конца, то вернет -1
                System.out.println((char) characters);
            }
        } catch (FileNotFoundException e) { //можем удалить, потому что наследуется от с IO Exc
            //лучше не делать, птотму что если будет иксепшн, то не юудет понятно,
            // где именно exception
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
            /*
        }finally{
            assert fileReader
        }
         этот блок не нужен, джава закрыла ресурс
             */

//Exceptions должны быть все обработаны, должны идти от более детальных к менее детальным
        }
    }
}
