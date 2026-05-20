import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

void main() throws Exception {
    String s = "postgres://user:pass@host.com:5432/path?k=v#f";
    URI u = new URI(s);

    System.out.println(u.getScheme());

    System.out.println(u.getUserInfo());
    String[] userPass = u.getUserInfo().split(":", 2);
    System.out.println(userPass[0]);
    System.out.println(userPass[1]);

    System.out.println(u.getHost() + ":" + u.getPort());
    System.out.println(u.getHost());
    System.out.println(u.getPort());

    System.out.println(u.getPath());
    System.out.println(u.getFragment());

    String rawQuery = u.getRawQuery();
    System.out.println(rawQuery);

    Map<String, String[]> m = new LinkedHashMap<>();
    for (String param : rawQuery.split("&")) {
        String[] kv = param.split("=", 2);
        m.put(kv[0], new String[]{kv[1]});
    }
    System.out.println(m.entrySet().stream()
        .map(e -> e.getKey() + ":[" + e.getValue()[0] + "]")
        .reduce("{", (a, b) -> a + (a.equals("{") ? "" : ", ") + b) + "}");
    System.out.println(m.get("k")[0]);
}
