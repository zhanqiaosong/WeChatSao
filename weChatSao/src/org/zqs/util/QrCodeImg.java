package org.zqs.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * 
 * @author zqs
 * @Description 二维码生成工具类
 * @date 2017 5-29
 * @param getQrCodeImg生成二维码的方法
 * @param content 二维码内容
 * @param imgPath 二维码路径
 */
public class QrCodeImg {
  public static String getQrCodeImg(String content,String imgPath){
	//实例化一个QrCode对象
			Qrcode qrCode = new Qrcode();//绘制二维码的类
			//编码 N A K
			qrCode.setQrcodeEncodeMode('B');
			//排错率 15% 空间 空间 大小
			qrCode.setQrcodeErrorCorrect('M');
			//版本号 图片大小
			qrCode.setQrcodeVersion(15);
			int  width = 235;
			int  height = 235;
			//画板
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//绘制工具
			Graphics2D gs = image.createGraphics();
		    //开始绘制
			//背景色
			gs.setBackground(Color.white);
			gs.clearRect(0, 0, width, height);
			//设置内容颜色
			gs.setColor(Color.green);
			//开始处理信息
				byte[] codeBytes;
				try {
					codeBytes = content.getBytes("utf-8");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				boolean[][] code = qrCode.calQrcode(codeBytes);
				int pix0ff = 2;   //设置偏移量， 不设置可能会导致解析错误
	            for (int i = 0; i < code.length; i++) {  
	                for (int j = 0; j < code.length; j++) {  
	                    if (code[i][j]) {  
	                        gs.fillRect(j * 3 + pix0ff, i * 3 + pix0ff, 3, 3);  
	                    }  
	                }  
	            }
	            gs.dispose();
	            image.flush();
	            //生成二维码
			String imageName = "2Dma.png";
			try {
				OutputStream outStream = new FileOutputStream(new File(imgPath,imageName));
			    ImageIO.write(image, "png", outStream);
			    outStream.close();
			    return imageName;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
  }
}
