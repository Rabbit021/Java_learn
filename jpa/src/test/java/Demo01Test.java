import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Customer;
import entity.EnegyItem;
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
    public void testPrimaryKey() {
        EnegyItem enegyItem = new EnegyItem();
        enegyItem.setEnenrgyItemSign("sign");
        enegyItem.setEnergyItemName("name");
        enegyItem.setEnergySystemSign("1");
        enegyItem.setParentEnergyItemSign("1");

        entityManager.persist(enegyItem);

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

    @Test
    public void testJson() throws JsonProcessingException {
        Customer customer = new Customer();
        customer.setLastName("John");
        
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = objectMapper.writeValueAsString(customer);
        System.out.println(jsonString);

        Customer customer1 = objectMapper.readValue(jsonString, Customer.class);
        System.out.println(customer1.toString());

    }
}