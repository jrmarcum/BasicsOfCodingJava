Run the server in the background, then make a request with curl. The server demonstrates context cancellation via CompletableFuture.orTimeout().

___

##### Run Command:
`java context.java &`
`curl localhost:8090/hello`

##### Results:
`server: hello handler started`
`server: hello handler ended`
