On Windows, paths use backslashes and `/dir/file` is not considered absolute (drive-relative); Go uses forward slashes and treats it as absolute.

___

##### Run Command:
`java file_paths.java`

##### Results:
`p: dir1\dir2\filename`
`dir1\filename`
`dir1\filename`
`Dir(p): dir1\dir2`
`Base(p): filename`
`false`
`false`
`.json`
`config`
`t\file`
`..\c\t\file`
