package solutions.lhdev.playingwithlistviews.models;

/**
 * Created by JuanIgnacio on 13/03/2018.
 */

public class Alumno
{
    private String name;
    private String lastName;
    private String id;

    public Alumno(String name, String lastName, String id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    public Alumno() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
