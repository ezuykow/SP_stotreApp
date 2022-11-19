package ru.ezuykow.app.models;

public class Item implements Comparable<Item>{

    private static final int DEFAULT_COUNT = 1;
    private final int itemId;
    private int itemsCount;

    public Item(int itemId) {
        this.itemId = itemId;
        this.itemsCount = DEFAULT_COUNT;
    }

    public void incCount() {
        itemsCount++;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public int getItemId() {
        return itemId;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return itemId == item.itemId;
    }

    @Override
    public int hashCode() {
        return itemId;
    }

    @Override
    public String toString() {
        return "Item " + itemId
                + " in the amount of "
                + itemsCount + " pieces";
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(itemId, o.getItemId());
    }
}
