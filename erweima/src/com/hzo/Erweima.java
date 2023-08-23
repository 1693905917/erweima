package com.hzo;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * @author ASUS
 * @projectName erweima
 * @description: 二维码制作
 * @date 2021-09-28 17:00
 */
public class Erweima {
    //程序入口  相当于门口  固定格式
    public static void main(String[] args) {
        //1.尺寸
        //2.边距
        //3/容错等级，汉字的字符集【若二维码中有文字】
        //4.创建一个容器，用来装相应的配置参数
        HashMap map=new HashMap();
        map.put(EncodeHintType.MARGIN,2);//二维码外边框
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");//二维码内容的字符集设置

        //容错等级分为四级(L:7%)二维码损坏7%就扫不出来  M(15%)  Q(25%)  H(30%)
        //容错等价越来越大。扫描的时候效率越来越低
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);//设置二维码的容错等级
        //创建一个用来制作二维码的流（工具）
        MultiFormatWriter mfvw=new MultiFormatWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = mfvw.encode("龙学妹 少熬夜 你的路还长着", BarcodeFormat.QR_CODE,400,400,map);
            Path path=new File("D:/我的二维码.jpg").toPath();
            //使用工具放在指定的位置
            MatrixToImageWriter.writeToPath(bitMatrix,"jpg",path);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //告诉程序把二维码放在哪里  二维码的路劲



    }
}
