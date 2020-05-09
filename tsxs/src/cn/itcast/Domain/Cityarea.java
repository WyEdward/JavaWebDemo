package cn.itcast.Domain;

/**
 * datadealapp_cityarea表中的domain类
 */
public class Cityarea {
    private String city;
    private String city_area;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_area() {
        return city_area;
    }

    public void setCity_area(String city_area) {
        this.city_area = city_area;
    }

    public Cityarea() {

    }

    @Override
    public String toString() {
        return "Ciryarea{" +
                "city='" + city + '\'' +
                ", city_area='" + city_area + '\'' +
                '}';
    }
}
