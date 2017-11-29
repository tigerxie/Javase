package com.tiger.javase.tools.mysql;

public class SystemConfiguration {
    private int threadPoolSize;
    private int batchSize;
    private int currentThreadNumber;
    private String sql;
    private String url;
    private String user;
    private String password;

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getCurrentThreadNumber() {
        return currentThreadNumber;
    }

    public void setCurrentThreadNumber(int currentThreadNumber) {
        this.currentThreadNumber = currentThreadNumber;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public int getThreadPoolSize() {
        return threadPoolSize;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SystemConfiguration [threadPoolSize=" + threadPoolSize + ", batchSize=" + batchSize + ", currentThreadNumber=" + currentThreadNumber + ", sql="
                + sql + ", url=" + url + ", user=" + user + "]";
    }
}
