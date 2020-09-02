package esta.hibernate.example;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "house")
@DynamicInsert
@DynamicUpdate
public class House extends BaseEntity{

    @Embedded
    private Contact contact;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Tenant tenant;

    @Column
    private String house_no;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getHouse_no(String s) {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }
}
