package model;

public class Person
{

    private String name;
    private String address;
    private String phone;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(";");
        sb.append(address);
        sb.append(";");
        sb.append(phone);

        String s = sb.toString();
        return s;


    }
}
