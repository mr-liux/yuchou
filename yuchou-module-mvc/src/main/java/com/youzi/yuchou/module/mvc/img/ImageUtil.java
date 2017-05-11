package com.youzi.yuchou.module.mvc.img;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


/**
 * 图片修理工具类
 * 
 * @author LIUXUAN
 * 
 */
public class ImageUtil {
	

	/**
	 * * 图片文件读取
	 * 
	 * @param srcImgPath
	 * @return
	 */
	public static BufferedImage InputImage(String srcImgPath)
			throws RuntimeException {

		BufferedImage srcImage = null;
		FileInputStream in = null;
		try {
			// 构造BufferedImage对象
			File file = new File(srcImgPath);
			in = new FileInputStream(file);
			byte[] b = new byte[5];
			in.read(b);
			srcImage = javax.imageio.ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取图片文件出错！", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException("读取图片文件出错！", e);
				}
			}
		}
		return srcImage;
	}

	/**
	 * 图片剪切工具方法
	 * 
	 * @param srcfile
	 *            源图片
	 * @param outfile
	 *            剪切之后的图片
	 * @param x
	 *            剪切顶点 X 坐标
	 * @param y
	 *            剪切顶点 Y 坐标
	 * @param width
	 *            剪切区域宽度
	 * @param height
	 *            剪切区域高度
	 * 
	 * @throws IOException
	 * @author cevencheng
	 */
	public static void cut(File srcfile, File outfile, int x, int y, int width,
			int height) throws IOException {
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			// 读取图片文件
			is = new FileInputStream(srcfile);
			
			//获取图片后缀
			String fileName=srcfile.getName();
	        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
			
			/*
			 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
			 * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
			 */
			Iterator<ImageReader> it = ImageIO
					.getImageReadersByFormatName(prefix);
			ImageReader reader = it.next();
			// 获取图片流
			iis = ImageIO.createImageInputStream(is);

			/*
			 * <p>iis:读取源.true:只向前搜索 </p>.将它标记为 ‘只向前搜索’。
			 * 此设置意味着包含在输入源中的图像将只按顺序读取，可能允许 reader 避免缓存包含与以前已经读取的图像关联的数据的那些输入部分。
			 */
			reader.setInput(iis, true);

			/*
			 * <p>描述如何对流进行解码的类<p>.用于指定如何在输入时从 Java Image I/O
			 * 框架的上下文中的流转换一幅图像或一组图像。用于特定图像格式的插件 将从其 ImageReader 实现的
			 * getDefaultReadParam 方法中返回 ImageReadParam 的实例。
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/*
			 * 图片裁剪区域。Rectangle 指定了坐标空间中的一个区域，通过 Rectangle 对象
			 * 的左上顶点的坐标（x，y）、宽度和高度可以定义这个区域。
			 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// 提供一个 BufferedImage，将其用作解码像素数据的目标。
			param.setSourceRegion(rect);

			/*
			 * 使用所提供的 ImageReadParam 读取通过索引 imageIndex 指定的对象，并将 它作为一个完整的
			 * BufferedImage 返回。
			 */
			BufferedImage bi = reader.read(0, param);

			// 保存新图片
			ImageIO.write(bi, prefix, outfile);
		} finally {
			if (is != null) {
				is.close();
			}
			if (iis != null) {
				iis.close();
			}
		}
	}

	/**
	 * * 将图片按照指定的图片尺寸、图片质量压缩
	 * 
	 * @param srcImgPath
	 *            :源图片路径
	 * @param outImgPath
	 *            :输出的压缩图片的路径
	 * @param new_w
	 *            :压缩后的图片宽
	 * @param new_h
	 *            :压缩后的图片高
	 * @param per
	 *            :百分比
	 * @author cevencheng
	 */
	public static void resize(String srcImgPath, String outImgPath, int new_w,
			int new_h, float per) {
		// 得到图片
		BufferedImage src = InputImage(srcImgPath);
		int old_w = src.getWidth();
		// 得到源图宽
		int old_h = src.getHeight();
		// 得到源图长
		// 根据原图的大小生成空白画布
		BufferedImage tempImg = new BufferedImage(old_w, old_h,
				BufferedImage.TYPE_INT_RGB);
		// 在新的画布上生成原图的缩略图
		Graphics2D g = tempImg.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, old_w, old_h);
		g.drawImage(src, 0, 0, old_w, old_h, Color.white, null);
		g.dispose();
		BufferedImage newImg = new BufferedImage(new_w, new_h,
				BufferedImage.TYPE_INT_RGB);
		newImg.getGraphics().drawImage(
				tempImg.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH), 0,
				0, null);
		// 调用方法输出图片文件
		outImage(outImgPath, newImg, per);
	}

	/**
	 * * 将图片文件输出到指定的路径，并可设定压缩质量
	 * 
	 * @param outImgPath
	 * @param newImg
	 * @param per
	 * @author cevencheng
	 */
	private static void outImage(String outImgPath, BufferedImage newImg,
			float per) {
		// 判断输出的文件夹路径是否存在，不存在则创建
		File file = new File(outImgPath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		// 输出到文件流
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outImgPath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(fos);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(newImg);
			// 压缩质量
			jep.setQuality(per, true);
			encoder.encode(newImg, jep);
			fos.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	/**
	 * 前台显示图片
	 * 
	 * @param url
	 *            图片地址 ReturnLine=收益折线 Avatars=用户头像
	 * @param name
	 *            图片名称
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void getMap(String url, String name,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		try {

			// FileInputStream hFile = new
			// FileInputStream("/picture/"+url+"/"+name); // 以byte流的方式打开文件
			FileInputStream hFile = new FileInputStream(
					"F://picture//ioc+png//yuantu//Koala.jpg"); // 以byte流的方式打开文件
																// // d:\1.gif

			int i = hFile.available(); // 得到文件大小

			byte data[] = new byte[i];

			hFile.read(data); // 读数据

			hFile.close();

			response.setContentType("image/png"); // 设置返回的文件类型

			OutputStream toClient = response.getOutputStream(); // 得到向客户端输出二进制数据的对象

			toClient.write(data); // 输出数据

			toClient.close();

		}

		catch (IOException e) // 错误处理

		{

			PrintWriter toClient = response.getWriter(); // 得到向客户端输出文本的对象

			response.setContentType("text/html;charset=UTF-8");

			toClient.write("无法打开图片!");

			toClient.close();

		}

	}

	/**
	 * 截取图片为正方向边长为i
	 * 
	 * @param srcImg
	 *            //原图片地址
	 * @param tarDir
	 *            //新图片地址
	 * @param i
	 */
	public static void imageJiequ(String srcImg, String tarDir, int i) {
		i = 600;
		// String srcImg = "F://picture//ioc+png//yuantu//Koala.jpg"; //原图片地址
		// String tarDir = "F://picture//ioc+png//jianqieandyasuo//Koala.jpg";
		// //新图片地址
		File srcfile = new File(srcImg);
		File outfile = new File(tarDir);
		BufferedImage bufferedImage = InputImage(srcImg);
		System.out.println(srcfile.exists() + ", dir=" + srcfile.getParent());
		tarDir = srcfile.getParent();
		srcImg = srcfile.getPath();
		System.out.println("srcImg=" + srcImg);
		long startTime = new Date().getTime();
		System.out.println(srcfile);

		// 计算要截取图片的宽度与高度
		int width = bufferedImage.getWidth(); // 原图宽度
		int height = bufferedImage.getHeight(); // 原图高度
		if (width < height && width < i) {
			i = width;
		}
		if (height < width && height < i) {
			i = height;
		}
		if (height == width && height < i) {
			i = height;
		}
		int x = width / 2 - i / 2;
		int y = height / 2 - i / 2;

		try {
			cut(srcfile, outfile, x, y, i, i); // 以左上角为（0，0）坐标
		} catch (IOException e) {
			e.printStackTrace();
		}
		imgQuality(tarDir, "jq");
		System.out.println(new Date().getTime() - startTime);
	}

	/********************************************** 压缩图片 ************************/

	private static Boolean DEFAULT_FORCE = false;
	private static String DEFAULT_THUMB_PREVFIX = "thumb_"; // 新图片前缀

	/**
	 * <p>
	 * Title: thumbnailImage
	 * </p>
	 * <p>
	 * Description: 根据图片路径生成缩略图
	 * </p>
	 * 
	 * @param imagePath
	 *            原图片路径
	 * @param w
	 *            缩略图宽
	 * @param h
	 *            缩略图高
	 * @param prevfix
	 *            生成缩略图的前缀
	 * @param force
	 *            是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
	 */
	public static void thumbnailImage(File srcImg, OutputStream output, int w, int h,
			String prevfix, boolean force) {
		if (srcImg.exists()) {
			try {
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				String types = Arrays.toString(ImageIO.getReaderFormatNames())
						.replace("]", ",");
				String suffix = null;
				// 获取图片后缀
				if (srcImg.getName().indexOf(".") > -1) {
					suffix = srcImg.getName().substring(
							srcImg.getName().lastIndexOf(".") + 1);
				}// 类型和图片后缀全部小写，然后判断后缀是否合法
				if (suffix == null
						|| types.toLowerCase().indexOf(
								suffix.toLowerCase() + ",") < 0) {
					return;
				}
				Image img = ImageIO.read(srcImg);
				// 根据原图与要求的缩略图比例，找到最合适的缩略图比例
				if (!force) {
					int width = img.getWidth(null);
					int height = img.getHeight(null);
					if ((width * 1.0) / w < (height * 1.0) / h) {
						if (width > w) {
							h = Integer.parseInt(new java.text.DecimalFormat(
									"0").format(height * w / (width * 1.0)));
						}
					} else {
						if (height > h) {
							w = Integer.parseInt(new java.text.DecimalFormat(
									"0").format(width * h / (height * 1.0)));
						}
					}
				}
				BufferedImage bi = new BufferedImage(w, h,
						BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics();
				g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
				g.dispose();
				// 将图片保存在原目录并加上前缀
				ImageIO.write(bi, suffix, output);
				output.close();
			} catch (IOException e) {
			}
		} else {
		}
	}

	public static void thumbnailImage(File srcImg, String outPath , int w, int h, String prevfix,
			boolean force) {
		try {
			
			System.out.println(outPath);
			thumbnailImage(srcImg, new java.io.FileOutputStream(outPath), w, h, prevfix, force);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	public static void thumbnailImage(String imagePath, String outPath , int w, int h, String prevfix,
			boolean force) {
		File srcImg = new File(imagePath);
		thumbnailImage(srcImg, outPath , w, h, prevfix, force);
	}

	public static void thumbnailImage(String imagePath , String outPath , int w, int h, boolean force) {
		thumbnailImage(imagePath, outPath , w, h, DEFAULT_THUMB_PREVFIX, DEFAULT_FORCE);
	}

	public static void thumbnailImage(String imagePath , String outPath , int w , int h) {
		thumbnailImage(imagePath, outPath , w, h, DEFAULT_FORCE);
	}
	
	/**
	 * 缩略图
	 * @param srcImg 原图地址
	 * @param outPath 缩略后的图片地址
	 */
	public static String imageYasuo(String srcImg , String outPath) {
		//如果W>H，要缩略的H不变，W根据原图的W/H比例计算出要缩略的大小    
		//如果W<h，要缩略的W不变，H根据原图的W/H比例计算出H的大小
		int i = 700;
//		srcImg = "http://img3.imgtn.bdimg.com/it/u=1284416964,1606791513&fm=21&gp=0.jpg";
//		outPath = "F://picture//ioc+png//jianqieandyasuo//";
//		
		BufferedImage bufferedImage = InputImage(srcImg);  //读取图片信息
		int w = bufferedImage.getWidth();
		int h = bufferedImage.getHeight();
		//当原图为正方形的时候
		if (w == h) {
			if (w < i) {
				thumbnailImage(srcImg , outPath , w, h);
			}else{
				thumbnailImage(srcImg , outPath , i, i);
			}
		}
		//如果W>H，要缩略的H不变，W根据原图的W/H比例计算出要缩略的大小    
		if (w > h) {
			if (h > i) {
				thumbnailImage(srcImg , outPath , i, i);
			}else{
				thumbnailImage(srcImg , outPath , w, h);
			}
		}
		//如果W<h，要缩略的W不变，H根据原图的W/H比例计算出H的大小
		if (w < h) {
			if (w > i) {
				thumbnailImage(srcImg , outPath , i, i);
			}else{
				thumbnailImage(srcImg , outPath , w, h);
			}
		}
		imgQuality(outPath, "ys");
		return null;
	}

	/**
	 * 压缩图片
	 * 
	 * @param srcImg
	 * @param tarDir
	 * @param i
	 */
	public static void imageYasuo(String srcImg, String tarDir, int i) {
//		i = 600;
		// String srcImg = "C://Users//LIUYONG//Desktop//图片//Tulips.jpg";
		// //原图片地址
		// String tarDir = "C://Users//LIUYONG//Desktop//图片//Tulips_1.jpg";
		// //新图片地址
//		File srcfile = new File(srcImg);
		// File outfile = new File(tarDir);
//		BufferedImage bufferedImage = InputImage(srcImg);
//		System.out.println(srcfile.exists() + ", dir=" + srcfile.getParent());
//		tarDir = srcfile.getParent();
//		srcImg = srcfile.getPath();
//		System.out.println("srcImg=" + srcImg);

//		resize(srcImg, tarDir, i, i, 1F);

	}
	/**
	 * 获取新图片并改变其质量
	 * @param outUrl
	 */
	public static void imgQuality(String outUrl , String type){
		try {
			File picture = new File(outUrl);
			BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
			String a = (String.format("%.1f", picture.length() / 1024.0));
			System.out.println(String.format("%.1f", picture.length() / 1024.0));
			
			float b  = Float.parseFloat(a);
			System.out.println(b);
			float c = 0 ;
			if (type.equals("ys")) {
				if (b > 300) {
					System.out.println("大于300");
					c = 300/b-0.1F;
					System.out.println(c);
					resize(outUrl, outUrl, sourceImg.getWidth(), sourceImg.getHeight(),c);
				}else if(b < 300){
					System.out.println("小于300不操作");
				}
			}else if(type.equals("jq")){
				if (b > 120) {
					System.out.println("大于120");
					c = 120/b-0.1F;
					System.out.println(c);
					resize(outUrl, outUrl, sourceImg.getWidth(), sourceImg.getHeight(),c);
				}else if(b < 120){
					System.out.println("小于120不操作");
				}
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
