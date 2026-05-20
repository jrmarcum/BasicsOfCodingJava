Exits immediately with status 3; Java shutdown hooks DO run on System.exit() but none are registered here to match Go's behavior.

___

##### Run Command:
`java exit.java; echo "exit status $?"`

##### Results:
`exit status 3`
