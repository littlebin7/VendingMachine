package common;


import java.io.Serializable;

public class goodsItem implements Serializable {
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public float getTotal() {
        return total;
    }

    public String getDatetime() {
        return datetime;
    }

    private final String name;
    private final int number;
    private final float total;
    private final String datetime;

    public goodsItem(String name, int number, float total, String datetime)
    {
        this.name = name;
        this.number = number;
        this.total = total;
        this.datetime = datetime;
    }

    @Override
    public String toString()
    {
        return "{ " + "name = " + this.name + " number = " + this.number + " total = " + this.total + " datetime = " + this.datetime + " }";
    }
}
