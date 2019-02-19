package com.robot.asus.ZenboHelloWorld;


/**
 * Created by davidg on 30/04/2017.
 */

public class Workout {
    private String name;
    private String description;
    private String filmsrc;

    public static final Workout[] workouts = {
            new Workout("跟我一起蹲！",
                    "解說解說解說解說解說解說解說解說解說解說解說",""),
            new Workout("前後來回夠趣味！",
                    "解說解說解說解說解說解說解說解說解說解說解說",""),
            new Workout("舞動吧！自我！",
                    "解說解說解說解說解說解說解說解說解說解說解說s",""),
            new Workout("總結個人秀！",
                    "解說解說解說解說解說解說解說解說解說解說解說","")
    };

    //Each Workout has a name and description
    private Workout(String name, String description, String filmsrc) {
        this.name = name;
        this.description = description;
        this.filmsrc = filmsrc;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getFilmsrc() {return filmsrc;}

    public String toString() {
        return this.name;
    }
}

