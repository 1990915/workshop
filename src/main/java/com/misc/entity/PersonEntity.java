package com.misc.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GEN")
    @SequenceGenerator(name = "PERSON_SEQ_GEN", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "INSERT_DATE")
    private Date insertDate;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FAMILY")
    private String family;

    @Column(name = "ADDRESS")
    private String address;


    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", nationalCode='" + nationalCode + '\'' +
                ", insertDate=" + insertDate +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
