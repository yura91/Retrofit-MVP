
package registration.testing.firebase.com.retrofitmvp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastResponse {

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Integer message;
    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<Forecast> list = null;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public java.util.List<Forecast> getList() {
        return list;
    }

    public void setList(java.util.List<Forecast> list) {
        this.list = list;
    }

}
