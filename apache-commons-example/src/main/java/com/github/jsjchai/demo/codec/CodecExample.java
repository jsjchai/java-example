package com.github.jsjchai.demo.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author jsjchai.
 */
public class CodecExample {

    /**
     * MD5加密
     */
    public void md5(){
        String md5 = DigestUtils.md5Hex("123456");
        System.out.println(md5);
    }

    /**
     * base64
     */
    public  void base64(){

        //加密
        String encode = Base64.encodeBase64String("123456".getBytes());

        //解密
        byte[] decode = Base64.decodeBase64(encode);
        System.out.println(new String(decode));
    }


}
