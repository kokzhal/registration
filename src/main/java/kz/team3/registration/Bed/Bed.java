package kz.team3.registration.Bed;

public class Bed {
    private String bed_id;
    private int bed_number;
    private String room_id;
    private int price;
    private String currency;
    private String status;

    public Bed(String status, String currency, int bed_number, String room_id, String bed_id, int price) {
        this.status = status;
        this.currency = currency;
        this.bed_number = bed_number;
        this.room_id = room_id;
        this.bed_id = bed_id;
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getBed_number() {
        return bed_number;
    }

    public void setBed_number(int bed_number) {
        this.bed_number = bed_number;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getBed_id() {
        return bed_id;
    }

    public void setBed_id(String bed_id) {
        this.bed_id = bed_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "bed_id='" + bed_id + '\'' +
                ", bed_number=" + bed_number +
                ", room_id='" + room_id + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
