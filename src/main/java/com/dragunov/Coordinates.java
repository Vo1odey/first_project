package com.dragunov;

public class Coordinates {
    private final Column Y;
    private final Integer X;

    public Coordinates (Integer X, Column Y) {
        this.X = X;
        this.Y = Y;
    }

    public Coordinates setCoordinates (Coordinates coordinates) {
        return new Coordinates(coordinates.X, coordinates.Y);
    }

    public Column getY() {
        return Y;
    }

    public Integer getX() {
        return X;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (Y != that.Y) return false;
        return X.equals(that.X);
    }

    @Override
    public int hashCode() {
        int result = Y.hashCode();
        result = 31 * result + X.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return X + Y.toString();
    }
}
