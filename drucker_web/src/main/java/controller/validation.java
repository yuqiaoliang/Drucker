package controller;

public class validation {
    private String status;

    public validation() {
        this.status = "false";
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "validation{" +
                "status='" + status + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
