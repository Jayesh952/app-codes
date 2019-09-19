package com.example.scar;


public class Students {

    private String Id;
    private  String Name;
    private  String Area;
    private  String mobile_No;
    private  String Door_no ;
    private String Distance;

    public Students(){

    }

    public Students(String id, String name, String area, String mobile_No, String Door_no) {
        this.Id = id;
        this.Name = name;
        this.Area = area;
        this.mobile_No = mobile_No;
        this.Door_no = Door_no;


    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getArea() {
        return Area;
    }

    public String getMobile_No() {
        return mobile_No;
    }

    public String getLanguage() {
        return Door_no;
    }
    public String getDistance() {
        return Distance;
    }



}



