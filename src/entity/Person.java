package entity;

import java.io.Serializable;

public class Person implements Serializable {
    protected String name;
    protected String address;
    protected Long phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
