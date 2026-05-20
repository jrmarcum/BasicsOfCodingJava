import java.util.*;
import java.util.regex.*;

void main() {
    // Test whether a pattern matches a string
    System.out.println(Pattern.matches("p([a-z]+)ch", "peach"));

    // Compile a pattern for reuse
    var r = Pattern.compile("p([a-z]+)ch");

    // Match test
    System.out.println(r.matcher("peach").matches());

    // Find first match
    var m = r.matcher("peach punch");
    System.out.println(m.find() ? m.group() : "");

    // Find first match index
    m = r.matcher("peach punch");
    if (m.find()) {
        System.out.println("[" + m.start() + " " + m.end() + "]");
    }

    // FindStringSubmatch: whole match and first submatch
    m = r.matcher("peach punch");
    if (m.find()) {
        System.out.println("[" + m.group(0) + " " + m.group(1) + "]");
    }

    // FindStringSubmatchIndex: indexes of match and submatch
    m = r.matcher("peach punch");
    if (m.find()) {
        System.out.println("[" + m.start(0) + " " + m.end(0) + " " + m.start(1) + " " + m.end(1) + "]");
    }

    // FindAllString: all matches
    m = r.matcher("peach punch pinch");
    var allMatches = new ArrayList<String>();
    while (m.find()) allMatches.add(m.group());
    System.out.println(allMatches);

    // FindAllStringSubmatchIndex: all match+submatch indexes
    m = r.matcher("peach punch pinch");
    var allIndexes = new ArrayList<String>();
    while (m.find()) {
        allIndexes.add("[" + m.start(0) + " " + m.end(0) + " " + m.start(1) + " " + m.end(1) + "]");
    }
    System.out.println(allIndexes);

    // Limit to 2 matches
    m = r.matcher("peach punch pinch");
    var twoMatches = new ArrayList<String>();
    while (m.find() && twoMatches.size() < 2) twoMatches.add(m.group());
    System.out.println(twoMatches);

    // Match on bytes (equivalent)
    System.out.println(r.matcher("peach").matches());

    // MustCompile equivalent - Pattern.compile (throws on error)
    r = Pattern.compile("p([a-z]+)ch");
    System.out.println(r.pattern());

    // ReplaceAllString
    System.out.println(r.matcher("a peach").replaceAll("<fruit>"));

    // ReplaceAllFunc equivalent: uppercase matched text
    var result = r.matcher("a peach").replaceAll(mr -> mr.group().toUpperCase());
    System.out.println(result);
}
