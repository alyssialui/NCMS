/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Kris
 */
public class Route {
    private String startPoint, endPoint;
    private Agent agent;

    public Route(String startPoint, String endPoint, Agent agent) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.agent = agent;
    }
    
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    
}
