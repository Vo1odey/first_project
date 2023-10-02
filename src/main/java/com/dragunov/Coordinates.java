package com.dragunov;

public class Coordinates {
    private final Column Column;
    private final Integer Horizontal;

    public Coordinates (Integer vertical, Column horizontal) {
        this.Horizontal = vertical;
        this.Column = horizontal;
    }

    public Coordinates setCoordinates (Coordinates coordinates) {
        return new Coordinates(coordinates.Horizontal, coordinates.Column);
    }

    public Column getVertical() {
        return Column;
    }

    public Integer getHorizontal() {
        return Horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Column != that.Column) return false;
        return Horizontal.equals(that.Horizontal);
    }

    @Override
    public int hashCode() {
        int result = Column.hashCode();
        result = 31 * result + Horizontal.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Horizontal + Column.toString();
    }
}
