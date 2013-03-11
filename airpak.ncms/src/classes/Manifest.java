/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import sun.management.resources.agent;

/**
 *
 * @author Kris
 */
public class Manifest {
    private int id;
    private ArrayList <Agent> agents;
    private TruckDriver driver;
    private String hubAddress;
    private Newspaper[] papers;

    public Manifest(int id, TruckDriver driver, String hubAddress, int numPapers) {
        this.id = id;
        this.driver = driver;
        this.hubAddress = hubAddress;
        agents = new ArrayList();
        papers = new Newspaper[numPapers];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Agent> getAllAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }
    
    public void addAgent (Agent agent){
        agents.add(agent);
    }
    
    public Agent getAgent (int trn){
        for(int i=0; i<agents.size(); i++){
            if (agents.get(i).getTrn() == trn){
                return agents.get(i);
            }
        }
        return null;
    }
    
    public boolean deleteAgent (int trn){
        for(int i=0; i<agents.size(); i++){
            if (agents.get(i).getTrn() == trn){
                agents.remove(i);
                return true;
            }
        }
        return false;
    }

    public TruckDriver getDriver() {
        return driver;
    }

    public void setDriver(TruckDriver driver) {
        this.driver = driver;
    }

    public String getHubAddress() {
        return hubAddress;
    }

    public void setHubAddress(String hubAddress) {
        this.hubAddress = hubAddress;
    }   
    
    public Newspaper[] getPapers() {
        return papers;
    }

    public void setPapers(Newspaper[] papers) {
        this.papers = papers;
    }
    
    public void addPaper (Newspaper paper, int i)
    {
        papers[i] = paper;
    }
    
}
