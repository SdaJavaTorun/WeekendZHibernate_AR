package main.java.com.sdajava.jpa_ostatnie;

import main.java.com.sdajava.jpa_ostatnie.utility.HibernateSqlInsert;
import main.java.com.sdajava.jpa_ostatnie.utility.JdbcSqlInsert;
import main.java.com.sdajava.jpa_ostatnie.utility.MongoNoSql;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code here
        long startTime = System.currentTimeMillis();
        //JdbcSqlInsert.sqlInsertRow();
        long endTime = System.currentTimeMillis();
        System.out.println("Czas wykonania JDBC: " + (endTime - startTime));

        long startTimeHib = System.currentTimeMillis();
        //HibernateSqlInsert.sqlInsertRow();
        long endTimeHib = System.currentTimeMillis();
        System.out.println("Czas wykonania Hiber: " + (endTimeHib - startTimeHib));

        long startTimeMon = System.currentTimeMillis();
        MongoNoSql.mongoDoIt();
        long endTimeMon = System.currentTimeMillis();
        System.out.println("Czas wykonania Mongo: " + (endTimeMon - startTimeMon));
    }
}
