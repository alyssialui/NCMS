/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.lang.reflect.Array;
import java.util.Date;

/**
 *
 * @author Kris
 */
public class Agent {
    private int trn, phone;
    private Newspaper[] newspaperArr;
    private String fname, lname, password;
    private Date dob;

    public Agent(int trn, int phone, String fname, String lname, String password, Date dob,int numPaper) {
        this.trn = trn;
        this.phone = phone;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        newspaperArr = new Newspaper[numPaper];
    }
    
    public void addNewspaperToArray(Newspaper[] papers){
        newspaperArr = papers;
    }
    
    public int getTrn() {
        return trn;
    }

    public void setTrn(int trn) {
        this.trn = trn;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
