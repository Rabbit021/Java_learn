import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author wangheng
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/2/29 11:35
 * @Copyright © 2016-2017 北京博锐尚格节能技术股份有限
 */
public class Startup {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setLastName("heng");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(customer);
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
