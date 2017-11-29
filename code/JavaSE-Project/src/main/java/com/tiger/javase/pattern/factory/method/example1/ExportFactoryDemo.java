package com.tiger.javase.pattern.factory.method.example1;

public class ExportFactoryDemo {
    public static void main(String[] args) {
        ExportHtmlFactory exportHtmlFactory = new ExportHtmlFactory();
        ExportFile exportFile = exportHtmlFactory.factory("Standard");
        exportFile.export();
    }
}
