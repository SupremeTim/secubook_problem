import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
public class CryptoUtils {
     public byte[] encrypt(byte[] msg, Key k) {
          byte[] rslt = null;
          try {
               Cipher c = Cipher.getInstance(“AES/CBC/PKCS5Padding”);
               c.init(Cipher.ENCRYPT_MODE, k);
               rslt = c.update(msg);
          }
     }
}
