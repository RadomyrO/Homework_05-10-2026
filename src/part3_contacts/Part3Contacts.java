package part3_contacts;

import java.util.Scanner;

// Part 3. Contacts Database
public class Part3Contacts {

    static Scanner sc = new Scanner(System.in);
    static String[] contacts = new String[1000]; // big array
    static int count = 0; // real size

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> addContacts();
                case "2" -> showContacts();
                case "3" -> searchContacts();
                case "4" -> editContact();
                case "5" -> deleteContact();
                case "6" -> deleteAll();
                case "7" -> addSamples();
                case "0" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Wrong option, try again");
            }
        }
    }

    // menu
    static void printMenu() {
        System.out.println("\n===== CONTACTS =====");
        System.out.println("1. Add contacts");
        System.out.println("2. Show contacts");
        System.out.println("3. Search in contacts");
        System.out.println("4. Edit contact");
        System.out.println("5. Delete contact");
        System.out.println("6. Delete all");
        System.out.println("7. Add sample contacts");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    // add until empty line or x
    static void addContacts() {
        System.out.println("Enter contacts one per line (empty line or 'x' to stop):");
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty() || line.equalsIgnoreCase("x")) break;
            if (count >= contacts.length) {
                System.out.println("Database is full!");
                break;
            }
            contacts[count++] = line;
        }
        System.out.println("Done. Total: " + count);
    }

    // show all
    static void showContacts() {
        if (count == 0) {
            System.out.println("No contacts yet");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + contacts[i]);
        }
    }

    // search by phrase
    static void searchContacts() {
        System.out.print("Search phrase: ");
        String q = sc.nextLine().trim().toLowerCase();
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (contacts[i].toLowerCase().contains(q)) {
                System.out.println((i + 1) + ". " + contacts[i]);
                found++;
            }
        }
        System.out.println("Found: " + found);
    }

    // edit by number
    static void editContact() {
        int i = readIndex("Contact number to edit: ");
        if (i == -1) return;
        System.out.println("Current: " + contacts[i]);
        System.out.print("New value: ");
        contacts[i] = sc.nextLine().trim();
        System.out.println("Saved");
    }

    // mark as DELETED
    static void deleteContact() {
        int i = readIndex("Contact number to delete: ");
        if (i == -1) return;
        contacts[i] = "DELETED";
        System.out.println("Deleted");
    }

    // wipe all to ""
    static void deleteAll() {
        for (int i = 0; i < count; i++) {
            contacts[i] = "";
        }
        System.out.println("All contacts cleared");
    }

    // test data
    static void addSamples() {
        String[] samples = {
                "John Smith +380501112233 john@mail.com",
                "Anna Ivanova +380672223344 anna@gmail.com",
                "Petro Shevchenko +380933334455",
                "Olga Koval olga.k@ukr.net",
                "Mike Brown +14155550123"
        };
        for (String s : samples) {
            if (count < contacts.length) contacts[count++] = s;
        }
        System.out.println("Samples added. Total: " + count);
    }

    // read number -> index, -1 if bad
    static int readIndex(String prompt) {
        System.out.print(prompt);
        try {
            int n = Integer.parseInt(sc.nextLine().trim());
            if (n < 1 || n > count) {
                System.out.println("No such contact");
                return -1;
            }
            return n - 1;
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            return -1;
        }
    }
}
