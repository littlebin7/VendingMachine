package common;

import java.io.Serializable;

public class Sale implements Serializable {
    private String name;
    private int number;
    private float total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Sale(String name, int number, float total)
    {
        this.name = name;
        this.number = number;
        this.total = total;
    }
}
