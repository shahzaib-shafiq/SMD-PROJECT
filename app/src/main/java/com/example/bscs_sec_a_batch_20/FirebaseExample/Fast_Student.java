package com.example.bscs_sec_a_batch_20.FirebaseExample;

public class Fast_Student {

    String Id,Name,City;


    public Fast_Student(String id, String name, String city) {
        Id = id;
        Name = name;
        City = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
