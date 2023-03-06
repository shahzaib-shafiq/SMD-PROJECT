package com.example.bscs_sec_a_batch_20_intentexamples.RecyclerViewExample;

public class MyMobile {

    String Name,Company,Price;

    public MyMobile(String name, String company, String price) {
        Name = name;
        Company = company;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
