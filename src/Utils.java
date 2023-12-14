import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Utils {

    // Static class
    private Utils() {}

    public static boolean equals(LocalDateTime ldt1, LocalDateTime ldt2){
        return (
                ldt1.getYear() == ldt2.getYear()
                    && ldt1.getMonthValue() == ldt2.getMonthValue()
                    && ldt1.getDayOfMonth() == ldt2.getDayOfMonth()
                    && ldt1.getHour() == ldt2.getHour()
                    && ldt1.getMinute() == ldt2.getMinute()
                );
    }

    public static Set<Reminder> init(int len){
        Set<Reminder> result = new TreeSet<>();

        for (int i = 1; i <= len; i++) {
            result.add(
                    new Reminder("Reminder " + i, LocalDateTime.now().plusMinutes((long) i), Urgency.Rand())
            );
        }

        return result;
    }
}
