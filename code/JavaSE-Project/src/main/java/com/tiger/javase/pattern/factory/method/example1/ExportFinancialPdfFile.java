package com.ericsson.upg.pattern.factory.method.example1;

public class ExportFinancialPdfFile implements ExportFile {

    public void export() {
        System.out.println("financial pdf export.");
    }

}
