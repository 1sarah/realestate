package esta.hibernate.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "landlords")
public class Landlord extends BaseEntity{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;

    @Embedded
    private Person person;

    @Embedded
    private Contact contact;

    @OneToMany(mappedBy = "landlord",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Tenant> tenants = new ArrayList<Tenant>();

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

//    public List<Tenant> getTenants() {
//        return tenants;
//    }
//
//    public void setTenants(List<Tenant> tenants) {
//        this.tenants = tenants;
//    }
}
