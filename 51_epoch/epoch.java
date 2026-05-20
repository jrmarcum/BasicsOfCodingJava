import java.time.Instant;

void main() {
    Instant now = Instant.now();
    long secs = now.getEpochSecond();
    long nanos = secs * 1_000_000_000L + now.getNano();
    System.out.println(now);
    System.out.println(secs);
    System.out.println(nanos / 1_000_000);
    System.out.println(nanos);
    System.out.println(Instant.ofEpochSecond(secs));
    System.out.println(Instant.ofEpochSecond(0, nanos));
}
