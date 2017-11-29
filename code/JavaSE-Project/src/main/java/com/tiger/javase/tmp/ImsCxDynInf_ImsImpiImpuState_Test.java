/* 
 * Copyright (c) 2017 Ericsson AB, Sweden. 
 * All rights reserved. 
 * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.tmp;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ericsson.dve.user360.User360Exception;
import com.ericsson.dve.user360.analytics.config.impl.PreSourceConfig;
import com.ericsson.dve.user360.analytics.config.impl.SourceConfigHandler;
import com.ericsson.dve.user360.analytics.handler.TransactionHandler;
import com.ericsson.dve.user360.analytics.handler.TransactionHandlerImpl;
import com.ericsson.dve.user360.analytics.mock.TransactionBuilder;
import com.ericsson.dve.user360.analytics.parser.FreshDBSQL;
import com.ericsson.dve.user360.analytics.parser.Transaction;

public class ImsCxDynInf_ImsImpiImpuState_Test {

    public static final String CA_FILE_DIC = "CAFolder";
    private TransactionBuilder builder;
    private SourceConfigHandler handler;

    @Before
    public void setUp() throws User360Exception {
        User360ServiceManager.getInstance();
        PreSourceConfig.setSystemProperty(CA_FILE_DIC);
        handler = SourceConfigHandler.getInstance();
        handler.loadConfigurations();
    }

    @After
    public void tearDown() throws User360Exception {
        handler.reset();
    }

    /*
     * @Test public void testNormalInsertParse() { String dsgID = "2"; int result = 1; String mockInsertData =
     * "[EpsDynInf:insert:<ENTRY_KEY.int.14>,<EpsHomoImsVoip.varbinary." + result + ">]"; List<FreshDBSQL> freshDBSQLs = normalParse(mockInsertData, dsgID); for
     * (FreshDBSQL sql : freshDBSQLs) { Assert.assertTrue(sql.getSqlContent().equals(
     * "update EpsDynInf set EpsHomoImsVoip='Supported' where ENTRY_KEY=14 and DSG=2")); } }
     * 
     * @Test public void testNormalUpdateParse() { String dsgID = "2"; int result = 1; String mockInsertData =
     * "[EpsDynInf:update:<ENTRY_KEY.int.14>,<EpsHomoImsVoip.varbinary." + result + ">]"; List<FreshDBSQL> freshDBSQLs = normalParse(mockInsertData, dsgID); for
     * (FreshDBSQL sql : freshDBSQLs) { Assert.assertTrue(sql.getSqlContent().equals(
     * "update EpsDynInf set EpsHomoImsVoip='Supported' where ENTRY_KEY=14 and DSG=2")); } }
     */

    @Test
    public void testNormalDeleteParse() {
        String dsgID = "2";
        String mockInsertData = "[ImsCxDynInf_ImsImpiImpuState:delete:<MV_INDEX.int.1>,<ENTRY_KEY.int.14>]";
        List<FreshDBSQL> freshDBSQLs = normalParse(mockInsertData, dsgID);
        for (FreshDBSQL sql : freshDBSQLs) {
            Assert.assertTrue(sql.getSqlContent().equals("delete from ImsCxDynInf_ImsImpiImpuState where DSG = 2 and MV_INDEX = 1"));
        }
    }

    public List<FreshDBSQL> normalParse(String mockData, String dsgID) {
        List<FreshDBSQL> freshDBSQLs = new ArrayList<>();
        builder = new TransactionBuilder();
        Transaction transaction = builder.createTransaction(mockData);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(dsgID);
        try {
            freshDBSQLs = transactionHandler.handleTransaction(transaction);
            if (0 == freshDBSQLs.size()) {
                Assert.fail();
            }

        } catch (CloneNotSupportedException | User360Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return freshDBSQLs;
    }
}