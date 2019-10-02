package dao.dao;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/2 17:46.
 */
public class Person {

    String name;
    int age;
    Date date;

    public int getAge() {
        return age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
