package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class UpdateFormController implements Initializable {

    @FXML
    private TextField txtSearchId;

    @FXML
    private TextField txtUpdateAddress;

    @FXML
    private TextField txtUpdateDob;

    @FXML
    private TextField txtUpdateName;

    @FXML
    private TextField txtUpdateNumber;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtSearchId.setText(null);
        txtUpdateName.setText(null);
        txtUpdateAddress.setText(null);
        txtUpdateNumber.setText(null);
        txtUpdateDob.setText(null);


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();
        for (Customer customer : customerList){
            if(customer.getId().equals(txtSearchId.getText())){
                txtUpdateName.setText(customer.getName());
                txtUpdateAddress.setText(customer.getAddress());
                txtUpdateNumber.setText(customer.getNumber());
                txtUpdateDob.setText(String.valueOf(customer.getDob()));
                break;

            }
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        List<Customer>customerList=DBConnection.getInstance().getConnection();
        for (Customer customer : customerList){
            if(customer.getId().equals(txtSearchId.getText())){
                customer.setName(txtUpdateName.getText());
                customer.setAddress(txtUpdateAddress.getText());
                customer.setNumber(txtUpdateNumber.getText());
                customer.setDob(LocalDate.parse(txtUpdateDob.getText()));

            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
