import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.function.Consumer;

void main() {
    int i = 2;
    System.out.print("Write " + i + " as ");
    switch (i) {
        case 1 -> System.out.println("one");
        case 2 -> System.out.println("two");
        case 3 -> System.out.println("three");
    }

    DayOfWeek day = LocalDateTime.now().getDayOfWeek();
    switch (day) {
        case SATURDAY, SUNDAY -> System.out.println("It's the weekend");
        default -> System.out.println("It's a weekday");
    }

    LocalDateTime t = LocalDateTime.now();
    if (t.getHour() < 12) {
        System.out.println("It's before noon");
    } else {
        System.out.println("It's after noon");
    }

    Consumer<Object> whatAmI = obj -> {
        if (obj instanceof Boolean) {
            System.out.println("I'm a bool");
        } else if (obj instanceof Integer) {
            System.out.println("I'm an int");
        } else {
            System.out.println("Don't know type " + obj.getClass().getSimpleName().toLowerCase());
        }
    };
    whatAmI.accept(true);
    whatAmI.accept(1);
    whatAmI.accept("hey");
}
