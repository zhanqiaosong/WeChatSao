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
 * @Description ��ά�����ɹ�����
 * @date 2017 5-29
 * @param getQrCodeImg���ɶ�ά��ķ���
 * @param content ��ά������
 * @param imgPath ��ά��·��
 */
public class QrCodeImg {
  public static String getQrCodeImg(String content,String imgPath){
	//ʵ����һ��QrCode����
			Qrcode qrCode = new Qrcode();//���ƶ�ά�����
			//���� N A K
			qrCode.setQrcodeEncodeMode('B');
			//�Ŵ��� 15% �ռ� �ռ� ��С
			qrCode.setQrcodeErrorCorrect('M');
			//�汾�� ͼƬ��С
			qrCode.setQrcodeVersion(15);
			int  width = 235;
			int  height = 235;
			//����
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			//���ƹ���
			Graphics2D gs = image.createGraphics();
		    //��ʼ����
			//����ɫ
			gs.setBackground(Color.white);
			gs.clearRect(0, 0, width, height);
			//����������ɫ
			gs.setColor(Color.green);
			//��ʼ������Ϣ
				byte[] codeBytes;
				try {
					codeBytes = content.getBytes("utf-8");
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				boolean[][] code = qrCode.calQrcode(codeBytes);
				int pix0ff = 2;   //����ƫ������ �����ÿ��ܻᵼ�½�������
	            for (int i = 0; i < code.length; i++) {  
	                for (int j = 0; j < code.length; j++) {  
	                    if (code[i][j]) {  
	                        gs.fillRect(j * 3 + pix0ff, i * 3 + pix0ff, 3, 3);  
	                    }  
	                }  
	            }
	            gs.dispose();
	            image.flush();
	            //���ɶ�ά��
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
