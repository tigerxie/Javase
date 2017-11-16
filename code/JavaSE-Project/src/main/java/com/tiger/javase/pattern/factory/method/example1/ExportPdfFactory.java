package com.ericsson.upg.pattern.factory.method.example1;

public class ExportPdfFactory implements ExportFactory {

    public ExportFile factory(String pdfType) {
        if (pdfType.equals("Standard")) {
            return new ExportStandardPdfFile();
        } else if (pdfType.equals("Financial")) {
            return new ExportFinancialPdfFile();
        }
        return null;
    }
}
