package main.java.com.sdajava.jpa_ostatnie.utility;

import main.java.com.sdajava.jpa_ostatnie.model.WorkerMon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static main.java.com.sdajava.jpa_ostatnie.utility.DataToList.lastNamesList;
import static main.java.com.sdajava.jpa_ostatnie.utility.DataToList.nameList;

public class MongoNoSql {

    private static EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    public static void mongoDoIt() {

        entityManager = Persistence
                .createEntityManagerFactory("WorkerMon")
                .createEntityManager();
        //entityManager = Persistence.createEntityManagerFactory("WorkerMon");

        //EntityManager
               // entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction()
                     .begin();

        for (int row = 1; row<=10000; row++) {
            int randomName = (int) (Math.random() * nameList.size());
            int randomLast = (int) (Math.random() * lastNamesList.size());

            WorkerMon worker =
                    new WorkerMon(row, nameList.get(randomName),
                            lastNamesList.get(randomLast), (long) Math.floor(row/2));
            entityManager.persist(worker);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
