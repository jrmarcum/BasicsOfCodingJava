import java.util.Base64;

void main() {
    String data = "abc123!?$*&()'-=@~";

    String sEnc = Base64.getEncoder().encodeToString(data.getBytes());
    System.out.println(sEnc);

    String sDec = new String(Base64.getDecoder().decode(sEnc));
    System.out.println(sDec);
    System.out.println();

    String uEnc = Base64.getUrlEncoder().encodeToString(data.getBytes());
    System.out.println(uEnc);
    String uDec = new String(Base64.getUrlDecoder().decode(uEnc));
    System.out.println(uDec);
}
