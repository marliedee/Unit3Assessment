package org.pursuit.unit_03_assessment.model;


public class Attributes {

    private String name;
    private Integer number;
    private String image;

    public Attributes(String name, Integer number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public  String getName() {
        return name;
    }

    public  Integer getNumber() {
        return number;
    }

    public  String getImage() {
        return image;
    }

}
