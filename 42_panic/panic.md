Java throws RuntimeException instead of panic. Output differs — Java prints an exception stack trace to stderr and exits with code 1.

___

##### Run Command:
`java panic.java`

##### Results:
`Exception in thread "main" java.lang.RuntimeException: a problem`
`	at panic.main(panic.java:2)`
