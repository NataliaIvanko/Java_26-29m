package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// У вас в программе создается User (User {String firstName, String lastName, int age,email}). При этом, в конструктор
        // приходит строка вида “John;Lennon;40;lennon@mail.com” Система должна либо создавать объект, либо формировать Exception.
        // При этом, должна быть возможность получить все ошибки, которые привели к не созданию объекта.
        //Например:
        //
        //
        //Некорректный формат строки. В строке не хватает данных
        //Поле не задано (пустое)
        //email имеет неправильный формат: короче 4 символов или не содержит символ @.
        //Поле возраст некорректно
        //В строке больше полей, чем необходимо

        User user1 = new User("John;Lennon;40;lennon@mail.com");
        System.out.println(user1);


    }

}
