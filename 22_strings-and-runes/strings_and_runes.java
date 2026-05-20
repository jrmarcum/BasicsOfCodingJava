import java.nio.charset.StandardCharsets;

void examineCodePoint(int cp) {
    if (cp == 't') {
        System.out.println("found tee");
    } else if (cp == 'ส') {
        System.out.println("found so sua");
    }
}

void main() {
    String s = "สวัสดี";

    byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
    System.out.println("Len: " + bytes.length);

    for (byte b : bytes) {
        System.out.printf("%x ", b & 0xff);
    }
    System.out.println();

    long runeCount = s.codePoints().count();
    System.out.println("Rune count: " + runeCount);

    int[] codePoints = s.codePoints().toArray();
    int byteOffset = 0;
    for (int cp : codePoints) {
        System.out.printf("U+%04X '%c' starts at %d%n", cp, (char) cp, byteOffset);
        byteOffset += new String(Character.toChars(cp)).getBytes(StandardCharsets.UTF_8).length;
    }

    System.out.println();
    System.out.println("Using DecodeRuneInString");

    byteOffset = 0;
    for (int cp : s.codePoints().toArray()) {
        System.out.printf("U+%04X '%c' starts at %d%n", cp, (char) cp, byteOffset);
        examineCodePoint(cp);
        byteOffset += new String(Character.toChars(cp)).getBytes(StandardCharsets.UTF_8).length;
    }
}
