package org.example;

public class Book {
    private String author;
    private int id;
    private String isbn;
    private boolean checkedOut;
    private String title;
    private String checkedOutTo;

    public Book(String author, int id, String isbn, boolean checkedOut, String title) {
        this.author = author;
        this.id = id;
        this.isbn = isbn;
        this.checkedOut = checkedOut;
        this.title = title;
        this.checkedOutTo = ""; // Initially no one has it
    }

    // Getters
    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Setters
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
        if (!checkedOut) {
            this.checkedOutTo = ""; // Clear borrower info on check-in
        }
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    // Checkout method
    public void checkOut(String borrower) {
        if (!checkedOut) {
            this.checkedOut = true;
            this.checkedOutTo = borrower;
            System.out.println("You have successfully checked out: " + title);
        } else {
            System.out.println("Sorry, this book is already checked out.");
        }
    }

    // Check-in method
    public void checkIn() {
        if (checkedOut) {
            this.checkedOut = false;
            this.checkedOutTo = "";
            System.out.println(title + " has been successfully checked in.");
        } else {
            System.out.println(title + " is already available in the library.");
        }
    }
}
