package com.example.kursach;
public class Users {
    private static String name, passw, phone;
    public Users(){
    }
    public Users(String passw, String phone) {
        this.name = name;
        this.passw = passw;
        this.phone = phone;
    }
    public String getName() {return name;}
    public void setName(String name){this.name = name;}
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public static String getPassw() {
        return passw;
    }
    public void setPassw(String passw) {
        this.passw = passw;
    }
}