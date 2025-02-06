import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.run();
    }

    private void run() {
        while (true) {
            System.out.println("\nTask Manager");
            System.out.println("1. Προσθήκη εργασίας");
            System.out.println("2. Προβολή εργασιών");
            System.out.println("3. Ολοκλήρωση εργασίας");
            System.out.println("4. Διαγραφή εργασίας");
            System.out.println("5. Έξοδος");
            System.out.print("Επιλέξτε: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewTasks();
                        break;
                    case 3:
                        completeTask();
                        break;
                    case 4:
                        deleteTask();
                        break;
                    case 5:
                        System.out.println("Έξοδος...");
                        return;
                    default:
                        System.out.println("Μη έγκυρη επιλογή, προσπαθήστε ξανά.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Παρακαλώ εισάγετε έναν αριθμό μεταξύ 1-5.");
            }
        }
    }

    private void addTask() {
        System.out.print("Τίτλος: ");
        String title = scanner.nextLine();
        System.out.print("Περιγραφή: ");
        String description = scanner.nextLine();
        tasks.add(new Task(title, description));
        System.out.println("Εργασία προστέθηκε επιτυχώς!");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Δεν υπάρχουν εργασίες.");
            return;
        }
        System.out.println("Λίστα εργασιών:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void completeTask() {
        viewTasks();
        System.out.print("Επιλέξτε αριθμό εργασίας για ολοκλήρωση: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).completeTask();
                System.out.println("Η εργασία ολοκληρώθηκε!");
            } else {
                System.out.println("Μη έγκυρος αριθμός.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Παρακαλώ εισάγετε έναν έγκυρο αριθμό.");
        }
    }

    private void deleteTask() {
        viewTasks();
        System.out.print("Επιλέξτε αριθμό εργασίας για διαγραφή: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Η εργασία διαγράφηκε!");
            } else {
                System.out.println("Μη έγκυρος αριθμός.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Παρακαλώ εισάγετε έναν έγκυρο αριθμό.");
        }
    }
}
