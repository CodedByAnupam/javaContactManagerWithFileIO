import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManager {
    private List<Contact> contacts;


    public ContactManager() {
        this.contacts = new ArrayList<>();
        loadFromFile();  // Load contacts when ContactManager is created
    }

    public void addContact(String name, String phone, String email) {
        try {
            Contact newContact = new Contact(name, phone, email);
            this.contacts.add(newContact);
            System.out.println("Contact added successfully!");
            saveToFile();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void display() {
        if (this.contacts.isEmpty()) {
            System.out.println("Contact List is Empty.");
            return;
        }
        int i = 1;
        System.out.println("\nAll Contacts");
        System.out.println("----------");
        for (Contact contact : this.contacts) {
           
            System.out.println("Contact #" + i + " " + contact);
            i += 1;

        }

    }

    public void search(String term) {
        boolean found = false;
        System.out.println("Searching for: " + term);
        for (Contact contact : this.contacts) {
            if (contact.getName().toLowerCase().contains(term.toLowerCase())) {

                System.out.println(contact);
                found = true;

            }

        }
        if (!found)

        {
            System.out.println("No matching contacts found.");
        }
    }
    
    public void delete(String name) {

        System.out.println("Looking for " + name + " to delete");
        for (int i = this.contacts.size() - 1; i >= 0; i--) {
            if (this.contacts.get(i).getName().equalsIgnoreCase(name)) {
                this.contacts.remove(i);
                System.out.println("Contact Deleted Successfully!");
                saveToFile();
                return;
            }
            
        }
        System.out.println("Contact not found!");
    }
    
    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("contacts.txt");
            for (Contact contact : this.contacts) {
                writer.write(contact.getName() + "," + contact.getPhone() + "," + contact.getEmail() + "\n");
            }
            writer.close();
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void loadFromFile() {
        try {
            File file = new File("contacts.txt");

            if (!file.exists()) {
                System.out.println("The file contacts.txt does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            // Clear existing contacts before loading
            this.contacts.clear();

            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    Contact contact = new Contact(parts[0], parts[1], parts[2]);
                    this.contacts.add(contact);
                } catch (Exception e) {
                    System.out.println("Error adding line: " + line);
                }

            }
            
            reader.close();
            System.out.println("Contacts loaded successfully!"); 

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
  

    }

