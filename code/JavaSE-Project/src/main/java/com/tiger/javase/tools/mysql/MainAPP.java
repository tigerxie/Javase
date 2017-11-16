package com.ericsson.upg.tools.mysql;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainAPP {
    private static String defaultThreadPoolSize = "10";
    private static String defautlBatchSize = "10";
    // private final static String defaultSql = "update mscIdentities set mscId = 'aaaaaaaaaaaaa1000000000000000001'";
    // String sql ="insert into mscIdentities values(1,6871397,'aaaaaaaaaaaaa1000000000000779635',262280000779635,49280779635,'UserName779635_0@ericsson.se')";
    // String sql = "delete from mscIdentities";
    private final static String defaultSql = "select * from mscIdentities ";
    private final static String driver = "com.mysql.jdbc.Driver";
    private final static String defaultUrl = "jdbc:mysql://10.170.11.73:3306/cudb_user_data?useSSL=false";
    private final static String defaultUser = "canal";
    private final static String defaultPassword = "canal";
    private SystemConfiguration systemConfig = new SystemConfiguration();

    static {
        // Configure language for proper logging outputs
        Locale.setDefault(Locale.US);
        System.setProperty("user.country", Locale.US.getCountry());
        System.setProperty("user.language", Locale.US.getLanguage());
        System.setProperty("user.variant", Locale.US.getVariant());

        // Configure log4j
        if (System.getProperty("log4j.configuration") == null) {
            // URL url = MainAPP.class.getResource("/src/META-INF/log4j.xml");
            // System.out.println(url);
            URL url2 = MainAPP.class.getResource("/META-INF/log4j.xml");

            System.out.println(url2);
            // DOMConfigurator.configure(url2);
            // System.setProperty("log4j.configuration", url2.toString());
        }

        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        MainAPP app = new MainAPP();
        app.init();
        app.execute();

    }

    private void init() {

        systemConfig.setThreadPoolSize(Integer.valueOf(System.getProperty("thread", defaultThreadPoolSize)));
        systemConfig.setBatchSize(Integer.valueOf(System.getProperty("batch", defautlBatchSize)));
        systemConfig.setSql(System.getProperty("sql", defaultSql));
        systemConfig.setUrl(System.getProperty("url", defaultUrl));
        systemConfig.setUser(System.getProperty("user", defaultUser));
        systemConfig.setPassword(System.getProperty("password", defaultPassword));

    }

    private void execute() {

        Runnable runnableTarget = null;
        if (systemConfig.getSql().trim().startsWith("select")) {
            runnableTarget = new DBQuery(systemConfig);
        } else {
            runnableTarget = new DBExecute(systemConfig);
        }

        int threadPoolSize = Integer.valueOf(systemConfig.getThreadPoolSize());
        ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);

        for (int i = 0; i < threadPoolSize; i++) {
            systemConfig.setCurrentThreadNumber(i);
            threadPool.execute(runnableTarget);

            try {
                Thread.sleep(50);// 1s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();

    }

}

class DBQuery implements Runnable {

    private SystemConfiguration systemConfig;

    public DBQuery(SystemConfiguration sConfig) {
        this.systemConfig = sConfig;
    }

    public void run() {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(systemConfig.getUrl(), systemConfig.getUser(), systemConfig.getPassword());

            if (null == conn) {
                System.out.println("get  connect error!");
                return;
            }

            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database!");
            }

            Statement statement = conn.createStatement();
            rs = statement.executeQuery(systemConfig.getSql());

            if (null == rs) {
                System.out.println("get  statement error!");
                return;
            }
            int count = 0;
            while (rs.next()) {
                count++;
                // System.out.println(rs.getString(8));
            }

            statement.close();
            System.out.println("number is " + count);
            try {
                Thread.sleep(10000);// 500s
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        }

    }
}

class DBExecute implements Runnable {

    private SystemConfiguration systemConfig;

    public DBExecute(SystemConfiguration sConfig) {
        this.systemConfig = sConfig;
    }

    public void run() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(systemConfig.getUrl(), systemConfig.getUser(), systemConfig.getPassword());

            if (null == conn) {
                System.out.println("get  connect error!");
                return;
            }

            if (!conn.isClosed()) {
                System.out.println("Succeeded connecting to the Database " + systemConfig.getCurrentThreadNumber());
            }
            conn.setAutoCommit(false);

            int iLoop = 0;

            while (true) {
                PreparedStatement statement = conn.prepareStatement(systemConfig.getSql());

                statement.executeUpdate();

                if (iLoop % systemConfig.getBatchSize() == 0) {
                    conn.commit();
                    System.out.println("execute success." + iLoop);
                }
                statement.close();
                iLoop++;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                if (null != conn) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }
            }

        }
    }
}
