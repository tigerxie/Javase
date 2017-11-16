package com.ericsson.upg.pattern.factory.method.example1;

public class ExportHtmlFactory implements ExportFactory {

    public ExportFile factory(String htmlType) {
        if (htmlType.equals("Standard")) {
            return new ExportStandardHtmlFile();
        } else if (htmlType.equals("Financial")) {
            return new ExportFinancialHtmlFile();
        }
        return null;
    }
}
