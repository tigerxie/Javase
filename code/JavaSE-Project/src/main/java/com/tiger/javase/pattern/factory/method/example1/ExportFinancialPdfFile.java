package com.tiger.javase.pattern.factory.method.example1;

public class ExportFinancialPdfFile implements ExportFile {

    public void export() {
        System.out.println("financial pdf export.");
    }

}
