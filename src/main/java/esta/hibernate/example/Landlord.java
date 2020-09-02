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

//    @OneToMany(mappedBy = "landlords",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Plot> plots = new ArrayList<Plot>();


    public Person getPerson() {
        return person;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

//    public List<Plot> getPlots() {
//        return plots;
//    }
//
//    public void setPlots(List<Plot> plots) {
//        this.plots = plots;
//    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


}
