package com.ilbolzan.avrobenchmark.model;

import java.util.Objects;

public class User {

    private String name;
    private String favoriteColor;
    private Integer favoriteNumber;
    private String description;

    public User() {
    }

    public User(String name, String favoriteColor, Integer favoriteNumber, String description) {
        this.name = name;
        this.favoriteColor = favoriteColor;
        this.favoriteNumber = favoriteNumber;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return favoriteNumber == user.favoriteNumber &&
                Objects.equals(name, user.name) &&
                Objects.equals(favoriteColor, user.favoriteColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, favoriteColor, favoriteNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
