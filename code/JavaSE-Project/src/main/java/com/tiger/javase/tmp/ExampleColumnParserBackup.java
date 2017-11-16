/* 
 * Copyright (c) 2017 Ericsson AB, Sweden. 
 * All rights reserved. 
 * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.dve.user360.analytics.columnparser.impl;

import java.util.List;
import java.util.Random;

import com.ericsson.dve.logger.DGELogger;
import com.ericsson.dve.user360.User360Constants;
import com.ericsson.dve.user360.User360Exception;
import com.ericsson.dve.user360.analytics.User360ParserConstants;
import com.ericsson.dve.user360.analytics.annotation.ParserAnnotation;
import com.ericsson.dve.user360.analytics.change.impl.RowChangeType;
import com.ericsson.dve.user360.analytics.config.impl.SourceConfigImpl;
import com.ericsson.dve.user360.analytics.decoder.Decoder;
import com.ericsson.dve.user360.analytics.factory.AdaptionFactory;
import com.ericsson.dve.user360.analytics.factory.FactoryType;
import com.ericsson.dve.user360.analytics.log.User360DGELoggerFactory;
import com.ericsson.dve.user360.analytics.parser.AbstractColumnParser;
import com.ericsson.dve.user360.analytics.parser.Column;
import com.ericsson.dve.user360.analytics.parser.ColumnChange;
import com.ericsson.dve.user360.analytics.parser.RowChange;

import io.netty.util.internal.RecyclableArrayList;

@ParserAnnotation(name = "EXAMPLE_PARSER")
public class ExampleColumnParserBackup extends AbstractColumnParser<List<ColumnChange>> {
    private static final DGELogger logger = User360DGELoggerFactory.getLogger(ExampleColumnParserBackup.class);
    private static Random random = new Random();

    public ExampleColumnParserBackup(FactoryType type) {
        super(type);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<ColumnChange> parse(ColumnChange change) throws User360Exception {
        logger.info("parse begin.");
        List results = RecyclableArrayList.newInstance();
        String type = null;
        RowChange row = change.getRowChange();
        if (row != null) {
            type = getNormalColumnType(row.getType(), change.getColumn().getTable().getTableName());
        }
        Decoder current = null;
        if (decoder == null) {
            String decoderType = getDecoderType(change.getColumn());
            if (decoderType != null) {
                current = findDecoder(decoderType);
            }
        } else {
            current = decoder;
        }

        Object result = change.getValue();
        if (null == result) {
            return results;
        }

        if (result instanceof byte[]) {
            result = new String((byte[]) result);
        }
        if (result instanceof String) {
            if (((String) result).length() > 2) {
                result = ((String) result).substring(0, 2) + "P" + String.valueOf(random.nextInt(10));
            } else {
                result = ((String) result) + "P" + String.valueOf(random.nextInt(10));
            }
        }
        if (current != null) {
            result = current.decode(result);
        }
        String value = (String) result;
        String name = change.getColumn().getName();
        Column outc = AdaptionFactory.newColumn(change.getColumn().getTable(), name, value, User360ParserConstants.DATA_TYPE_VARCHAR);
        ColumnChange outChange = AdaptionFactory.newChange(outc, value, type, User360Constants.USER360_ANALYTICS_ADAPTIVE_ROW_TAG);
        results.add(outChange);
        logger.info("parse end.");
        return results;
    }

    private String getNormalColumnType(String type, String tableName) {
        if ((new SourceConfigImpl()).isTableMultipleValue(tableName)) {
            return type;
        } else {
            String outputType = RowChangeType.UPDATE.toString();
            if (type.toUpperCase().equals(RowChangeType.DELETE.toString())) {
                outputType = RowChangeType.DELETE.toString();
            }
            return outputType;
        }
    }
}