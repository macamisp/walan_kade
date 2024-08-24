package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Customer;

import java.util.List;

public class SearchFormController {

    @FXML
    private TextField txtSearchAddress;

    @FXML
    private TextField txtSearchDob;

    @FXML
    private TextField txtSearchId;

    @FXML
    private TextField txtSearchName;

    @FXML
    private TextField txtSearchNumber;

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer> customerList = DBConnection.getInstance().getConnection();

        for (Customer customer : customerList){
            if (customer.getId().equals(txtSearchId.getText())){
                txtSearchName.setText(customer.getName());
                txtSearchAddress.setText(customer.getAddress());
                txtSearchNumber.setText(customer.getNumber());
                txtSearchDob.setText(String.valueOf(customer.getDob()));
                break;
                }
            }
            txtSearchName.setEditable(false);
            txtSearchAddress.setEditable(false);
            txtSearchNumber.setEditable(false);
            txtSearchDob.setEditable(false);

    }

}
