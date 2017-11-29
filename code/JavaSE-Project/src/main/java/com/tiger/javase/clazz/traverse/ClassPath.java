package com.tiger.javase.clazz.traverse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassPath {
    public static void main(String[] args) throws IOException {
        String rootPath = ClassLoader.getSystemResource(".").getPath();
        File rootFile = new File(rootPath.replace("%20", " "));
        for (String file : listFiles(rootFile, new ArrayList<String>())) {
            System.out.println(file);
        }

    }

    /**
     * ????????
     * 
     * @param rootFile
     * @param fileList
     * @throws IOException
     */
    public static List<String> listFiles(File rootFile, List<String> fileList) throws IOException {
        File[] allFiles = rootFile.listFiles();
        for (File file : allFiles) {
            if (file.isDirectory()) {
                listFiles(file, fileList);
            } else {
                String path = file.getCanonicalPath();
                String clazz = path.substring(path.indexOf("classes") + 8);
                fileList.add(clazz.replace("//", ".").substring(0, clazz.lastIndexOf(".")));
            }
        }
        return fileList;
    }
}
