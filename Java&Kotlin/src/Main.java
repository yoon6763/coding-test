import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String text = "ktko";
        byte[] targetBytes = text.getBytes();

        // Base64 인코딩 ///////////////////////////////////////////////////
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(targetBytes);

        // Base64 디코딩 ///////////////////////////////////////////////////
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode("IyBCYXNlYmFsbEdhbWUK7J6Q67CUIFN3aW5n7J2EIOyCrOyaqe2VmOyXrCDs\\noJzsnpHtlZwg7Iir7J6Q7JW86rWs6rKM7J6ECg==");

        System.out.println("인코딩 전 : " + text);
        System.out.println("인코딩 text : " + new String(encodedBytes));
        System.out.println("디코딩 text : " + new String(decodedBytes));
    }
}
