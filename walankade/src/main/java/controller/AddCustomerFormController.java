package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbtitle;

    @FXML
    private DatePicker datedob;

    @FXML
    private JFXTextField txtaddress;

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtnumber;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        List<Customer> customerList = DBConnection.getInstance().getConnection();
        String newId = txtid.getText();
        boolean idExists = customerList.stream().anyMatch(customer -> customer.getId().equals(newId));

        if(idExists){
            txtid.setText(null);
        }
        else{
            customerList.add(
                    new Customer(
                            newId,
                            cmbtitle.getValue(),
                            txtname.getText(),
                            txtaddress.getText(),
                            txtnumber.getText(),
                            datedob.getValue()
                    )
            );
        }
        txtid.setText(null);
        cmbtitle.setValue(null);
        txtname.setText(null);
        txtaddress.setText(null);
        txtnumber.setText(null);
        datedob.setValue(null);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Mrs.");
        titles.add("Miss.");
        titles.add("Ms");
        cmbtitle.setItems(titles);

    }
}
