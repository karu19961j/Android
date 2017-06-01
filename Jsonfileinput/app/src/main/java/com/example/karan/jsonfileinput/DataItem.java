package com.example.karan.jsonfileinput;

public class DataItem {
    private String name;
    private String dep;
    private String company;

    public DataItem(String name, String dep, String company) {
        this.name = name;
        this.dep = dep;
        this.company = company;
    }

    public DataItem() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}
