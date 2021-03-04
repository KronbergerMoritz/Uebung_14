package viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Person;
import model.Phonebook;

import java.util.ArrayList;


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
                String address = String.valueOf(tf_address);
                String name = String.valueOf(tf_name);
                String phone = String.valueOf(tf_phone);


                        l_error.setText("Ungültige Eingabe");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Ungültige Eingabe");

                        phonebook.empty();
                        page = phonebook.size();
                        update();
                }


        @FXML
        void back(MouseEvent event)
        {
                l_error.setText("");
                if(page > 1)
                {
                        page--;
                        update();
                        phonebook.saveCSV();
                }
                else
                {
                        l_error.setText("Keine Seite mehr Vorhanden!");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Keine Seite mehr Vorhanden!");
                        phonebook.saveCSV();
                }
        }

        @FXML
        void delete(MouseEvent event)
        {
                l_error.setText("");
                if(phonebook.size() > 1)
                {

                        phonebook.deletePerson(page);
                        if(page > phonebook.size())
                        {
                           page = phonebook.size();
                        }
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
                }


        }

  /**      @FXML
        void loadcsv(MouseEvent event) {
                l_error.setText("");
                phonebook.loadCSV();

        }
   **/

        @FXML
        void next(MouseEvent event)
        {
                l_error.setText("");
                if(page < phonebook.size())
                {
                        page++;
                        update();
                        phonebook.saveCSV();
                }
                else
                {
                        l_error.setText("Keine Seite mehr Vorhanden!");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Keine Seite mehr Vorhanden!");
                        phonebook.saveCSV();
                }
        }

        @FXML
        void save(MouseEvent event)
        {
                l_error.setText("");
                String name = tf_name.getText();
                String address = tf_address.getText();
                String phone = tf_phone.getText();
                phonebook.savePerson(page, name, address, phone);
        }

   /**     @FXML
        void savecsv(MouseEvent event) {
                l_error.setText("");
                phonebook.saveCSV();

        }**/

    }

