public class Emp {
    private String e_id;
    private String e_name;
    public Emp(String e_id,String e_name){
        this.e_id = e_id;
        this.e_name = e_name;
    }

    public String getName(){
        return this.e_name;
    }

    public void setName(String name){
        this.e_name = name;
    }

    public String getE_id(){
        return this.e_id;
    }
}
