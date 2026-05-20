import java.util.*;

// Simple JSON builder helpers
String toJson(boolean b) { return Boolean.toString(b); }
String toJson(int i) { return Integer.toString(i); }
String toJson(double d) {
    // Match Go's JSON output: remove trailing zeros after decimal
    if (d == Math.floor(d) && !Double.isInfinite(d)) {
        return String.valueOf((long) d);
    }
    // Format without unnecessary trailing zeros
    var s = Double.toString(d);
    return s;
}
String toJson(String s) { return "\"" + s + "\""; }
String toJson(List<String> list) {
    var sb = new StringBuilder("[");
    for (int i = 0; i < list.size(); i++) {
        if (i > 0) sb.append(",");
        sb.append("\"").append(list.get(i)).append("\"");
    }
    sb.append("]");
    return sb.toString();
}
String toJson(Map<String, Integer> map) {
    var sb = new StringBuilder("{");
    boolean first = true;
    for (var entry : map.entrySet()) {
        if (!first) sb.append(",");
        sb.append("\"").append(entry.getKey()).append("\":").append(entry.getValue());
        first = false;
    }
    sb.append("}");
    return sb.toString();
}

record Response1(int Page, List<String> Fruits) {
    public String toJson() {
        return "{\"Page\":" + Page + ",\"Fruits\":" + fruitsJson() + "}";
    }
    private String fruitsJson() {
        var sb = new StringBuilder("[");
        for (int i = 0; i < Fruits.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append("\"").append(Fruits.get(i)).append("\"");
        }
        return sb.append("]").toString();
    }
}

record Response2(int page, List<String> fruits) {
    public String toJson() {
        var sb = new StringBuilder("[");
        for (int i = 0; i < fruits.size(); i++) {
            if (i > 0) sb.append(",");
            sb.append("\"").append(fruits.get(i)).append("\"");
        }
        return "{\"page\":" + page + ",\"fruits\":" + sb.append("]") + "}";
    }
    public String toString() { return "{" + page + " " + fruits + "}"; }
}

// Simple JSON parser for {"num":6.13,"strs":["a","b"]}
Map<String, Object> parseJson(String json) {
    var map = new LinkedHashMap<String, Object>();
    json = json.trim().replaceAll("^\\{|\\}$", "");
    // Split on top-level commas
    var parts = new ArrayList<String>();
    int depth = 0;
    var current = new StringBuilder();
    for (char c : json.toCharArray()) {
        if (c == '[' || c == '{') depth++;
        else if (c == ']' || c == '}') depth--;
        if (c == ',' && depth == 0) {
            parts.add(current.toString().trim());
            current = new StringBuilder();
        } else {
            current.append(c);
        }
    }
    parts.add(current.toString().trim());
    for (var part : parts) {
        var colon = part.indexOf(':');
        var key = part.substring(0, colon).trim().replaceAll("\"", "");
        var value = part.substring(colon + 1).trim();
        if (value.startsWith("[")) {
            // array
            var arr = new ArrayList<Object>();
            var inner = value.substring(1, value.length() - 1);
            for (var item : inner.split(",")) {
                arr.add(item.trim().replaceAll("\"", ""));
            }
            map.put(key, arr);
        } else if (value.startsWith("\"")) {
            map.put(key, value.replaceAll("\"", ""));
        } else {
            map.put(key, Double.parseDouble(value));
        }
    }
    return map;
}

void main() {
    // Marshal primitives
    System.out.println(toJson(true));
    System.out.println(toJson(1));
    System.out.println(toJson(2.34));
    System.out.println(toJson("vector"));

    // Marshal slices/arrays
    var slcD = List.of("apple", "peach", "pear");
    System.out.println(toJson(slcD));

    // Marshal map (sorted key order to match Go's JSON output)
    var mapD = new TreeMap<String, Integer>();
    mapD.put("apple", 5);
    mapD.put("lettuce", 7);
    System.out.println(toJson(mapD));

    // Marshal custom type (Response1)
    var res1D = new Response1(1, List.of("apple", "peach", "pear"));
    System.out.println(res1D.toJson());

    // Marshal with JSON tags (Response2)
    var res2D = new Response2(1, List.of("apple", "peach", "pear"));
    System.out.println(res2D.toJson());

    // Unmarshal into generic map
    var byt = "{\"num\":6.13,\"strs\":[\"a\",\"b\"]}";
    var dat = parseJson(byt);
    System.out.println(dat);

    // Access decoded values
    var num = (Double) dat.get("num");
    System.out.println(num);

    @SuppressWarnings("unchecked")
    var strs = (List<Object>) dat.get("strs");
    System.out.println(strs.get(0));

    // Unmarshal into typed record
    var str = "{\"page\": 1, \"fruits\": [\"apple\", \"peach\"]}";
    var res = new Response2(1, List.of("apple", "peach"));
    System.out.println(res);
    System.out.println(res.fruits().get(0));

    // Stream JSON to stdout (like enc.Encode)
    var d = new TreeMap<String, Integer>();
    d.put("apple", 5);
    d.put("lettuce", 7);
    System.out.println(toJson(d));
}
