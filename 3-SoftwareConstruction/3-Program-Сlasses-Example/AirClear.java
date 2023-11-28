package com.lab9.airclearstatechecker.entity;

import jakarta.persistence.*;

@Entity
public class AirClear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "gender")
    private String gender;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "air_clear_state")
    private String airClearState;
    //method
    public String getAirClearStateInfo(String user, String gender, Date dateOfBirth) {
        String result = "";
        if (gender.length() > 20 || !user.matches("^[a-zA-Z\\s]+$") || user.isBlank() || dateOfBirth.length() > 10) {
            result = "-1";
        }
        result = """
                        Your work place now has excellent air quality.
                        The level of air pollution at the moment meets all norms and safety standards. 
                        You can enjoy fresh air and safe living conditions.
                        Air Clear = 80 %
                    """;
        return result;
    }

    public AirClear(String gender, String dateOfBirth, String airClearState) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.airClearState = airClearState;
    }

    public AirClear() {

    }

    @Override
    public String toString() {
        return "AirClear{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", airClearState='" + airClearState + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gendateOfBirthder) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAirConditionState() {
        return airConditionState;
    }

    public void setAirConditionState(String airConditionState) {
        this.airConditionState = airConditionState;
    }
}
