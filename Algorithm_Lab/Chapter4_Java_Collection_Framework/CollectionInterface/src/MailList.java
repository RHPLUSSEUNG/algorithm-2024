import java.util.*;

//사용자 Class를 Collection에 저장
class Address 
{
    private String name;
    private String street;
    private String city;
    private String state;
    private String code;

    Address(String n, String s, String c, String st, String cd) 
    {
        name = n;
        city = c;
        code = cd;
        street = s;
        state = st;
    }

    public String toString() 
    {
        return name + "\n" + street + "\n" + city + " " + state + " " + code;
    }
}

class MailList 
{
    public static void main(String args[]) 
    {
        LinkedList<Address> ml = new LinkedList<Address>();
        // Add elements to the linked list.
        ml.add(new Address("J.W. West", "11 Oak Ave", "Urbana", "IL", "61801"));
        ml.add(new Address("Ralph Baker", "1142 Maple Lane", "Mahome", "IL", "61853"));
        ml.add(new Address("Tom Carlton", "867 Elm St", "Champaign", "IL", "61820"));
    }
}