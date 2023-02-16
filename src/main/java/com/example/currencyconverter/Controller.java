package com.example.currencyconverter;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private ComboBox<String> comboBoxx;

    @FXML
    private Label selection;

    @FXML
    private TextField inputValue;

    private Map<String, Double> kurswalut = new HashMap<>();

    @FXML
    void loaditems(ActionEvent event) {
        String fromCurrency = comboBox.getValue();
        String toCurrency = comboBoxx.getValue();
        double amount = Double.parseDouble(inputValue.getText());

        double result = convertCurrency(fromCurrency, toCurrency, amount);
        selection.setText(String.format("%.2f %s", result, toCurrency));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] items = {"USD", "GBP", "PLN"};
        comboBox.getItems().addAll(items);
        comboBoxx.getItems().addAll(items);

        kurswalut.put("USD", 0.22);
        kurswalut.put("GBP", 0.18);
        kurswalut.put("PLN", 1.00);
    }

    private double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        double fromRate = kurswalut.get(fromCurrency);
        double toRate = kurswalut.get(toCurrency);

        return amount * toRate / fromRate;
    }
}