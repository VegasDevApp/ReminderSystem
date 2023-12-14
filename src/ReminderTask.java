import java.time.LocalDateTime;
import java.util.Set;

public class ReminderTask extends Thread {
    private boolean quit = false;
    final private Set<Reminder> reminders;
    final private int INTERVAL = 1000 * 60;

    public ReminderTask(Set<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void run() {
        while (!quit) {

            for (Reminder reminder : reminders) {
                if (Utils.equals(reminder.getExpiration(), LocalDateTime.now())
                                && !reminder.isPoped()) {
                    reminder.setPoped(true);

                    switch (reminder.getUrgency()){
                        case Normal:
                            System.out.println(reminder.getText());
                            break;
                        case Important:
                            System.out.println(reminder.getText().toUpperCase());
                            break;
                        case Critical:
                            System.out.println(
                                    "!!!" + reminder.getText().toUpperCase() + "!!!");
                            break;
                    }
                }
            }
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
                System.out.println("Good bey!!!");
            }

        }
    }

    public void end() {
        this.quit = true;
        this.interrupt();
    }
}
