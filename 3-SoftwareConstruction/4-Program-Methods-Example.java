package com.lab9.airclearchecker.entity;

import jakarta.persistence.*;

@Entity
public class AirClear{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "password")
    private String password;
    @Column(name = "location")
    private String location;
    @Column(name = "air_clear ")
    private String airClear ;
    //method
    public String getAirClearInfo(String user, String password, String location) {
        String result = "";
        if ( password.length() > 20 || password.length() < 6 || !user.matches("^[a-zA-Z\\s]+$") || user.isBlank() || location.length() > 10) {
            result = "-1";
        }
        result = """
                        Your town in general now has excellent air quality.
                        The level of air pollution at the moment meets all norms and safety standards. 
                        You can enjoy fresh air and safe living conditions.
                        Air Clear = 80 %
                    """;
        return result;
    }

    public AirClear(String password, String location, String airClear) {
        this.password = password;
        this.location = location;
        this.airClear  = airClear;
    }

    public AirClear() {

    }

    @Override
    public String toString() {
        return "AirClear{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", airClear='" + airClear  + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        returnPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition (String airCondition) {
        this.airCondition = airCondition;
    }
}
