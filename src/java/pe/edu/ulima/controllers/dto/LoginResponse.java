package pe.edu.ulima.controllers.dto;

public class LoginResponse {
    private String msgStatus;
    private String msgError;

    public LoginResponse(String msgStatus, String msgError) {
        this.msgStatus = msgStatus;
        this.msgError = msgError;
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
}
