import java.time.*;

void main() {
    // Current time
    System.out.println(ZonedDateTime.now());

    // Fixed time: 2009-11-17 20:34:58.651387237 UTC
    var then = ZonedDateTime.of(2009, 11, 17, 20, 34, 58, 651387237, ZoneOffset.UTC);
    System.out.println(then);

    System.out.println(then.getYear());
    System.out.println(then.getMonth());
    System.out.println(then.getDayOfMonth());
    System.out.println(then.getHour());
    System.out.println(then.getMinute());
    System.out.println(then.getSecond());
    System.out.println(then.getNano());
    System.out.println(then.getZone());

    System.out.println(then.getDayOfWeek());

    var now = ZonedDateTime.now();
    System.out.println(then.isBefore(now));
    System.out.println(then.isAfter(now));
    System.out.println(then.isEqual(now));

    var diff = Duration.between(then, now);
    System.out.println(diff);

    System.out.println(diff.toHours());
    System.out.println(diff.toMinutes());
    System.out.println(diff.toSeconds());
    System.out.println(diff.toNanos());

    System.out.println(then.plus(diff));
    System.out.println(then.minus(diff));
}
