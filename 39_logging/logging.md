Timestamps vary each run; Java uses `java.util.logging` and manual JSON formatting to stderr.

___

##### Run Command:
`java logging.java`

##### Results:
`2026-05-20T03:27:18.929020500Z standard logger`
`2026-05-20T03:27:18.932531100Z with micro`
`2026-05-20T03:27:18.932531100Z logging:main: with file/line`
`my:2026-05-20T03:27:18.936530200Z from mylog`
`ohmy:2026-05-20T03:27:18.936530200Z from mylog`
`from buflog:buf:2026-05-20T03:27:18.936530200Z hello`
`{"time":"2026-05-20T03:27:18.937529300Z","level":"INFO","msg":"hi there"}`
`{"time":"2026-05-20T03:27:18.937529300Z","level":"INFO","msg":"hello again","key":"val","age":25}`
