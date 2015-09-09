package pe.edu.ulima.controllers.dto;

import java.util.List;
import pe.edu.ulima.model.beans.Drone;

public class ObtenerDronesResponse {
    private String msgStatus;
    private String msgError;
    private List<Drone> drones;

    public ObtenerDronesResponse() {
    }

    public ObtenerDronesResponse(String msgStatus, String msgError, List<Drone> drones) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
        this.drones = drones;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public List<Drone> getDrones() {
        return drones;
    }

    public void setDrones(List<Drone> drones) {
        this.drones = drones;
    }
    
    
}
