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
    private String fname, lname, cname, password;
    private String dob;

    public Agent(int trn, int phone, String fname, String lname, String password, String dob) {
        this.trn = trn;
        this.phone = phone;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        //newspaperArr = new Newspaper[numPaper];
    }
    
    public Agent(int trn, int phone, String cname, String fname, String lname, String password, String dob, int numPaper)
    {
        this.trn = trn;
        this.phone = phone;
        this.cname = cname;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        newspaperArr = new Newspaper[numPaper];
    }
    
    public Newspaper[] getNewspaperArr() {
        return newspaperArr;
    }

    public void setNewspaperArr(Newspaper[] newspaperArr) {
        this.newspaperArr = newspaperArr;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
