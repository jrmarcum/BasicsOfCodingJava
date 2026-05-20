# BasicsOfCodingJava

Java implementations of the 78 example programs from
[Basics of Coding Go](https://github.com/jrmarcum/BasicsOfCodingGo),
part of a multi-language comparative study of programming syntax, simplicity,
and performance.

## About

Each lesson demonstrates one Java concept, translated from the Go original.
Programs are written using **Java 25's unnamed class feature** — no outer
`public class` wrapper, and `void main()` as the entry point — so every
program runs with a single command:

```sh
java filename.java
```

## Requirements

- JDK 25 or later

## Running a Lesson

```sh
cd 01_hello-world
java hello_world.java
```

Lesson 68 (testing) requires compilation:

```sh
cd 68_testing-and-benchmarking
javac IntMinTest.java && java IntMinTest
```

## Lessons

| # | Topic | Run Command |
| --- | --- | --- |
| 01 | hello-world | `java hello_world.java` |
| 02 | values | `java values.java` |
| 03 | variables | `java variables.java` |
| 04 | constants | `java constants.java` |
| 05 | for | `java for_loop.java` |
| 06 | if-else | `java if_else.java` |
| 07 | switch | `java switch_stmt.java` |
| 08 | arrays | `java arrays.java` |
| 09 | slices | `java slices.java` |
| 10 | maps | `java maps.java` |
| 11 | range | `java range.java` |
| 12 | functions | `java functions.java` |
| 13 | multiple-return-values | `java multiple_return_values.java` |
| 14 | variadic-functions | `java variadic_functions.java` |
| 15 | closures | `java closures.java` |
| 16 | recursion | `java recursion.java` |
| 17 | pointers | `java pointers.java` |
| 18 | structs | `java structs.java` |
| 19 | methods | `java methods.java` |
| 20 | interfaces | `java interfaces.java` |
| 21 | errors | `java errors.java` |
| 22 | strings-and-runes | `java strings_and_runes.java` |
| 23 | struct-embedding | `java struct_embedding.java` |
| 24 | enums | `java enums.java` |
| 25 | custom-errors | `java custom_errors.java` |
| 26 | generics | `java generics.java` |
| 27 | goroutines | `java goroutines.java` |
| 28 | channels | `java channels.java` |
| 29 | select | `java select.java` |
| 30 | timeouts | `java timeouts.java` |
| 31 | timers | `java timers.java` |
| 32 | tickers | `java tickers.java` |
| 33 | mutexes | `java mutexes.java` |
| 34 | atomic-counters | `java atomic_counters.java` |
| 35 | waitgroups | `java waitgroups.java` |
| 36 | worker-pools | `java worker_pools.java` |
| 37 | rate-limiting | `java rate_limiting.java` |
| 38 | recover | `java recover.java` |
| 39 | logging | `java logging.java` |
| 40 | sorting | `java sorting.java` |
| 41 | sorting-by-functions | `java sorting_by_functions.java` |
| 42 | panic | `java panic.java` |
| 43 | defer | `java defer.java` |
| 44 | collection-functions | `java collection_functions.java` |
| 45 | string-functions | `java string_functions.java` |
| 46 | string-formatting | `java string_formatting.java` |
| 47 | regular-expressions | `java regular_expressions.java` |
| 48 | json | `java json.java` |
| 49 | xml | `java xml.java` |
| 50 | time | `java time.java` |
| 51 | epoch | `java epoch.java` |
| 52 | time-formatting-parsing | `java time_formatting_parsing.java` |
| 53 | random-numbers | `java random_numbers.java` |
| 54 | number-parsing | `java number_parsing.java` |
| 55 | url-parsing | `java url_parsing.java` |
| 56 | sha1-hashes | `java sha1_hashes.java` |
| 57 | base64-encoding | `java base64_encoding.java` |
| 58 | reading-files | `java reading_files.java` ¹ |
| 59 | writing-files | `java writing_files.java` ¹ |
| 60 | line-filters | `echo hello \| java line_filters.java` |
| 61 | file-paths | `java file_paths.java` |
| 62 | directories | `java directories.java` |
| 63 | temporary-files-and-directories | `java temporary_files_and_directories.java` |
| 64 | command-line-arguments | `java command_line_arguments.java a b c d` |
| 65 | command-line-flags | `java command_line_flags.java -word=opt` |
| 66 | command-line-subcommands | `java command_line_subcommands.java foo -enable` |
| 67 | environment-variables | `FOO=1 java environment_variables.java` |
| 68 | testing-and-benchmarking | `javac IntMinTest.java && java IntMinTest` |
| 69 | http-client | `java http_client.java` |
| 70 | http-server | `java http_server.java` ² |
| 71 | context | `java context.java` ² |
| 72 | tcp-server | `java tcp_server.java` ² |
| 73 | text-templates | `java text_templates.java` |
| 74 | execing-processes | `java execing_processes.java` |
| 75 | spawning-processes | `java spawning_processes.java` |
| 76 | signals | `java signals.java` |
| 77 | exit | `java exit.java` |
| 78 | sha256-hashes | `java sha256_hashes.java` |

¹ Requires `tmp/dat.txt` containing `hello\njava\n` in the lesson directory.
² Long-running server — run in background and test with curl or netcat.

## Key Java Translations

| Go | Java |
| --- | --- |
| goroutines | `Thread.ofVirtual().start()` |
| channels | `LinkedBlockingQueue<T>` |
| select | `CompletableFuture.anyOf()` |
| sync.WaitGroup | `CountDownLatch` |
| sync.Mutex | `ReentrantLock` |
| sync/atomic | `AtomicLong` |
| maps | `LinkedHashMap<K,V>` |
| slices | `ArrayList<T>` |
| multiple return | `record` |
| defer | `try-finally` |
| panic/recover | `throw` / `try-catch` |

## Output Differences from Go

Some outputs differ structurally from the Go originals:

- **Arrays/lists:** Java prints `[a, b, c]` (commas); Go prints `[a b c]`
- **Maps:** Java prints `{k=v}`; Go prints `map[k:v]`
- **Floats:** Java uses `6.0E11`; Go uses `6e+11`
- **Month/weekday:** Java enums are uppercase (`NOVEMBER`); Go uses title case
- **Duration:** Java uses ISO-8601 (`PT144H`); Go uses custom format (`144h0m0s`)
- **Time strings:** Java uses ISO-8601; Go uses its own default format
- **Paths:** On Windows, Java uses `\`; Go uses `/`

Each lesson's `.md` file documents any differences in its description line.

## License

Original contributions by Jon Marcum are released under
[CC0 1.0 Universal](LICENSE).

Lesson content derived from
[Go by Example](https://github.com/mmcgrana/gobyexample) by Mark McGranaghan
is used under [Creative Commons Attribution 3.0](https://creativecommons.org/licenses/by/3.0/).
See [NOTICE](NOTICE) for full attribution.
