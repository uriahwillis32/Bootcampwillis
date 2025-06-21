package org.example;

import org.example.Interface.UserInterface;

public class MainApp {
    public static void main(String[] args) {
        String dbUsername = args[0];
        String dbPassword = args[1];
        String connectionString = "jdbc:mysql://localhost:3306/cardealershipdb";



        UserInterface userInterface = new UserInterface(connectionString,dbUsername,dbPassword);
        userInterface.display();

    }
}