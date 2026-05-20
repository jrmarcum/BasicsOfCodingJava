import java.util.*;

record Plant(int id, String name, List<String> origin) {
    public String toString() {
        return "Plant id=" + id + ", name=" + name + ", origin=" + origin;
    }

    public String toXml(String indent) {
        var sb = new StringBuilder();
        sb.append(indent).append("<plant id=\"").append(id).append("\">\n");
        sb.append(indent).append("  <name>").append(name).append("</name>\n");
        for (var o : origin) {
            sb.append(indent).append("  <origin>").append(o).append("</origin>\n");
        }
        sb.append(indent).append("</plant>");
        return sb.toString();
    }
}

Plant unmarshalPlant(String xml) {
    int id = Integer.parseInt(xml.replaceAll("(?s).*id=\"(\\d+)\".*", "$1"));
    String name = xml.replaceAll("(?s).*<name>(.*?)</name>.*", "$1");
    var origins = new ArrayList<String>();
    var matcher = java.util.regex.Pattern.compile("<origin>(.*?)</origin>").matcher(xml);
    while (matcher.find()) origins.add(matcher.group(1));
    return new Plant(id, name, origins);
}

void main() {
    var coffee = new Plant(27, "Coffee", List.of("Ethiopia", "Brazil"));

    // Marshal: print XML
    System.out.println(coffee.toXml(" "));

    // With XML header
    System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    System.out.println(coffee.toXml(" "));

    // Unmarshal
    var p = unmarshalPlant(coffee.toXml(" "));
    System.out.println(p);

    var tomato = new Plant(81, "Tomato", List.of("Mexico", "California"));

    // Nesting
    var sb = new StringBuilder();
    sb.append(" <nesting>\n");
    sb.append("   <parent>\n");
    sb.append("     <child>\n");
    sb.append(coffee.toXml("       ")).append("\n");
    sb.append(tomato.toXml("       ")).append("\n");
    sb.append("     </child>\n");
    sb.append("   </parent>\n");
    sb.append(" </nesting>");
    System.out.println(sb);
}
