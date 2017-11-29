package com.tiger.javase.clazz.traverse;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetClassName {

    public static void main(String[] args) throws ClassNotFoundException {
        List<String> classNames = getClassName("com.tiger.javase");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        for (String name : classNames) {
            System.out.println(name);
            Class<?> clazz = loader.loadClass(name);

            System.out.println(clazz.getName());
        }
    }

    private static List<String> getClassName(String packageName) {
        List<String> fileNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if (url != null) {
            fileNames = getClassNameByFile(url.getPath());
        }
        return fileNames;
    }

    private static List<String> getClassNameByFile(String filePath) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        for (File childFile : childFiles) {
            if (!childFile.isDirectory()) {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    childFilePath = childFilePath.substring(childFilePath.indexOf("classes") + 8, childFilePath.lastIndexOf(".class"));
                    childFilePath = childFilePath.replace("/", ".");
                    myClassName.add(childFilePath);
                }
            }
        }
        return myClassName;
    }
}
