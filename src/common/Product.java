package common;

import java.io.Serializable;

public class Product implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private String name;
    private String path;
    private float price;
    private int count;

    public Product(String name, String path, float price, int count)
    {
        this.name = name;
        this.path = path;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString()
    {
        return "{name = " + this.name + " path = " + this.path + " price = " + this.price + " count = " + this.count + "}";
    }
}