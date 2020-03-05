package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author wangheng
 * @version V1.0
 * @Package entity
 * @date 2020/3/1 14:40
 * @Copyright © 2016-2017 北京博锐尚格节能技术股份有限
 */
@Embeddable
public class Address implements Serializable {

    private String depart;
    private String name;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
}
