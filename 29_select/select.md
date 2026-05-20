Go's select is simulated with CompletableFuture.anyOf(), receiving whichever channel resolves first.

___

##### Run Command:
`java select.java`

##### Results:
`received one`
`received two`
