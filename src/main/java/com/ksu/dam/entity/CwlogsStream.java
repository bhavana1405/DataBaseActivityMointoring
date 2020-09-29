package com.ksu.dam.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cw_logs_stream")
public class CwlogsStream {

    @Id
    @Column(name="id")
    private int id ;

    @Column(name="atype")
    private String atype ;

    @Column(name="ts")
    private int ts ;

    @Column(name="remote_ip")
    private String remoteIP;

    @Column(name = "user")
    private String user;

    @Column(name = "auth_user")
    private String authUser ;

    @Column(name = "mechanism")
    private String mechanism ;

    @Column(name = "success")
    private String success ;



    @Column(name = "message")
    private String message ;

    @Column(name = "error")
    private String error ;

    @Column(name = "active_indicator")
    private String activeIndicator ;

    @Column(name = "ddl_events")
    private String ddlEvents ;


    public CwlogsStream() {
    }

    public CwlogsStream(int id, String atype, int ts, String remoteIP, String user, String authUser, String mechanism, String success, String message, String error, String activeIndicator, String ddlEvents) {
        this.id = id;
        this.atype = atype;
        this.ts = ts;
        this.remoteIP = remoteIP;
        this.user = user;
        this.authUser = authUser;
        this.mechanism = mechanism;
        this.success = success;
        this.message = message;
        this.error = error;
        this.activeIndicator = activeIndicator;
        this.ddlEvents = ddlEvents;
    }

    public CwlogsStream(String activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public int getTs() {
        return ts;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAuth_user() {
        return authUser;
    }

    public void setAuth_user(String auth_user) {
        this.authUser = auth_user;
    }

    public String getMechanism() {
        return mechanism;
    }

    public void setMechanism(String mechanism) {
        this.mechanism = mechanism;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public String getDdlEvents() {
        return ddlEvents;
    }

    public void setDdlEvents(String ddlEvents) {
        this.ddlEvents = ddlEvents;
    }

    @Override
    public String toString() {
        return "CwlogsStream{" +
                "id=" + id +
                ", atype='" + atype + '\'' +
                ", ts=" + ts +
                ", remoteIP='" + remoteIP + '\'' +
                ", user='" + user + '\'' +
                ", authUser='" + authUser + '\'' +
                ", mechanism='" + mechanism + '\'' +
                ", success='" + success + '\'' +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                ", activeIndicator='" + activeIndicator + '\'' +
                ", ddlEvents='" + ddlEvents + '\'' +
                '}';
    }
}
