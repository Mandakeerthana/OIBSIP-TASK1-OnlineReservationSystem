import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// User class to store user data
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Main class containing the system logic
public class OnlineReservationSystem2 {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some example users (Replace with real database handling)
        users.put("keerthana", new User("keerthana", "1234T5"));
        users.put("sanjay", new User("sanjay", "456F3"));

        showLoginForm();
    }

    private static void showLoginForm() {
        System.out.println("===== Login Form =====");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            System.out.println("Login successful!");
            showMainMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
            showLoginForm();
        }
    }

    private static boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    private static void showMainMenu() {
        System.out.println("\n===== Main Menu =====");
        System.out.println("1. Make a reservation");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                makeReservation();
                break;
            case 2:
                cancelReservation();
                break;
            case 3:
                System.out.println("Logged out. Thank you!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
        }
    }

    private static void makeReservation() {
        System.out.println("\n===== Reservation Form =====");
        // Implement reservation logic here (train number, destination, date, etc.)
        // and save the reservation details to the database (not implemented here)
        System.out.println("Reservation successfully made!");
        showMainMenu();
    }

    private static void cancelReservation() {
        System.out.println("\n===== Cancellation Form =====");
        System.out.print("Enter your PNR number: ");
        String pnrNumber = scanner.next();

        // Implement cancellation logic here (fetch reservation details from the database
        // based on PNR number, cancel the reservation, and update the database accordingly)
        // (not implemented here)

        System.out.println("Reservation with PNR " + pnrNumber + " successfully cancelled!");
        showMainMenu();
    }
}

