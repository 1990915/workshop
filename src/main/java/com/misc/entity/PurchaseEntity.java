package com.misc.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_SEQ_GEN")
    @SequenceGenerator(name = "PURCHASE_SEQ_GEN", sequenceName = "PURCHASE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PERSON_NATIONAL_CODE")
    private String personNationalCode;

    @Column(name = "INSERT_DATE")
    private Date insertDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonNationalCode() {
        return personNationalCode;
    }

    public void setPersonNationalCode(String personNationalCode) {
        this.personNationalCode = personNationalCode;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", personNationalCode='" + personNationalCode + '\'' +
                ", insertDate=" + insertDate +
                '}';
    }
}
