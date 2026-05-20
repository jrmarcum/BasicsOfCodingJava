Java uses exceptions natively; this lesson uses a result record to mirror Go's explicit error return pattern alongside a custom exception class.

___

##### Run Command:
`java errors.java`

##### Results:
`f1 worked: 10`
`f1 failed: can't work with 42`
`f2 worked: 10`
`f2 failed: 42 - can't work with it`
`42`
`can't work with it`
