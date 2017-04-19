package com.youzi.yuchou.core.text;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.youzi.yuchou.core.base.ExceptionUtil;

public class GzipUtil {

	/**
	 * Gzip 压缩
	 * @param text
	 * @return
	 */
	public static byte[] compress(String text) {
		byte[] bytes = null;
		ObjectOutputStream oos = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			GZIPOutputStream gzip = new GZIPOutputStream(out);
			gzip.write(text.getBytes("utf-8"));
			gzip.close();
			bytes = out.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					throw ExceptionUtil.unchecked(e.getCause());
				}
			}
		}
		return bytes;
	}

	/**
	 * Gzip 解压
	 * @param bytes
	 * @return
	 */
	public static String uncompress(byte[] bytes) {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			GZIPInputStream gzip = new GZIPInputStream(bi);
			int count;
			byte data[] = new byte[1024];
			while ((count = gzip.read(data, 0, 1024)) != -1) {
				out.write(data, 0, count);
			}
			return out.toString("utf-8");
		} catch (IOException e) {
			throw ExceptionUtil.unchecked(e.getCause());
		}
	}

}
