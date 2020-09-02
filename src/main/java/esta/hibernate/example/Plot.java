package esta.hibernate.example;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "plots")
@DynamicInsert
@DynamicUpdate

public class Plot extends BaseEntity{

    @Embedded
    private static Contact contact;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Landlord landlords;

    @Column
    private String plot_no;


    public static Contact getContact() {
        return contact;
    }

    public static void setContact(Contact contact) {
        Plot.contact = contact;
    }

    public Landlord getLandlord() {
        return landlords;
    }

    public void setLandlord(Landlord landlord) {
        this.landlords = landlord;
    }

    public String getPlot_no(String s) {
        return plot_no;
    }

    public void setPlot_no(String plot_no) {
        this.plot_no = plot_no;
    }
}
