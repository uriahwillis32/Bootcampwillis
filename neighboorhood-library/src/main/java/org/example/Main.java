package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book[] inventory = new Book[20];

        inventory[0] = new Book("Henry Adams", 518645, "48930935", false, "Gone with the Wind");
        inventory[1] = new Book("Jane Austen", 518646, "9780141439518", true, "Pride and Prejudice");
        inventory[2] = new Book("George Orwell", 518647, "9780451524935", true, "1984");
        inventory[3] = new Book("Jake Rowling", 518648, "9780747532743", false, "Harry Potter and the Philosopher's Stone");
        inventory[4] = new Book("F. Scott Fitzgerald", 518649, "9780743273565", true, "The Great Gatsby");
        inventory[5] = new Book("J.R.R. Tolkien", 518650, "9780618260300", false, "The Hobbit");
        inventory[6] = new Book("Harper Lee", 518651, "9780061120084", true, "To Kill a Mockingbird");
        inventory[7] = new Book("Mary Shelley", 518652, "9780486282114", true, "Frankenstein");
        inventory[8] = new Book("Leo Tolstoy", 518653, "9780143035008", false, "War and Peace");
        inventory[9] = new Book("Herman Melville", 518654, "9781503280786", false, "Moby Dick");
        inventory[10] = new Book("Mark Twain", 518655, "9780486280615", true, "The Adventures of Tom Sawyer");
        inventory[11] = new Book("Charlotte Brontë", 518656, "9780142437209", true, "Jane Eyre");
        inventory[12] = new Book("Emily Brontë", 518657, "9780141439556", true, "Wuthering Heights");
        inventory[13] = new Book("Ray Bradbury", 518658, "9781451673319", true, "Fahrenheit 451");
        inventory[14] = new Book("Aldous Huxley", 518659, "9780060850524", false, "Brave New World");
        inventory[15] = new Book("Ernest Hemingway", 518660, "9780684801223", true, "The Old Man and the Sea");
        inventory[16] = new Book("Gabriel García Márquez", 518661, "9780060883287", false, "One Hundred Years of Solitude");
        inventory[17] = new Book("J.D. Salinger", 518662, "9780316769488", true, "The Catcher in the Rye");
        inventory[18] = new Book("Kurt Vonnegut", 518663, "9780385333849", false, "Slaughterhouse-Five");
        inventory[19] = new Book("Miguel de Cervantes", 518664, "9780060934347", true, "Don Quixote");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) See Available Books");
            System.out.println("2) See Checked Out Books");
            System.out.println("3) Check In a Book");
            System.out.println("4) Exit Program");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    displayAvailableBooks(inventory);
                    break;
                case 2:
                    displayCheckedOutBooks(inventory);
                    break;
                case 3:
                    checkInBook(inventory, scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option.");
                    break;
            }
        }
    }

    public static void displayAvailableBooks(Book[] inventory) {
        System.out.println("\nAvailable Books:");
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
            }
        }
    }

    public static void displayCheckedOutBooks(Book[] inventory) {
        System.out.println("\nChecked Out Books:");
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() +
                        " | Title: " + book.getTitle() + " | Checked out to: " + book.getCheckedOutTo());
            }
        }
    }

    public static void checkInBook(Book[] inventory, Scanner scanner) {
        System.out.println("\nEnter the ID of the book you'd like to check in: ");
        int bookID = scanner.nextInt();

        boolean found = false;

        for (Book book : inventory) {
            if (book != null && book.getId() == bookID) {
                found = true;
                book.checkIn(); // <-- uses method from Book class
                break;
            }
        }

        if (!found) {
            System.out.println("Book not found in inventory.");
        }
    }
}
