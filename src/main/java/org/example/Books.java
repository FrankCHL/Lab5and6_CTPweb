package org.example;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Books implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type")
    private String Type;

    @Column(name = "Vender")
    private String vender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String age) {
        this.Type = age;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }
}
