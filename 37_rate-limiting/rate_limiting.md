Timestamps vary each run; first 3 bursty requests fire immediately, remaining are rate-limited at 200ms intervals.

___

##### Run Command:
`java rate_limiting.java`

##### Results:
`request 1 2026-05-20T03:27:16.801553500Z`
`request 2 2026-05-20T03:27:17.001001800Z`
`request 3 2026-05-20T03:27:17.202154700Z`
`request 4 2026-05-20T03:27:17.401210Z`
`request 5 2026-05-20T03:27:17.600522Z`
`request 1 2026-05-20T03:27:17.601528700Z`
`request 2 2026-05-20T03:27:17.601528700Z`
`request 3 2026-05-20T03:27:17.601528700Z`
`request 4 2026-05-20T03:27:17.802235400Z`
`request 5 2026-05-20T03:27:18.003043300Z`
