package main.java.com.sdajava.jpa_ostatnie.utility;

import main.java.com.sdajava.jpa_ostatnie.model.Worker;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.ParseException;

import static main.java.com.sdajava.jpa_ostatnie.utility.DataToList.lastNamesList;
import static main.java.com.sdajava.jpa_ostatnie.utility.DataToList.nameList;

public class HibernateSqlInsert {

    public static boolean sqlInsertRow() throws ParseException {
        Session session = HibernateConnection.getHibernateSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            for (int row = 1; row<=10000; row++) {
                int randomName = (int) (Math.random() * nameList.size());
                int randomLast = (int) (Math.random() * lastNamesList.size());

                Worker worker =
                        new Worker(row, nameList.get(randomName)
                                , lastNamesList.get(randomLast), (long) Math.floor(row/2));
                session.save(worker);
            }
            tx.commit();
            return true;
        }
        catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
