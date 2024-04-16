package TaskPackage;

import java.util.regex.*;
import UserPackage.User;

public class Task {
    private double start_time, finish_time;
    private String name;
    User user;
    String notCheckedColor;
    public final String color;



    public boolean isColorValid(){
        String regex = "^#?([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(notCheckedColor);

        return matcher.matches();
    }

    public double getDuration() {
        return (finish_time - start_time);
    }
    public Task(String name, User user) {
        setName(name);
        this.user = user;
        this.color = "65F23A";
    }

    public Task(String name, User user, String color) {
        setName(name);
        this.user = user;
        this.notCheckedColor = color;

        if(isColorValid())
            this.color = notCheckedColor;
        else
            this.color = "65F23A";
    }




    public void setStartTime(double start_time) {
        if(start_time < 0)
            this.start_time = -start_time;
        else
            this.start_time = start_time;
    }

    public void setFinishTime(double finish_time) {
        if(finish_time < 0)
            this.finish_time = -finish_time;
        else
            this.finish_time = finish_time;
    }


    public double getStart_time() {
        return start_time;
    }

    public double getFinish_time() {
        return finish_time;
    }

    public void setName(String name) {

        if(name.length() <= 10) {
            this.name = name;
        }
        else {
             System.out.println("No valid name");
        }
    }

    public String getName() {
        return name;
    }


}