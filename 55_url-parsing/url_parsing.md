Java's URI splits userInfo manually; query map prints as `{k:[v]}` vs Go's `map[k:[v]]`.

___

##### Run Command:
`java url_parsing.java`

##### Results:
`postgres`
`user:pass`
`user`
`pass`
`host.com:5432`
`host.com`
`5432`
`/path`
`f`
`k=v`
`{k:[v]}`
`v`
