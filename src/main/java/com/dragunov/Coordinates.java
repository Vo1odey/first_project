package com.dragunov;

public class Coordinates {
    private Vertical Vertical;
    private Integer Horizontal;

    public Coordinates (Integer Horizontal, Vertical vertical) {
        this.Horizontal = Horizontal;
        this.Vertical = vertical;
    }

    public Coordinates setCoordinates (Coordinates coordinates) {
        return new Coordinates(coordinates.Horizontal, coordinates.Vertical);
    }

    public Vertical getVertical() {
        return Vertical;
    }

    public Integer getHorizontal() {
        return Horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Vertical != that.Vertical) return false;
        return Horizontal.equals(that.Horizontal);
    }

    @Override
    public int hashCode() {
        int result = Vertical.hashCode();
        result = 31 * result + Horizontal.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Horizontal + Vertical.toString();
    }
}
