package com.company;
import java.util.ArrayList;
public class CustomProperty {
    public String keyvalue;
public CustomProperty(String keyvalue){
    this.keyvalue = keyvalue;
}
public String valCustomProperty(){
    return this.keyvalue;
}
    public static void main(String[] args) {
        ArrayList<CustomProperty> arraykey = new ArrayList<>();
        arraykey.add(new CustomProperty("acc"));
        arraykey.add(new CustomProperty("Adsc"));
        arraykey.add(new CustomProperty("xyz"));
        arraykey.add(new CustomProperty("Hello"));
        arraykey.add(new CustomProperty("Why"));
        arraykey.sort((o1,o2)-> o1.valCustomProperty().compareTo(o2.valCustomProperty()));
        for(CustomProperty x : arraykey){
            System.out.println(x.valCustomProperty());
        }
    }
}
