/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.user360.mbean;

import javax.management.Attribute;  
import javax.management.MBeanServer;  
import javax.management.MBeanServerFactory;  
import javax.management.ObjectName; 

public class StandardAgent {
    private MBeanServer mBeanServer = null;  
    public StandardAgent(){  
        mBeanServer = MBeanServerFactory.newMBeanServer();  
    }  
      
    public MBeanServer getMBeanServer(){  
        return mBeanServer;  
    }  
      
    public ObjectName createObjectName(String name){  
        ObjectName objectName = null;  
        try{  
            objectName = new ObjectName(name);  
        }catch(Exception e){  
        }  
        return objectName;  
    }  
    private void createStandardBean(ObjectName objectName, String managedResourceClassName){  
        try{  
            mBeanServer.createMBean(managedResourceClassName, objectName);  
        }catch(Exception e){}  
    }  
      
    public static  void main(String[] args){  
        StandardAgent agent = new StandardAgent();  
        MBeanServer mBeanServer = agent.getMBeanServer();  
        String domain = mBeanServer.getDefaultDomain();  
        String managedResourceClassName = "CarBean";  
        ObjectName objectName = agent.createObjectName("com.ericsson.upg.user360.mbean" + ":type=" + managedResourceClassName);  
        System.out.println("objectName: " + objectName);  
        agent.createStandardBean(objectName, managedResourceClassName);  
          
        try{  
            Attribute colorAttribute = new Attribute("Color", "blue");  
            mBeanServer.setAttribute(objectName, colorAttribute);  
            System.out.println(mBeanServer.getAttribute(objectName, "Color"));  
            mBeanServer.invoke(objectName, "drive", null, null);  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
}