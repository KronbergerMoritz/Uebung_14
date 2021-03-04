package model;

import java.io.*;
import java.util.ArrayList;

public class Phonebook {
    public Phonebook() {
        //addNewPerson("Marcel Prilinger", "Eberstalzell", "0664 69686421");
        //addNewPerson("Moritz Kronberger", "Eberstalzell", "0677 62454541");
        //addNewPerson("Matteo Falkenberg", "Wels", "0664 525174670");
        loadCSV();
    }

    private ArrayList<Person> person = new ArrayList<>();


    public void addNewPerson(String name, String address, String phone) {
        Person person2 = new Person();
        person2.setPhone(phone);
        person2.setAddress(address);
        person2.setName(name);

        person.add(person2);


    }


    public void empty() {
        Person person1 = new Person();
        person1.setAddress("");
        person1.setName("");
        person1.setPhone("");

        person.add(person1);

        saveCSV();
        savePerson(0, "", "", "");
    }

    public int size() {
        return person.size();
    }

    public void savePerson(int index, String name, String address, String phone) {

        person.get(index - 1).setName(name);
        person.get(index - 1).setAddress(address);
        person.get(index - 1).setPhone(phone);

        saveCSV();
    }


    public Person getPerson(int index)
    {
        return person.get(index - 1);
    }

    public void deletePerson(int index)
    {
        person.remove(index - 1);
        saveCSV();
        savePerson(index, "", "", "");
    }


    public void saveCSV() {
        try {
            FileWriter fw = new FileWriter("./save/savedFile.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < person.size(); i++) {
                bw.write(person.get(i).toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void loadCSV()
    {
        person.clear();

        String csv = "./save/savedFile.csv";
        String Delimiter = ";";

        BufferedReader br;

        try
        {
          br = new BufferedReader(new FileReader(csv));

          String line;
          while ((line = br.readLine()) != null)
          {
              String[] fields = line.split(Delimiter, -1);
               String s = fields[0];
               String b = fields[1];
               String c = fields[2];
               Person person4 = new Person();
               person4.setName(s);
               person4.setAddress(b);
               person4.setPhone(c);
               person.add(person4);

          }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
