Java prints args with comma-space separators `[a, b, c]`; Go uses spaces `[a b c]`. Java has no argv[0] equivalent so the filename is simulated.

___

##### Run Command:
`java command_line_arguments.java a b c d`

##### Results:
`[command_line_arguments, a, b, c, d]`
`[a, b, c, d]`
`c`
