import java.util.Scanner;

public class Library2D {



     private static Scanner sc = new Scanner(System.in);
       private int[][] bookStorage; //////\ [shelves][slots]
    private int rows;
    private int cols;
    private int totalBooks;

    // Constructor to set up the 2D rack system
    public Library2D(int shelves, int slotsPerShelf) {
        this.rows = shelves;
          this.cols = slotsPerShelf;
        this.bookStorage = new int[shelves][slotsPerShelf];
        this.totalBooks = 0;
    }






    // 1. Add Book ID at the next/\ available slot across shelves
    public void add() {
        if (totalBooks == rows * cols) {
            System.out.println("\nError: Rack is Completely Full");
            return;
        }

           System.out.println("\nEnter a Book ID to add:");
        int value = sc.nextInt();

        if (value == 0) {
            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }





        // Find the first empty spot (value 0)
        for (int r = 0; r < rows; r++) {
               for (int c = 0; c < cols; c++) {
                if (bookStorage[r][c] == 0) {
                    bookStorage[r][c] = value;
                    totalBooks++;
                    System.out.println("Book ID " + value + " added to Shelf " + r + ", Slot " + c);
                    return;
                }
          }
        }
    }













    // 2. Insert Book ID at specific (shelf, slot) position
    public void insert() {
            System.out.println("Enter Shelf index (0 to " + (rows - 1) + "):");
            int r = sc.nextInt();
        System.out.println("Enter Slot index (0 to " + (cols - 1) + "):");
        int c = sc.nextInt();

        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            System.out.println("Error: Invalid Shelf or Slot index");
            return;
  }


        System.out.println("Enter a Book ID to add:");
        int value = sc.nextInt();

        if (value == 0) {
            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }

        if (bookStorage[r][c] != 0) {
            System.out.println("Slot [" + r + "][" + c + "] is currently occupied by Book ID " + bookStorage[r][c] + ". Overwriting...");
        } else {
            totalBooks++;
        }

        bookStorage[r][c] = value;
        System.out.println("Book ID " + value + " placed at Shelf " + r + ", Slot " + c);
    }









    // 3. Fill all empty slots remaining in the rack
    public void fill() {
        if (totalBooks == rows * cols) {
            System.out.println("\nError: Rack is Full");
            return;
        }

          for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (bookStorage[r][c] == 0) {
                    int value = 0;
                    do {
                        System.out.println("Enter Book ID for Shelf " + r + ", Slot " + c + ":");
                        value = sc.nextInt();
                        if (value == 0) {
                            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
                        }
                    } while (value == 0);

                    bookStorage[r][c] = value;
                    totalBooks++;




                }
            }
        }

        System.out.println("\nRack is now completely full.");
    }




    // 4. Delete Book ID at last occupied position
    public void removeLast() {
        if (totalBooks == 0) {
            System.out.println("Error: Rack is Empty");
            return;
        }

        for (int r = rows - 1; r >= 0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (bookStorage[r][c] != 0) {
                    System.out.println("Removed Book ID " + bookStorage[r][c] + " from Shelf " + r + ", Slot " + c);
                    bookStorage[r][c] = 0;
                    totalBooks--;
                    return;
                }
            }
        }
    }



    // 5. Delete Book ID at specific (shelf, slot) index
    public void delete() {
        if (totalBooks == 0) {
            System.out.println("Error: Rack is Empty");
            return;
        }

        System.out.println("Enter Shelf index:");
        int r = sc.nextInt();
        System.out.println("Enter Slot index:");
        int c = sc.nextInt();

        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            System.out.println("Error: Invalid Index");
            return;
        }

        if (bookStorage[r][c] == 0) {
            System.out.println("Slot [" + r + "][" + c + "] is already empty.");
            return;
        }

        System.out.println("Book ID " + bookStorage[r][c] + " at Shelf " + r + ", Slot " + c + " is deleted");
        bookStorage[r][c] = 0;
        totalBooks--;
    }

    // 6. Display all Book IDs arranged by shelf grid
    public void display() {
        if (totalBooks == 0) {
            System.out.println("Error: Rack is Empty");
            return;
        }

        System.out.println("\n--- Displaying 2D Library Rack ---");
        for (int r = 0; r < rows; r++) {
            System.out.print("Shelf " + r + ":\t");
            for (int c = 0; c < cols; c++) {
                if (bookStorage[r][c] == 0) {
                    System.out.print("[ Empty ]\t");
                } else {
                    System.out.print("[" + bookStorage[r][c] + "]\t\t");
                }
            }
            System.out.println();
        }
        System.out.println("Total books stored: " + totalBooks);
    }

    // 7. Search for a Book ID across the entire 2D matrix
    public void search() {
        if (totalBooks == 0) {
            System.out.println("Error: Rack is Empty");
            return;
        }

        System.out.println("Enter Book ID to search:");
        int value = sc.nextInt();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (bookStorage[r][c] == value) {
                    System.out.println("Book ID " + value + " found at Shelf " + r + ", Slot " + c);
                    return;
                }
            }
        }
        System.out.println("Book ID " + value + " was not found in the library rack.");
    }

    // 8. Get Book ID at specific (shelf, slot) coordinates
    public void searchByIndex() {
        if (totalBooks == 0) {
            System.out.println("Error: Rack is Empty");
            return;
        }

        System.out.println("Enter Shelf index:");
        int r = sc.nextInt();
        System.out.println("Enter Slot index:");
        int c = sc.nextInt();

        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            System.out.println("Error: Invalid Index");
            return;
        }

        if (bookStorage[r][c] == 0) {
            System.out.println("Slot [" + r + "][" + c + "] is empty.");
        } else {
            System.out.println("Book ID at Shelf " + r + ", Slot " + c + " is: " + bookStorage[r][c]);
        }
    }

    // 9. Update Book ID at a specific slot
    public void update() {
        System.out.println("Enter Shelf index:");
        int r = sc.nextInt();
        System.out.println("Enter Slot index:");
        int c = sc.nextInt();

        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            System.out.println("Error: Invalid Index");
            return;
        }

        System.out.println("Enter new Book ID:");
        int value = sc.nextInt();

        if (value == 0) {
            System.out.println("Error: Invalid Book ID, Zero is Not a Valid ID");
            return;
        }

        if (bookStorage[r][c] == 0) {
            totalBooks++;
        }

        bookStorage[r][c] = value;
        System.out.println("Shelf " + r + ", Slot " + c + " updated to Book ID " + value);
    }

    // 10. Display current count of stored books
    public void currentSize() {
        System.out.println("Current total books in the rack: " + totalBooks + " / " + (rows * cols));
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of shelves (rows):");
        int shelves = sc.nextInt();
        System.out.println("Enter slots per shelf (columns):");
        int slots = sc.nextInt();

        Library2D library = new Library2D(shelves, slots);

        int menu = 0;

        do {
            System.out.println("\n----- 2D LIBRARY RACK MENU -----");
            System.out.println("1.  Add Book ID");
            System.out.println("2.  Insert Book ID at (Shelf, Slot)");
            System.out.println("3.  Fill All Empty Slots in Rack");
            System.out.println("4.  Delete Last Added Book");
            System.out.println("5.  Delete Book ID by Coordinates");
            System.out.println("6.  Display 2D Rack Layout");
            System.out.println("7.  Search for a Book ID");
            System.out.println("8.  Get Book ID by Coordinates");
            System.out.println("9.  Update Book ID");
            System.out.println("10. Display Current Book Count");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            menu = sc.nextInt();

            switch (menu) {
                case 1: library.add(); break;
                case 2: library.insert(); break;
                case 3: library.fill(); break;
                case 4: library.removeLast(); break;
                case 5: library.delete(); break;
                case 6: library.display(); break;
                case 7: library.search(); break;
                case 8: library.searchByIndex(); break;
                case 9: library.update(); break;
                case 10: library.currentSize(); break;
                case 11:
                    System.out.println("Exiting 2D Library Management System...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

        } while (menu != 11);

        sc.close();
    }
}