package com.ericsson.upg.pattern.factory.method.example1;

public class ExportFinancialHtmlFile implements ExportFile {

    public void export() {
        System.out.println("financial html export.");
    }
}
