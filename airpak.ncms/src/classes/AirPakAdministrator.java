/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Matt
 */
public class AirPakAdministrator {
    private String firstName, lastName;
    private int trn;
    
    public AirPakAdministrator(String fname, String lname, int trn){
        firstName = fname;
        lastName = lname;
        this.trn = trn;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTrn() {
        return trn;
    }

    public void setTrn(int trn) {
        this.trn = trn;
    }
}
