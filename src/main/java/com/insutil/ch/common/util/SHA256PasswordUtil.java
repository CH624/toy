package com.insutil.ch.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class SHA256PasswordUtil {
    private static final Logger logger = LoggerFactory.getLogger(SHA256PasswordUtil.class);
    private StringBuffer buffer = new StringBuffer();

    public String getPassword(String password) throws NoSuchAlgorithmException{
        try{
            buffer.delete(0, buffer.length());
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());

            byte[] bytes = messageDigest.digest();
            for(byte b : bytes){
                buffer.append(Integer.toString((b & 0xff) + 0x100,16).substring(1));
            }
        }catch (Exception e){
            logger.error("비밀번호 암호화 실패");
            throw new NoSuchAlgorithmException("비밀번호 암호화 실패", e);
        }
        return buffer.toString();
    }
}
