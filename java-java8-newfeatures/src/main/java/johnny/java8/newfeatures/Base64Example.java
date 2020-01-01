package johnny.java8.newfeatures;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

public class Base64Example {
    public static void main(String args[]) {
        try {
            // Original
            String original = "jojozhuang.github.io?java8";
            System.out.println("Original String: " + original);

            // Encode using basic encoder
            String strEncoded = Base64.getEncoder().encodeToString(
                    original.getBytes("utf-8"));
            System.out.println("Base64 Encoded String (Basic) :" + strEncoded);

            // Decode
            byte[] base64decodedBytes = Base64.getDecoder().decode(strEncoded);
            System.out.println("Decoded String: " + new String(base64decodedBytes, "utf-8"));
            strEncoded = Base64.getUrlEncoder().encodeToString(
                    original.getBytes("utf-8"));
            System.out.println("Base64 Encoded String (URL) :" + strEncoded);

            // MIME Example
            String uuid = UUID.randomUUID().toString();
            System.out.println("Original UUID: " + uuid);
            byte[] mimeBytes = uuid.getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("Base64 Encoded String (MIME) :" + mimeEncodedString);

            base64decodedBytes = Base64.getDecoder().decode(mimeEncodedString);
            System.out.println("Decoded UUID: " + new String(base64decodedBytes, "utf-8"));

        } catch(UnsupportedEncodingException e) {
            System.out.println("Error :" + e.getMessage());
        }
    }
}
