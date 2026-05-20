import java.util.*;

// Java has no built-in text/template package; this example implements
// simple {{.}} and {{.FieldName}} substitution to match Go's output.

String applyTemplate(String tmpl, Object data) {
    if (tmpl.contains("{{.}}")) {
        String value;
        if (data instanceof List<?> list) {
            value = "[" + String.join(" ", list.stream().map(Object::toString).toList()) + "]";
        } else {
            value = String.valueOf(data);
        }
        return tmpl.replace("{{.}}", value);
    }
    if (data instanceof Map<?,?> map) {
        var result = tmpl;
        for (var entry : map.entrySet()) {
            result = result.replace("{{." + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        }
        return result;
    }
    return tmpl;
}

void main() {
    // t1: Value: {{.}}\n — string, integer, slice
    System.out.println(applyTemplate("Value: {{.}}", "some text"));
    System.out.println(applyTemplate("Value: {{.}}", 5));
    System.out.println(applyTemplate("Value: {{.}}", List.of("Go", "Rust", "C++", "C#")));

    // t2: Name: {{.Name}}\n — struct-like map
    System.out.println(applyTemplate("Name: {{.Name}}", Map.of("Name", "Jane Doe")));
    System.out.println(applyTemplate("Name: {{.Name}}", Map.of("Name", "Mickey Mouse")));

    // t3: if/else — truthy check (non-empty string → yes, empty → no)
    System.out.println("not empty".isEmpty() ? "no " : "yes ");
    System.out.println("".isEmpty() ? "no " : "yes ");

    // t4: range — iterate and print each element
    System.out.print("Range: ");
    for (var lang : List.of("Go", "Rust", "C++", "C#")) System.out.print(lang + " ");
    System.out.println();
}
