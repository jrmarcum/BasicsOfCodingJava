Java uses a hand-rolled test runner (no external deps) that matches Go's `go test -v` output format; requires `javac` compilation first.

___

##### Run Command:
`javac IntMinTest.java && java IntMinTest`

##### Results:
`=== RUN   TestIntMinBasic`
`--- PASS: TestIntMinBasic (0.00s)`
`=== RUN   TestIntMinTableDriven`
`=== RUN   TestIntMinTableDriven/0,1`
`    --- PASS: TestIntMinTableDriven/0,1 (0.00s)`
`=== RUN   TestIntMinTableDriven/1,0`
`    --- PASS: TestIntMinTableDriven/1,0 (0.00s)`
`=== RUN   TestIntMinTableDriven/2,-2`
`    --- PASS: TestIntMinTableDriven/2,-2 (0.00s)`
`=== RUN   TestIntMinTableDriven/0,-1`
`    --- PASS: TestIntMinTableDriven/0,-1 (0.00s)`
`=== RUN   TestIntMinTableDriven/-1,0`
`    --- PASS: TestIntMinTableDriven/-1,0 (0.00s)`
`--- PASS: TestIntMinTableDriven (0.00s)`
`PASS`
`ok  	IntMinTest	0.000s`
