package com.countryside_culture.admin.demo.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 江西DJ烟仔
 * @createtime 2018/4/7 11:13.
 * @describe 文件下载工具类
 */
public class DownloadKit {

	/**
	 * 文件下载
	 *
	 * @param fileName
	 *            下载后的文件名
	 * @param sourcePath
	 *            文件相对路径
	 * @throws Exception
	 */
	public static boolean download(HttpServletResponse response, String sourcePath, String fileName) throws Exception {
		// 把FilePathKit.FILE_ROOT_PATH 换成你的项目根路径
		File sourceFile = new File(FilePathKit.FILE_ROOT_PATH + sourcePath);
		if (!sourceFile.exists()) {
			System.out.println("++" + FilePathKit.FILE_ROOT_PATH + sourcePath);
			throw new Exception("您下载的资源已不存在");
		}
		BufferedInputStream in = null;
		ServletOutputStream out = null;
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8"); // 解决下载文件名乱码
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			in = new BufferedInputStream(new FileInputStream(sourceFile));
			out = response.getOutputStream();
			byte[] buffer = new byte[1024 * 1024 * 10];
			int len = 0;
			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(fileName + " 下载出错,若有问题请与管理员联系");
		} finally {
			out.close();
			in.close();
		}
		return true;
	}
}
