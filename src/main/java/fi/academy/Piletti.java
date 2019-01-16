package fi.academy;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Piletti {

    @Id
    @GeneratedValue
    public long id;
    public String title;
    public String category;
    public Integer price;
    public String district;
    public String info;
    public String contact;
    public Date paivays;
    public Time klo;
    public Integer generatedcode;

    public Piletti(long id, String title, String category, Integer price, String district, String info, String contact, Date starttime, Integer generatedcode) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.district = district;
        this.info = info;
        this.contact = contact;
        this.paivays = paivays;
        this.klo = klo;
        this.generatedcode = generatedcode;
    }

    public Integer getGeneratedcode() {
        return generatedcode;
    }

    public void setGeneratedcode(Integer generatedcode) {
        this.generatedcode = generatedcode;
    }

    public Piletti(){
    }

    public Date getPaivays() {
        return paivays;
    }

    public void setPaivays(Date paivays) {
        this.paivays = paivays;
    }

    public Time getKlo() {
        return klo;
    }

    public void setKlo(Time klo) {
        this.klo = klo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
