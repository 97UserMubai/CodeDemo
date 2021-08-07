package com.boot.entity;

import java.util.Date;

public class DeviceAlarmInfo {
    private Long pkid;

    private String treekey;

    private Long deviceid;

    private String ruleid;

    private String type;

    private String mode;

    private String name;

    private Integer htime;

    private String crtPsn;

    private Date crtTm;

    private String udtPsn;

    private Date udtTm;

    private String delIdr;

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public String getTreekey() {
        return treekey;
    }

    public void setTreekey(String treekey) {
        this.treekey = treekey == null ? null : treekey.trim();
    }

    public Long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Long deviceid) {
        this.deviceid = deviceid;
    }

    public String getRuleid() {
        return ruleid;
    }

    public void setRuleid(String ruleid) {
        this.ruleid = ruleid == null ? null : ruleid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getHtime() {
        return htime;
    }

    public void setHtime(Integer htime) {
        this.htime = htime;
    }

    public String getCrtPsn() {
        return crtPsn;
    }

    public void setCrtPsn(String crtPsn) {
        this.crtPsn = crtPsn == null ? null : crtPsn.trim();
    }

    public Date getCrtTm() {
        return crtTm;
    }

    public void setCrtTm(Date crtTm) {
        this.crtTm = crtTm;
    }

    public String getUdtPsn() {
        return udtPsn;
    }

    public void setUdtPsn(String udtPsn) {
        this.udtPsn = udtPsn == null ? null : udtPsn.trim();
    }

    public Date getUdtTm() {
        return udtTm;
    }

    public void setUdtTm(Date udtTm) {
        this.udtTm = udtTm;
    }

    public String getDelIdr() {
        return delIdr;
    }

    public void setDelIdr(String delIdr) {
        this.delIdr = delIdr == null ? null : delIdr.trim();
    }
}