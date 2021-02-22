package model;

import java.util.ArrayList;

public class Phonebook
{
    public Phonebook()
    {
        addNewPerson("Marcel Prilinger", "Eberstalzell", "0664 69686421");
        addNewPerson("Moritz Kronberger", "Eberstalzell", "0677 62454541");
        addNewPerson("Matteo Falkenber", "Wels", "0664 525174670");
    }

    public void addNewPerson(String name, String address, String phone)
    {
    Person person2 = new Person();
    person2.setPhone(phone);
    person2.setAddress(address);
    person2.setName(name);

    person.add(person2);
    }

    private ArrayList<Person> person = new ArrayList<>();



    public void empty()
    {
        Person person1 = new Person();
        person1.setAddress("");
        person1.setName("");
        person1.setPhone("");

        person.add(person1);

    }

    public int size()
    {
        return person.size();
    }

    public void savePerson(int index, String name, String address, String phone)
    {

        person.get(index-1).setName(name);
        person.get(index-1).setAddress(address);
        person.get(index-1).setPhone(phone);
    }


    public Person getPerson(int index)
    {
        return person.get(index - 1);
    }

    public void deletePerson(int index)
    {
        person.remove(index - 1);
    }





    public void backPage()
    {

    }

    public void saveCSV()
    {

    }

    public void loadCSV()
    {

    }




}
