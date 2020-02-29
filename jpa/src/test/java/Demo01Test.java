import entity.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author wangheng
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/2/29 20:25
 * @Copyright © 2016-2017 北京博锐尚格节能技术股份有限
 */
public class Demo01Test {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {

        //获取EntityManager
        entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    public void save() {
        Customer customer = new Customer();
        customer.setLastName("John");

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        // 保存数据貌似是要在事务里面
        entityManager.persist(customer);
        transaction.commit();
    }
}