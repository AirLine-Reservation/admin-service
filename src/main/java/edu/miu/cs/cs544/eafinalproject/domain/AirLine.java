package edu.miu.cs.cs544.eafinalproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SecondaryTable(name = "history",pkJoinColumns = {@PrimaryKeyJoinColumn(name = "airline_id",referencedColumnName = "id")})
public class AirLine implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 2)
    private String code;
    private String name;
    @Column(table = "history")
    private String history;

     public AirLine(){}

    public AirLine(Integer id, String code, String name, String history) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.history = history;
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

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
