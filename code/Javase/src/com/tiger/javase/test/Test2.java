package com.tiger.javase.test;

import java.sql.DriverManager;

public class Test2
{
    public int aMethod(int i)throws Exception
    {
        try{
        	return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }
 
    public static void main(String [] args)
    {
        try
        {
//            aMethod(0);
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
    
    static class Child extends Test2{
    	void fun() throws Exception {
    		aMethod(0);
    		fun2();
    	}
    	static void fun2() {
    		
    	}
    }
}

