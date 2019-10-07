package test;

import org.apache.log4j.Logger;

import java.sql.DriverManager;

public class TestConn {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(TestConn.class);
        String url = "jdbc:mysql://localhost:3306/web_customer_tracker?ssl=basic";
        String user = "springstudent";
        String pass = "springstudent";

        try {
            logger.info("connecting to database...");
            DriverManager.getConnection(url, user, pass);
            logger.info("connection successful!!!");
        } catch (Exception e) {
            logger.error("Connection failure: ",e);
        }
    }
}