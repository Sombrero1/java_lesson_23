package ru.mirea;

import java.util.Objects;

public class City {
    private String ground;
    private String country;

    public City(String country,String ground){
        this.ground=ground;
        this.country=country;

    }
    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "ground='" + ground + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(ground, city.ground) &&
                Objects.equals(country, city.country);
    }


}
