package net.valsorya94.FamilyOfCompaniesTEST.model;

import javax.persistence.*;

/**
 * Created by Valsorya94 on 03.07.2017.
 */

@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @Column(name = "ID_OF_COMPANY")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfCompany;

    @Column(name = "NAME_OF_COMPANY")
    private String nameOfCompany;

    @Column(name = "ANNUAL_INCOME")
    private int annualIncome;


    public int getIdOfCompany() {
        return idOfCompany;
    }

    public void setIdOfCompany(int idOfCompany) {
        this.idOfCompany = idOfCompany;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Company() {
    }

    public Company(int idOfCompany, String nameOfCompany, int annualIncome) {
        this.idOfCompany = idOfCompany;
        this.nameOfCompany = nameOfCompany;
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idOfCompany=" + idOfCompany +
                ", nameOfCompany='" + nameOfCompany + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}
