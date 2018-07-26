package cn.pra_01.collection_;

import java.util.Iterator;
import java.util.Objects;

/**
 * An item with a description and a part number
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "[description=" + description + ",partNumber=" + partNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }


    @Override
    public int compareTo(Item other) {
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff != 0 ? diff : description.compareTo(other.description);
    }
}

