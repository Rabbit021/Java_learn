package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author wangheng
 * @version V1.0
 * @Package entity
 * @date 2020/3/1 14:56
 * @Copyright © 2016-2017 北京博锐尚格节能技术股份有限
 */
@Entity
@IdClass(EnegyItemId.class)
public class EnegyItem {

    @Id
    private String EnergySystemSign;
    @Id
    private String EnenrgyItemSign;

    private String EnergyItemName;
    private String ParentEnergyItemSign;

    public String getEnergySystemSign() {
        return EnergySystemSign;
    }

    public void setEnergySystemSign(String energySystemSign) {
        EnergySystemSign = energySystemSign;
    }

    public String getEnergyItemName() {
        return EnergyItemName;
    }

    public void setEnergyItemName(String energyItemName) {
        EnergyItemName = energyItemName;
    }

    public String getEnenrgyItemSign() {
        return EnenrgyItemSign;
    }

    public void setEnenrgyItemSign(String enenrgyItemSign) {
        EnenrgyItemSign = enenrgyItemSign;
    }

    public String getParentEnergyItemSign() {
        return ParentEnergyItemSign;
    }

    public void setParentEnergyItemSign(String parentEnergyItemSign) {
        ParentEnergyItemSign = parentEnergyItemSign;
    }
}

//Composite Primary Key
class EnegyItemId implements Serializable {
    private String EnergySystemSign;
    private String EnenrgyItemSign;

}