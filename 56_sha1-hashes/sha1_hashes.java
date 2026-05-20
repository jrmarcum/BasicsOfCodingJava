import java.security.MessageDigest;

void main() throws Exception {
    String s = "sha1 this string";
    MessageDigest h = MessageDigest.getInstance("SHA-1");
    byte[] bs = h.digest(s.getBytes());
    System.out.println(s);
    StringBuilder sb = new StringBuilder();
    for (byte b : bs) sb.append(String.format("%02x", b));
    System.out.println(sb);
}
