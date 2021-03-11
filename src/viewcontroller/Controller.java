package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Person;
import model.Phonebook;


public class Controller extends Phonebook{


        @FXML
        private Label l_page;

        @FXML
        private TextField tf_name;

        @FXML
        private TextField tf_address;

        @FXML
        private TextField tf_phone;

        @FXML
        private Label l_error;

        private Phonebook phonebook = new Phonebook();
        private int page = 1;

        public Controller() {

        }


        private boolean controll()
        {
                l_error.setText("");
                String address = tf_address.getText();
                String name = tf_name.getText();
                String phone = tf_phone.getText();


                String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
                String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k","l", "m", "n", "o", "p", "q", "r","s", "t", "u", "v", "w", "x", "y","z","ä", "ö", "ü"};

                for(int i = 0; i<number.length; i++) {
                        for(int j = 0; j<letter.length; j++) {


                                if (name.contains(number[i]) || address.contains(number[i]) || phone.contains(letter[j])) {
                                        l_error.setText("Ungültige Eingabe!");
                                        l_error.setStyle("-fx-text-fill: red;");
                                        System.out.println("Ungültige Eingabe");
                                        return false;



                                } else if (name.equals("") || address.equals("") || phone.equals("")) {
                                        l_error.setText("Werte Fehlen!");
                                        l_error.setStyle("-fx-text-fill: red;");
                                        System.out.println("Werte Eingaben");
                                        return false;

                                }
                        }
                }
              return true;
        }


        private void update()
        {
                l_page.setText(page + "/" + phonebook.size());
                Person person = phonebook.getPerson(page);
                tf_name.setText(person.getName());
                tf_address.setText(person.getAddress());
                tf_phone.setText(person.getPhone());
        }


        @FXML
        public void initialize()
        {
                update();
        }


        @FXML
        void add(MouseEvent event)
        {

                l_error.setText("");
              if(controll()==false)
              {
                      controll();
              }
              else {
                      save();
                      l_error.setText("Neuer Eintrag! Werte Eingeben");
                      l_error.setStyle("-fx-text-fill: green;");
                      phonebook.empty();
                      page = phonebook.size();
                      update();
                         }
                }


        @FXML
        void back(MouseEvent event)
        {

                l_error.setText("");
                if(controll() == false)
                {
                        controll();
                }
                else {
                        save();
                        if (page > 1) {

                                page--;
                                update();
                                phonebook.saveCSV();


                        } else {
                                l_error.setText("Keine Seite mehr Vorhanden!");
                                l_error.setStyle("-fx-text-fill: red;");
                                System.out.println("Keine Seite mehr Vorhanden!");
                                phonebook.saveCSV();
                        }
                }
        }

        @FXML
        void delete(MouseEvent event)
        {
                l_error.setText("");
                if(phonebook.size() > 1)
                {
                        phonebook.deletePerson(page);
                                 if (page > phonebook.size())
                                 {

                                         page = phonebook.size();

                                 }

                        l_error.setText("Eintrag gelöscht");
                        l_error.setStyle("-fx-text-fill: green;");
                        update();

                }
                else
                {
                        tf_name.setText("");
                        tf_phone.setText("");
                        tf_address.setText("");
                        l_error.setText("Alles bereits gelöscht");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Alles Gelöscht!");

                        phonebook.saveCSV();
                }


        }

        @FXML
        void next(MouseEvent event)
        {
                l_error.setText("");

                if(controll() == false)
                {
                        controll();
                }
                else {
                        save();
                        if (page < phonebook.size()) {
                                page++;
                                update();
                                phonebook.saveCSV();


                        } else {
                                l_error.setText("Keine Seite mehr Vorhanden!");
                                l_error.setStyle("-fx-text-fill: red;");
                                System.out.println("Keine Seite mehr Vorhanden!");
                                phonebook.saveCSV();
                        }
                }
        }


       private void save()
        {
                l_error.setText("");
                String name = tf_name.getText();
                String address = tf_address.getText();
                String phone = tf_phone.getText();
                phonebook.savePerson(page, name, address, phone);
        }

    }