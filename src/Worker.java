
import java.io.PrintStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author java
 */
public class Worker extends Person {
    
    private String company;
    private Number income;

    public Worker(int id, String givenName, String familyName, String emailAddress, String company, Number income) {
        super(id, givenName, familyName, emailAddress);
        this.company = company;
        this.income = income;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Number getIncome() {
        return income;
    }

    public void setIncome(Number income) {
        this.income = income;
    }

    public String toString() {
        return String.format(
                "Worker: %s %s, Address: %s %s, %s, %s, %s, %s, Work: %s $%s",
                getGivenName(),
                getFamilyName(),
                getStreetNumber(),
                getStreetName(),
                getLocality(),
                getRegion(),
                getCountry(),
                getPostcode(),
                getCompany(),
                getIncome()
        );
    }
    
}
