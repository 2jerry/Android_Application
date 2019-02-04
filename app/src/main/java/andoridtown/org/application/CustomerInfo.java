package andoridtown.org.application;

public class CustomerInfo
{
    String name;
    String phone;
    String address;

    public CustomerInfo(String name,String phone,String address)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public CustomerInfo(String str)
    {
        String[] change = str.split("\\n");

        this.name = change[0];
        this.phone = change[1];
        this.address = change[2];
    }

    void setName(String name)
    {
        this.name = name;
    }

    void setPhone(String phone)
    {
        this.phone = phone;
    }

    void setAddress(String address)
    {
        this.address = address;
    }

    String getName()
    {
        return this.name;
    }

    String getPhone()
    {
        return this.phone;
    }

    String getAddress()
    {
        return this.address;
    }

}
