package esta.hibernate.example;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tenants")
@DynamicInsert
@DynamicUpdate
public class Tenant extends BaseEntity{


    @Embedded
    private Person person;

    @Embedded
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="landlord_id", referencedColumnName = "id")
    private Landlord landlord;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

//    public Landlord getLandlord() {
//        return landlord;
//    }
//
//    public void setLandlord(Landlord landlord) {
//        this.landlord = landlord;
//    }
}
