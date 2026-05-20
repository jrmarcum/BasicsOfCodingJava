Java uses printf/String.format for formatting. Struct representation uses record toString; pointer output uses identityHashCode (varies per run). Output differs from Go in type name, struct syntax, and pointer value.

___

##### Run Command:
`java string_formatting.java`

##### Results:
`{1 2}`
`{x:1 y:2}`
`Point{x:1, y:2}`
`Point`
`true`
`123`
`1110`
`!`
`1c8`
`78.900000`
`1.234000e+08`
`1.234000E+08`
`"string"`
`"\"string\""`
`6865782074686973`
`0x<hashcode>`
`|    12|   345|`
`|  1.20|  3.45|`
`|1.20  |3.45  |`
`|   foo|     b|`
`|foo   |b     |`
`a string`
`an error`
