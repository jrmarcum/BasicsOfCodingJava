import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoField;
import java.util.Locale;

void main() {
    ZonedDateTime t = ZonedDateTime.now(ZoneOffset.UTC);

    System.out.println(t.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

    ZonedDateTime t1 = ZonedDateTime.parse("2012-11-01T22:08:41+00:00");
    System.out.println(t1);

    System.out.println(t.format(DateTimeFormatter.ofPattern("h:mma", Locale.US)));

    DateTimeFormatter unixFmt = new DateTimeFormatterBuilder()
        .appendPattern("EEE MMM ")
        .padNext(2, ' ')
        .appendValue(ChronoField.DAY_OF_MONTH)
        .appendPattern(" HH:mm:ss yyyy")
        .toFormatter(Locale.US);
    System.out.println(t.format(unixFmt));

    System.out.println(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX", Locale.US)));

    LocalTime t2 = LocalTime.parse("8 41 PM", DateTimeFormatter.ofPattern("h mm a", Locale.US));
    System.out.println(LocalDateTime.of(LocalDate.of(0, 1, 1), t2).atOffset(ZoneOffset.UTC));
    System.out.println();

    System.out.printf("%d-%02d-%02dT%02d:%02d:%02d-00:00%n",
        t.getYear(), t.getMonthValue(), t.getDayOfMonth(),
        t.getHour(), t.getMinute(), t.getSecond());

    try {
        LocalTime.parse("8:41PM",
            DateTimeFormatter.ofPattern("EEE MMM  d HH:mm:ss yyyy", Locale.US));
    } catch (DateTimeParseException e) {
        System.out.println(e.getMessage());
    }
}
