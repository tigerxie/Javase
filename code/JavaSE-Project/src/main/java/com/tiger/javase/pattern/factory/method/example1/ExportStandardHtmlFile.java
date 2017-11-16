package com.ericsson.upg.pattern.factory.method.example1;

public class ExportStandardHtmlFile implements ExportFile {

    public void export() {
        System.out.println("standard html export.");
    }

}
