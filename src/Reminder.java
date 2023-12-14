import java.time.LocalDateTime;
import java.util.Objects;

public class Reminder implements Comparable<Reminder>{

    private String text;
    private LocalDateTime expiration = LocalDateTime.now();
    private Urgency urgency = Urgency.Normal;
    private boolean isPoped = false;

    public Reminder(String text, LocalDateTime expiration, Urgency urgency, boolean isPoped) {
        this.text = text;
        this.expiration = expiration;
        this.urgency = urgency;
        this.isPoped = isPoped;
    }

    public Reminder(String text, LocalDateTime expiration, Urgency urgency) {
        this.text = text;
        this.expiration = expiration;
        this.urgency = urgency;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "\ntext='" + text + '\'' +
                "\n, expiration=" + expiration +
                "\n, urgency=" + urgency +
                "\n, isPoped=" + isPoped +
                "}\n";
    }

    public String getText() {
        return text;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public boolean isPoped() {
        return isPoped;
    }

    public void setPoped(boolean poped) {
        isPoped = poped;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public Reminder(String text, LocalDateTime expiration) {
        this.text = text;
        this.expiration = expiration;
    }

    public Reminder(String text, Urgency urgency) {
        this.text = text;
        this.urgency = urgency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(text, reminder.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public int compareTo(Reminder reminder) {

        if(this.expiration.isAfter(reminder.expiration)) return 1;
        if(this.expiration.isBefore(reminder.expiration)) return -1;
        return 0;
    }
}
