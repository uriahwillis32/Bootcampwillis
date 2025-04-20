package org.example;


    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Book[] inventory = new Book[20];


            Book book0 = new Book("Henry Adams", 518645, "48930935", false, "Gone with the Wind");
            inventory[0] = book0;

            Book book1 = new Book("Jane Austen", 518646, "9780141439518", true, "Pride and Prejudice");
            inventory[1] = book1;

            Book book2 = new Book("George Orwell", 518647, "9780451524935", true, "1984");
            inventory[2] = book2;

            Book book3 = new Book("Jake Rowling", 518648, "9780747532743", false, "Harry Potter and the Philosopher's Stone");
            inventory[3] = book3;

            Book book4 = new Book("F. Scott Fitzgerald", 518649, "9780743273565", true, "The Great Gatsby");
            inventory[4] = book4;

            Book book5 = new Book("J.R.R. Tolkien", 518650, "9780618260300", false, "The Hobbit");
            inventory[5] = book5;

            Book book6 = new Book("Harper Lee", 518651, "9780061120084", true, "To Kill a Mockingbird");
            inventory[6] = book6;

            Book book7 = new Book("Mary Shelley", 518652, "9780486282114", true, "Frankenstein");
            inventory[7] = book7;

            Book book8 = new Book("Leo Tolstoy", 518653, "9780143035008", false, "War and Peace");
            inventory[8] = book8;

            Book book9 = new Book("Herman Melville", 518654, "9781503280786", false, "Moby Dick");
            inventory[9] = book9;

            Book book10 = new Book("Mark Twain", 518655, "9780486280615", true, "The Adventures of Tom Sawyer");
            inventory[10] = book10;

            Book book11 = new Book("Charlotte Brontë", 518656, "9780142437209", true, "Jane Eyre");
            inventory[11] = book11;

            Book book12 = new Book("Emily Brontë", 518657, "9780141439556", true, "Wuthering Heights");
            inventory[12] = book12;

            Book book13 = new Book("Ray Bradbury", 518658, "9781451673319", true, "Fahrenheit 451");
            inventory[13] = book13;

            Book book14 = new Book("Aldous Huxley", 518659, "9780060850524", false, "Brave New World");
            inventory[14] = book14;

            Book book15 = new Book("Ernest Hemingway", 518660, "9780684801223", true, "The Old Man and the Sea");
            inventory[15] = book15;

            Book book16 = new Book("Gabriel García Márquez", 518661, "9780060883287", false, "One Hundred Years of Solitude");
            inventory[16] = book16;

            Book book17 = new Book("J.D. Salinger", 518662, "9780316769488", true, "The Catcher in the Rye");
            inventory[17] = book17;

            Book book18 = new Book("Kurt Vonnegut", 518663, "9780385333849", false, "Slaughterhouse-Five");
            inventory[18] = book18;

            Book book19 = new Book("Miguel de Cervantes", 518664, "9780060934347", true, "Don Quixote");
            inventory[19] = book19;


            Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("What do you want to do?");
                System.out.println("1) See Available Books");
                System.out.println("2) See Checked Out books");
                System.out.println("3) Check in a book");
                System.out.println("4) Exit program");

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
                }


            }


        }


        public static void displayAvailableBooks(Book[] inventory) {
            System.out.println("\nAvailable Books:");
            //checking books available
            for (int i = 0; i < inventory.length; i++) {
                Book book = inventory[i];
                if (book != null && !book.isCheckedOut()) {
                    System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() + " | Title: " + book.getTitle());
                }
            }

        }

        public static void displayCheckedOutBooks(Book[] inventory) {
            for (int i = 0; i < inventory.length; i++) {
                Book book = inventory[i];
                if (book != null && book.isCheckedOut()) {
                    System.out.println("ID: " + book.getId() + " | ISBN: " + book.getIsbn() +
                            " | Title: " + book.getTitle() + " | Checked out to: " + book.getCheckedOutTo());
                }
            }
        }

        public static void checkInBook(Book[] inventory, Scanner scanner) {
            System.out.println("\nEnter the ID of the book you'd like to check in: ");
            scanner.nextLine();

            Boolean isCheckIn = false;

            int bookID = scanner.nextInt();
            for (int i = 0; i < inventory.length; i++) {
                Book book = inventory[i];

                if (book != null && book.getId() == bookID) {

                    if (!book.isCheckedOut()) {
                        System.out.println("   " + book.getTitle() + "   has been checked in.");
                    } else {
                        inventory[1].setCheckedOut(false);
                        System.out.println(" That book is already checked in.");
                    }
                    isCheckIn = true;
                    break;
                }
            }
            if (!isCheckIn) {
                System.out.println("Book not in our inventory");
            }
        }
    }