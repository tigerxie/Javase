package com.tiger.io.file.modify;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;

public class BatchFilesModify {
//	private static final String dirPath = "D:\\Github\\Javase\\code\\JavaConcurrencyStudy\\src\\com\\tiger\\javase";
	private static final String dirPath = "D:\\Github\\Javase\\code\\JavaSE-Project\\src\\main\\java\\com\\tiger\\javase";
	private static final String oldContext = "com.ericsson.upg";
	private static final String newContext = "com.tiger.javase";
//	private static final String dirPath = "D:\Github\Javase\code\JavaConcurrencyStudy\src\com\tiger\concurrent\automic\ax.xml";
//	private static final String oldContext = "a";
//	private static final String newContext = "bb";
	public static void main(String[] args) {
		try {
			BatchFilesModify bfm = new BatchFilesModify();
			
			bfm.batchFilesModify(dirPath, oldContext, newContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void batchFilesModify(String dirPath, String oldContext, String newContext) throws IOException {
//		Files.walk(Paths.get(dirPath)).filter(Files::isRegularFile).forEach(System.out::println);
//		Files.find(Paths.get(dirPath), Integer.MAX_VALUE, (filePath, fileAttr)->fileAttr.isRegularFile()).forEach(System.out::println);
		Files.find(Paths.get(dirPath), Integer.MAX_VALUE, (filePath, fileAttr)->fileAttr.isRegularFile()).forEach(file -> {
			System.out.println(file);
			try {
				fileContentModify(file, oldContext, newContext);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
	}

	private void fileContentModify(Path path, String oldContext, String newContext) throws IOException {
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll(oldContext, newContext);
		Files.write(path, content.getBytes(charset));
	}
}
