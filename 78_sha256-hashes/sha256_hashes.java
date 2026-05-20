import java.security.*;

void main() throws Exception {
    var s = "sha256 this string";
    var h = MessageDigest.getInstance("SHA-256");
    h.update(s.getBytes());
    var bs = h.digest();
    System.out.println(s);
    var hex = new StringBuilder();
    for (byte b : bs) hex.append(String.format("%02x", b));
    System.out.println(hex);
}
