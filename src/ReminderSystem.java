import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class ReminderSystem {
    private static Scanner scanner;
    private static ReminderSystem instance = null;
    private Set<Reminder> reminders;
    private ReminderTask task;


    private ReminderSystem() {
        this.reminders = Utils.init(10);
        start();
    }

    public static ReminderSystem getInstance() {
        if (instance == null) {
            synchronized (ReminderSystem.class) {
                if (instance == null) {
                    instance = new ReminderSystem();
                }
            }
        }
        return instance;
    }

    public void start(){
        //Print start message
        System.out.println("This is the welcome message");

        //Initialize scanner object
        scanner = new Scanner(System.in);

        //Initialize the task and start it
        this.task = new ReminderTask(this.reminders);
        this.task.start();

        //Start the program method
        this.program();
    }

    public void program() {

        boolean isRunning = true;

        //Implement the program requirements using while loop
        while (isRunning){
            menu();
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    addReminder();
                    break;
                case 2:
                    displaySorted();
                    break;
                case 3:
                    isRunning = false;
                    end();
                    break;
                default:
                    System.out.println("You can take an action from menu only!");
            }
        }
    }

    public void menu(){
        //Show menu as explained above
        System.out.println("Select the action");
        System.out.println("1 - add new reminder");
        System.out.println("2 - list reminders");
        System.out.println("3 - Quit");
    }

    public void end(){
        scanner.close();
        this.task.end();
    }

    public void displaySorted(){
        for(Reminder reminder: this.reminders){
            // Should be sorted due TreeSet
            System.out.println(reminder.toString());
        }
    }

    public void addReminder(){
        //Ask user for text and minutes from now
        System.out.println("Hey user, what you want me to remind you?");
        String text = scanner.next();
        scanner.nextLine();
        System.out.println("Hey user, how many minutes to remind you?");
        int minutes = scanner.nextInt();

        //Add the new Reminder using relevant constructor
        this.reminders.add(
          new Reminder(text, LocalDateTime.now().plusMinutes(minutes), Urgency.Rand())
        );
    }
}
