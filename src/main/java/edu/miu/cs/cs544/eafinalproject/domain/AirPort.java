package edu.miu.cs.cs544.eafinalproject.domain;

import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AirPort implements Serializable {

    @Id
    @GeneratedValue
    private  Integer id;

    @Column(length =  3, nullable = false)
    private String code;
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;

    public AirPort(){}

    public AirPort(Integer id, String code, String name, Address address) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
