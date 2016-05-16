package com.model2.mvc.service.security;
 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityUtil{

	
 private static final String key = "AES";
 public static Cipher cipher;
 public static SecretKeySpec skeySpec;
 public static SecretKeySpec keySpec;
 
 static{
  try{
	  
   KeyGenerator kgen = KeyGenerator.getInstance( key );
   kgen.init(128); // 192 and 256 bits may not be available
   SecretKey skey = kgen.generateKey();
   byte[] raw = skey.getEncoded();
   skeySpec = new SecretKeySpec(raw, "AES");
     
   cipher = Cipher.getInstance( key );
   
  }catch( Exception e){
   e.printStackTrace();
  }
 }
  
 public static byte[] Encrypt(String data, SecretKeySpec keySpec, Cipher cipher) throws Exception{
  // 암호화
  cipher.init(Cipher.ENCRYPT_MODE, keySpec); // 암호화 모드로 지정
  byte[] encrypted = cipher.doFinal(data.getBytes());
  return encrypted;
  }
 
 public static byte[] Decrypt(byte[] encrypted_data, SecretKeySpec keySpec, Cipher cipher) throws Exception{
  //복호화
  cipher.init(Cipher.DECRYPT_MODE, keySpec); // 복호화 모드로 지정
  byte[] decrypted = cipher.doFinal(encrypted_data);
  return decrypted;
 }
 
}
