package eduardosanchez.example.trabajo3;

public class ListElement {
    public String color;
    public String name;
    public String type;
    public String status;

    public ListElement(String color, String name, String type, String status) {
        this.color = color;
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
