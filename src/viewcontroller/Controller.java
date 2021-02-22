package viewcontroller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Person;
import model.Phonebook;

import java.io.IOException;

public class Controller extends Phonebook{

        private Phonebook phonebook = new Phonebook();
        private int position = 1;

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

        private void update()
        {
                l_page.setText(position + "/" + phonebook.size());
                Person person = phonebook.getPerson(position);

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
                phonebook.empty();
                position = phonebook.size();
                update();
        }

        @FXML
        void back(MouseEvent event)
        {
                l_error.setText("");
                if(position > 1)
                {
                        position--;
                        update();
                }
                else
                {
                        l_error.setText("Keine Seite mehr Vorhanden!");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Keine Seite mehr Vorhanden!");
                }
        }

        @FXML
        void delete(MouseEvent event)
        {
                l_error.setText("");
                if(phonebook.size() > 1)
                {

                        phonebook.deletePerson(position);
                        if(position > phonebook.size())
                        {
                           position = phonebook.size();
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
                        System.out.println("nein");
                }


        }

        @FXML
        void loadcsv(MouseEvent event) {
                l_error.setText("");

        }

        @FXML
        void next(MouseEvent event)
        {
                l_error.setText("");
                if(position < phonebook.size())
                {
                        position++;
                        update();
                }
                else
                {
                        l_error.setText("Keine Seite mehr Vorhanden!");
                        l_error.setStyle("-fx-text-fill: red;");
                        System.out.println("Keine Seite mehr Vorhanden!");
                }
        }

        @FXML
        void save(MouseEvent event)
        {
                l_error.setText("");
                String name = tf_name.getText();
                String address = tf_address.getText();
                String phone = tf_phone.getText();
                phonebook.savePerson(position, name, address, phone);
        }

        @FXML
        void savecsv(MouseEvent event) {
                l_error.setText("");

        }

    }

