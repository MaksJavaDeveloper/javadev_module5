package javadev_module4.select;

import java.util.Date;

public class FindYoungestEldestWorkers {
    private String type;
    private String name;
    private Date birthday;

    public FindYoungestEldestWorkers(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
}
