# BasicsOfCodingJava — Session Context

## What This Project Is

A multi-language comparative study of programming syntax, simplicity, lines
of code, and performance. Each language implements the same 78 example
programs so they can be compared side-by-side.

The source of truth for program logic and expected output is **Basics of
Coding Go** by Jon Marcum:

- GitHub: <https://github.com/jrmarcum/BasicsOfCodingGo>
- For each lesson, read the upstream `.go` source and `.md` to understand
  what the program does and what output it produces, then translate to
  idiomatic Java.

The structural reference is **BasicsOfCodingC**
(https://github.com/jrmarcum/BasicsOfCodingC). Match its repo layout,
CLAUDE.md shape, NOTICE/LICENSE structure, and lesson `.md` format exactly.

> **Note:** The `upstream/basicsofcodinggo` submodule points to
> <https://github.com/jrmarcum/BasicsOfCodingGo>. Run `git submodule update --init`
> after cloning to populate it. All 78 lessons are already implemented; the
> upstream is only needed if adding or modifying lessons.

## Project Status

All 78 lessons are complete. Each lesson directory contains:

- A `.java` source file (verified running with `java filename.java`)
- A `.md` file with the run command and sample output

## Project Structure

```
BasicsOfCodingJava/
├── CLAUDE.md
├── LICENSE            — CC0 (Jon Marcum original contributions)
├── NOTICE             — CC BY 3.0 attribution for derived lesson content
├── README.md
├── upstream/          — not present; clone BasicsOfCodingGo if needed
└── ##_topic-name/
    ├── topic-name.java
    └── topic-name.md
```

All 78 lessons: `01_hello-world` through `78_sha256-hashes`.
Numbers match BasicsOfCodingGo exactly — do not renumber.

## Java 25 Code Style

Every lesson uses Java 25's **unnamed class** feature — no outer
`public class ClassName {}` wrapper. The entry point is an instance main:

```java
void main() {
    System.out.println("hello world");
}
```

This lets every program run with a single command: `java filename.java`

Helper methods, records, interfaces, and enums are all declared at the
top level in the same file. Inner/nested class declarations are fine too.

```java
record Pair(int a, int b) {}

void main() {
    var p = new Pair(1, 2);
    System.out.println(p.a() + p.b());
}
```

For lessons that need command-line args, use `void main(String[] args)` —
this works in single-file mode: `java prog.java a b c`.

## Lesson .md Format (exact, no deviations)

```
[Optional one-line description]

___

##### Run Command:
`[run command]`

##### Results:
`[output line 1]`
`[output line 2]`
```

No per-file attribution footers. Time-dependent or nondeterministic
lessons note this in the description line.

## Licensing Rule

Do NOT add per-file attribution footers. Attribution is handled centrally
in README and NOTICE. This is intentional and differs from some other repos.

## Output Matching

Match upstream Go output line-for-line. Where the language produces
structurally different output, document the difference in the lesson `.md`
description line. Known systematic differences:

| Construct | Go output | Java output |
| --- | --- | --- |
| Arrays/lists | `[a b c]` | `[a, b, c]` (commas) |
| Maps | `map[k:v]` | `{k=v}` |
| Large floats | `6e+11` | `6.0E11` |
| Month enum | `November` | `NOVEMBER` |
| Weekday enum | `Tuesday` | `TUESDAY` |
| Duration | `144h0m0s` | `PT144H0M0S` (ISO-8601) |
| Time string | `2009-11-10 23:00:00 +0000 UTC` | `2009-11-10T23:00:00Z` |
| Number error | `strconv.Atoi: parsing "x": invalid syntax` | `java.lang.NumberFormatException: For input string: "x"` |
| Windows paths | forward slash | backslash |

## Special Lessons

- **58–60** (reading/writing files, line-filters): require a `tmp/`
  directory inside the lesson directory at runtime (gitignored, create
  manually). Lesson 58 also needs `tmp/dat.txt` containing `hello\njava\n`.
- **50–52, 32, 37**: time-dependent output — note in `.md` that results vary.
- **27–37** (concurrency): nondeterministic per-thread ordering — note in `.md`.
- **64–66** (command-line args/flags/subcommands): use `void main(String[] args)`
  and run with `java prog.java arg1 arg2` in single-file mode; no compilation needed.
- **68** (testing-and-benchmarking): requires `javac` compilation; uses a
  hand-rolled test runner (`IntMinTest.java`) that matches Go's `go test -v`
  output format. No external JUnit dependency.
- **67** (environment-variables): Java cannot set env vars at runtime;
  set `FOO=1` before invoking: `FOO=1 java environment_variables.java`.
- **70–72** (http-server, context, tcp-server): long-running servers; run in
  background and test with curl or netcat.

---

## Language-Specific Reference

### Toolchain

JDK 25+ required (unnamed class feature is final in Java 25).

```
java filename.java                       # single-file programs (all lessons except 68)
javac IntMinTest.java && java IntMinTest # lesson 68 only
```

### Key Go→Java Translations

| Go | Java |
|---|---|
| `fmt.Println` | `System.out.println` |
| `fmt.Printf` | `System.out.printf` |
| Slices | `ArrayList<T>` |
| Maps | `LinkedHashMap<K,V>` (preserves insertion order) |
| Multiple return | `record Pair(int a, int b) {}` |
| Closures (mutable state) | `int[] i = {0};` array trick |
| `interface` | `interface` |
| `defer` | `try-finally` / `try-with-resources` |
| goroutines | `Thread.ofVirtual().start(Runnable)` |
| channels | `LinkedBlockingQueue<T>` |
| `select` | `CompletableFuture.anyOf()` |
| `sync.WaitGroup` | `CountDownLatch` |
| `sync.Mutex` | `ReentrantLock` + `lock()`/`unlock()` in `try-finally` |
| `sync/atomic` | `AtomicLong.getAndAdd()` |
| `error` return | `throws Exception` / checked exceptions |
| `panic` | `throw new RuntimeException(msg)` |
| `recover` | `try { ... } catch (RuntimeException e) { ... }` |
| `regexp` | `Pattern.compile()` + `Matcher` |
| `net/http` client | `java.net.http.HttpClient` |
| `net/http` server | `com.sun.net.httpserver.HttpServer` |
| `crypto/sha1` | `MessageDigest.getInstance("SHA-1")` |
| `crypto/sha256` | `MessageDigest.getInstance("SHA-256")` |
| `encoding/base64` | `java.util.Base64` |
| `net/url` | `java.net.URI` |
| `os.Getenv` | `System.getenv()` |
| `os.Setenv` | not possible at runtime — set before invoking |
| `os.Args` | `void main(String[] args)` |
| `filepath.*` | `java.nio.file.Path` / `Path.of()` |
| `os.Mkdir` / `os.MkdirAll` | `Files.createDirectory()` / `Files.createDirectories()` |
| `filepath.Walk` | `Files.walk()` |
| `ioutil.TempFile` | `Files.createTempFile()` |
| `ioutil.TempDir` | `Files.createTempDirectory()` |
| `ioutil.ReadFile` | `Files.readAllBytes(Path.of(...))` |
| `ioutil.WriteFile` | `Files.write(Path.of(...), bytes)` |
| `bufio.NewScanner(os.Stdin)` | `new BufferedReader(new InputStreamReader(System.in))` |
| `json.Marshal` | manual JSON string construction (no stdlib JSON in JDK 25) |
| `text/template` | manual `String.replace("{{.}}", value)` |
| `time.Now()` | `Instant.now()` / `ZonedDateTime.now()` |
| `time.Unix(s, n)` | `Instant.ofEpochSecond(s, n)` |
| `time.Format(RFC3339)` | `DateTimeFormatter.ISO_OFFSET_DATE_TIME` |
| `time.Sleep` | `Thread.sleep(Duration)` |
| `time.After` | `CompletableFuture.orTimeout()` |
| `time.NewTimer` | `ScheduledExecutorService.schedule()` |
| `time.NewTicker` | `ScheduledExecutorService.scheduleAtFixedRate()` |
| `log.Println` | `java.util.logging.Logger` |
| `os.Stderr` | `System.err` |
| `os.Exit(n)` | `System.exit(n)` |
| `signal.Notify` | `Runtime.getRuntime().addShutdownHook(new Thread(...))` |
| `syscall.Exec` | not available — use `ProcessBuilder` (lesson 74) |
| `exec.Command` | `new ProcessBuilder(...)` |
| `sort.Strings` | `Collections.sort(list)` |
| `sort.Slice` | `list.sort(Comparator...)` |
| `strings.*` | `String` methods / `String.join` / `String.format` |
| `strconv.Atoi` | `Integer.parseInt()` |
| `strconv.ParseFloat` | `Double.parseDouble()` |
| `strconv.ParseInt` | `Long.parseLong()` / `Long.decode()` (handles `0x` prefix) |
| `math/rand` | `java.util.Random` |

### Filename Conventions

- **Directory names** keep hyphens to match Go upstream: `05_for/`, `06_if-else/`
- **`.java` filenames** use underscores: `for_loop.java`, `if_else.java`
- **Java keyword filenames** get a suffix:
  - `for.java` → `for_loop.java`
  - `switch.java` → `switch_stmt.java`
- **Lesson 68** uses `IntMinTest.java` (capitalized) — requires `javac`
- **Lesson 58** needs `tmp/dat.txt` in the lesson dir: `hello\njava\n`

### Known Implementation Notes

- **Pointers (17):** Java has no pointers. Use `int[]` array for mutable
  pass-by-reference. Use `System.identityHashCode(obj)` formatted as hex
  to simulate printing an address (value varies per run).
- **Closures (15):** Java lambdas can only capture effectively-final variables.
  For mutable counter state, use `int[] i = {0}` and mutate `i[0]`.
- **Select (29):** Go's `select` on channels maps to `CompletableFuture.anyOf()`
  with `supplyAsync` tasks feeding a `LinkedBlockingQueue`.
- **JSON (48):** JDK 25 has no built-in JSON library. All JSON is constructed
  via manual string formatting to match Go's `encoding/json` output.
- **Text templates (73):** Java has no `text/template`. String replacement of
  `{{.}}` and `{{.FieldName}}` tokens is implemented manually.
- **Execing processes (74):** Go's `syscall.Exec` replaces the current process.
  Java has no equivalent; `ProcessBuilder` spawns a subprocess instead.
- **Signals (76):** Java shutdown hooks run on `SIGINT`/`SIGTERM` but cannot
  name the signal. The shutdown hook simply prints `exiting`.
- **Rate limiting (37):** Implemented with `scheduleAtFixedRate` feeding a
  `LinkedBlockingQueue` as a token bucket.
- **Logging (39):** Uses `java.util.logging` with custom `Formatter` classes.
  Structured JSON logging is manual string construction to `System.err`.

**.gitignore entries:** `*.class`, `*.jar`, `target/`, `build/`, `.gradle/`, `tmp/`
