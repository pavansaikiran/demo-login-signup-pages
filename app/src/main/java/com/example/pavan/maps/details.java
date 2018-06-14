package com.example.pavan.maps;

/**
 * Created by pavan on 13/6/18.
 */

public class details {

    private int id;
    private String name;
    private String address;
    private String email;
    private int number;
    private String password;
    public details(int id,String n,String a,String e,String p,int num){
        this.id=id;
        name=n;
        address=a;
        email=e;
        password=p;
        number=num;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
