Run the server in the background, then send data with netcat or telnet.

___

##### Run Command:
`java tcp_server.java &`
`echo "Hello from netcat" | nc localhost 8090`

##### Results:
`TCP server listening on :8090`
`ACK: HELLO FROM NETCAT`
