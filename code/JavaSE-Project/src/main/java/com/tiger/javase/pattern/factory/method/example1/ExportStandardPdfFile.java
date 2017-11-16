package com.ericsson.upg.pattern.factory.method.example1;

public class ExportStandardPdfFile implements ExportFile {

    public void export() {
        System.out.println("standard pdf export.");
    }

}
