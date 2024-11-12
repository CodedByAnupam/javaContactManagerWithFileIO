public class Main {

    public static void main(String[] args) {
        // Contact contact = new Contact("John", "9820592777", "a@a.com");
        // System.out.println(contact);
        // Create a new contact manager (it will load any existing contacts)
        ContactManager manager = new ContactManager();
        
        // Test 1: Add valid contacts
        // System.out.println("Adding valid contacts...");
        // manager.addContact("John Smith", "1234567890", "john@email.com");
        // manager.addContact("Jane Doe", "9876543210", "jane@email.com");
        // manager.addContact("John Doe", "5555555555", "johndoe@email.com");

        // Display any loaded contacts
        System.out.println("\nDisplaying loaded contacts:");
  

        manager.display();

        // Test 1: Add new contacts
        manager.addContact("John Smith", "1234567890", "john@email.com");
        manager.addContact("Jane Doe", "9876543210", "jane@email.com");

        manager.search("john");

        manager.delete("Jane Doe");
        manager.delete("Tom");

        manager.display();
    }
}