package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Customer;

import java.util.List;

public class DeleteFormController {

    @FXML
    private TextField txtDeleteAddress;

    @FXML
    private TextField txtDeleteDob;

    @FXML
    private TextField txtDeleteName;

    @FXML
    private TextField txtDeleteNumber;

    @FXML
    private TextField txtSearchId;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        List<Customer>customerList=DBConnection.getInstance().getConnection();
        for(Customer customer : customerList){
            if (customer.getId().equals(txtSearchId.getText())){
                customerList.remove(customer);
                break;
            }
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        List<Customer>customerList= DBConnection.getInstance().getConnection();
        for(Customer customer : customerList){
            if(customer.getId().equals(txtSearchId.getText())){
                txtDeleteName.setText(customer.getName());
                txtDeleteAddress.setText(customer.getAddress());
                txtDeleteNumber.setText(customer.getNumber());
                txtDeleteDob.setText(String.valueOf(customer.getDob()));
            }
        }

    }

}
