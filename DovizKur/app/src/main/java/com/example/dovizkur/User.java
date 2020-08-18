package com.example.dovizkur;

public class User {
    private String paraBirimiAlis;
    private String paraBirimiSatis;
    private String paraBirimi;
    private boolean paraArtis;



    public User(String paraBirimi, String paraBirimiAlis, String paraBirimiSatis, boolean paraArtis) {
        this.paraBirimiAlis = paraBirimiAlis;
        this.paraBirimiSatis = paraBirimiSatis;
        this.paraArtis=paraArtis;
        this.paraBirimi=paraBirimi;
    }
    public String getParaBirimiAlis() {
        return paraBirimiAlis;
    }

    public void setParaBirimiAlis(String paraBirimiAlis) {
        this.paraBirimiAlis = paraBirimiAlis;
    }

    public String getParaBirimiSatis() {
        return paraBirimiSatis;
    }

    public void setParaBirimiSatis(String paraBirimiSatis) {
        this.paraBirimiSatis = paraBirimiSatis;
    }

    public String getParaBirimi() {
        return paraBirimi;
    }

    public void setParaBirimi(String paraBirimi) {
        this.paraBirimi = paraBirimi;
    }

    public boolean isParaArtis() {
        return paraArtis;
    }

    public void setParaArtis(boolean paraArtis) {
        this.paraArtis = paraArtis;
    }

}