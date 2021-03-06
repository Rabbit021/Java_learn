package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author wangheng
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/2/29 16:55
 * @Copyright © 2016-2017 北京博锐尚格节能技术股份有限
 */


@Entity
@Table(name = "t_customer")
public class Customer {

    @Transient
    private Integer id;

    @Id
    private Address address;

    @Column(name = "LastName")
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address=" + address +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
