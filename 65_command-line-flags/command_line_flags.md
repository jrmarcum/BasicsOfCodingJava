Java has no stdlib flag parser; this example implements manual flag parsing to match Go's `flag` package output.

___

##### Run Command:
`java command_line_flags.java -word=opt -numb=7 -fork -svar=flag`

##### Results:
`word: opt`
`numb: 7`
`fork: true`
`svar: flag`
`tail: []`
