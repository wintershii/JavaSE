package jdbc;

public class Depart {
    private Integer id;
    private String dname;
    private String address;

    public Depart(Integer id, String dname, String address) {
        this.id = id;
        this.dname = dname;
        this.address = address;
    }

    public Depart(String dname, String address) {
        this.dname = dname;
        this.address = address;
    }

    public Depart() {
    }

    public Integer getId() {
        return id;
    }

    public String getDname() {
        return dname;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
