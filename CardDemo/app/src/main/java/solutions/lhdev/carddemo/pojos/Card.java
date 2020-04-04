package solutions.lhdev.carddemo.pojos;

/**
 * Created by JuanIgnacio on 19/03/2018.
 */

public class Card {

    private int id;
    private String title;
    private String details;
    private int imageId;

    public Card(int id, String title, String details, int imageId) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.imageId = imageId;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
