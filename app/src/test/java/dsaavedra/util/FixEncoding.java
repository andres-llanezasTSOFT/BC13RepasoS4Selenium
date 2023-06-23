package dsaavedra.util;

import java.nio.charset.StandardCharsets;

public class FixEncoding {
    public static String fix(String text){
        byte[]  utf8Bytes = text.getBytes(StandardCharsets.ISO_8859_1);
        return new String(utf8Bytes,StandardCharsets.UTF_8);
    }
}
