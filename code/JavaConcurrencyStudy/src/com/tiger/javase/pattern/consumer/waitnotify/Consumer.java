package com.ericsson.upg.pattern.consumer.waitnotify;

public class Consumer extends Thread {

	private int num;  
  
    private Storage storage;  
  
    public Consumer(Storage storage)  
    {  
        this.storage = storage;  
    }  
  
    public void run()  
    {  
        consume(num);  
    }  
  
    public void consume(int num)  
    {  
        storage.consume(num);  
    }  
  
    public int getNum()  
    {  
        return num;  
    }  
  
    public void setNum(int num)  
    {  
        this.num = num;  
    }  
  
    public Storage getStorage()  
    {  
        return storage;  
    }  
  
    public void setStorage(Storage storage)  
    {  
        this.storage = storage;  
    }  
}
