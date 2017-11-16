/* 
 * Copyright (c) 2017 Ericsson AB, Sweden. 
 * All rights reserved. 
 * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.tmp;

import java.util.List;

import com.ericsson.dve.logger.DGELogger;
import com.ericsson.dve.user360.User360Constants;
import com.ericsson.dve.user360.User360Exception;
import com.ericsson.dve.user360.analytics.User360ParserConstants;
import com.ericsson.dve.user360.analytics.annotation.ParserAnnotation;
import com.ericsson.dve.user360.analytics.change.impl.RowChangeType;
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
public class ExampleColumnParser2 extends AbstractColumnParser<List<ColumnChange>> {
    private static final DGELogger logger = User360DGELoggerFactory.getLogger(ExampleColumnParser2.class);

    public ExampleColumnParser2(FactoryType type) {
        super(type);
    }

    @Override
    public List<ColumnChange> parse(ColumnChange change) throws User360Exception {
        logger.info("parse begin.");
        List results = RecyclableArrayList.newInstance();
        String table = change.getColumn().getTable().getTableName();
        String type = null;
        RowChange row = change.getRowChange();
        if (row != null) {
            type = row.getType();
            if (type.equalsIgnoreCase(RowChangeType.INSERT.toString())) {
                type = RowChangeType.UPDATE.toString();
            }
        }

        Decoder current = null;
        Object result = null;
        Object columnChangevalue = change.getValue();
        if (!isNullObject(columnChangevalue) && !isEmptyObject(columnChangevalue)) {
            if (decoder == null) {
                String decoderType = getDecoderType(change.getColumn());
                if (decoderType != null) {
                    current = findDecoder(decoderType);
                }
            } else {
                current = decoder;
            }
            if (current != null) {
                result = current.decode(columnChangevalue);
            }
        }

        if (result != null && result instanceof List) {
            List<Object> out = (List<Object>) result;
            final int len = out.size();
            final ColumnChange[] changes = new ColumnChange[len / 2];
            for (int i = 0, j = 0; j < len; i++, j += 2) {
                Object c = out.get(j);
                Column col;
                String name = (String) c;
                String value = (String) out.get(j + 1);
                Column outc = AdaptionFactory.newColumn(change.getColumn().getTable(), name, value, User360ParserConstants.DATA_TYPE_VARCHAR);
                ColumnChange outChange = AdaptionFactory.newChange(outc, value, type, User360Constants.USER360_ANALYTICS_ADAPTIVE_ROW_TAG);
                results.add(outChange);
            }
            if (out instanceof RecyclableArrayList) {
                ((RecyclableArrayList) out).recycle();
            }
        } else {
            String value = (String) result;
            String name = change.getColumn().getName();
            Column outc = AdaptionFactory.newColumn(change.getColumn().getTable(), name, value, User360ParserConstants.DATA_TYPE_VARCHAR);
            ColumnChange outChange = AdaptionFactory.newChange(outc, value, type, User360Constants.USER360_ANALYTICS_ADAPTIVE_ROW_TAG);
            results.add(outChange);
        }

        return changeList;
    }

}