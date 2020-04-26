import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lero on 2020/4/25.
 */
public class Student implements Comparable{
    private int ID;
    private String name;
    private Date birDate;
    private boolean gender;

    public Student() {
    }

    public Student(int ID, String name, Date birDate, boolean gender) {
        this.ID = ID;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirDate() {
        return birDate;
    }

    public void setBirDate(Date birDate) {
        this.birDate = birDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        String string = "";
        string += "ID: "+ ID + ", ";
        string += "name: "+ name + ", ";
        SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
        string += "birthday: " + sformat.format(birDate) + ", ";
        string += "gender: " + (gender?"Male":"Female");
        return string;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student)o;
        if(this.ID>s.ID)
            return 1;
        else
            return -1;
    }
}
