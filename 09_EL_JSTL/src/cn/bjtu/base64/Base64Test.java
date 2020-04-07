package cn.bjtu.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @author shkstart
 * @create 2020-03-16 11:40
 */
public class Base64Test {
    public static void main(String[] args) throws Exception {
        String content = "这是需要base64编码的内容";
        //创建一个Base64编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //执行Base64编码操作
        String encode = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println(encode);

        // 创建Base64解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] buffer = base64Decoder.decodeBuffer(encode);
        String str = new String(buffer,"UTF-8");
        System.out.println(str);
    }
}
