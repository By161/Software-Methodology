package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;




/**
 * Controller Class for the Chicago Pizza GUI
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ChicagoPizzaController {
    ObservableList<String> pizzaFlavors = FXCollections
            .observableArrayList("Deluxe", "BBQ Chicken", "Meatzza", "Build your own");
    @FXML
    private ListView<String> toppings;
    @FXML
    private ListView<String> selectedToppings;
    @FXML
    private ImageView picture;
    @FXML
    private RadioButton rbSmall;
    @FXML
    private RadioButton rbMedium;
    @FXML
    private RadioButton rbLarge;
    @FXML
    private TextField price;
    @FXML
    private ToggleGroup sizeGroup = new ToggleGroup();
    @FXML
    private ComboBox flavor;
    @FXML
    private TextField crust;
    @FXML
    private Button add;
    @FXML
    private Button remove;
    @FXML
    private Button addToOrderButton;
    Order myOrder;
    DecimalFormat df = new DecimalFormat("#.00");
    ArrayList<String> listToppings = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni", "green pepper",
            "onion", "mushroom", "BBQ Chicken", "provolone", "cheddar", "beef", "ham",
            "red pepper", "jalapeno", "olives"));
    ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
            "green pepper", "onion", "mushroom"));
    ArrayList<String> listToppingsBBQChicken = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
            "provolone", "cheddar"));

    ArrayList<String> listToppingsMeatzza = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
            "beef", "ham"));

    ArrayList<String> listToppingsBuildYourOwn = new ArrayList<>();

    /**
     * Initialize Method
     */
    public void initialize() {
        rbSmall.setToggleGroup(sizeGroup);
        rbSmall.setSelected(true);
        rbMedium.setToggleGroup(sizeGroup);
        rbLarge.setToggleGroup(sizeGroup);
        flavor.setValue("Deluxe");
        flavor.setItems(pizzaFlavors);
        price.setEditable(false);
        crust.setEditable(false);
        crust.setText("Deep Dish");
        price.setText("14.99");
        toppings.getItems().addAll(listToppings);
        toppings.getItems().removeAll(listToppingsDeluxe);
        selectedToppings.getItems().addAll(listToppingsDeluxe);
        add.setDisable(true);
        Image deluxePizza = new Image(getClass().getResourceAsStream("DeluxeChicagoPizza.jpg"));
        picture.setImage(deluxePizza);
    }

    /**
     * Helper Method to change the price based off what flavor and size is selected
     */
    public void changePrice(){
        if(flavor.getValue().equals("Deluxe")){
            if (rbSmall.isSelected()){
                price.setText("14.99");
            }
            if(rbMedium.isSelected()){
                price.setText("16.99");
            }
            if(rbLarge.isSelected()){
                price.setText("18.99");
            }
        }
        if(flavor.getValue().equals("BBQ Chicken")){
            if (rbSmall.isSelected()){
                price.setText("13.99");
            }
            if(rbMedium.isSelected()){
                price.setText("15.99");
            }
            if(rbLarge.isSelected()){
                price.setText("17.99");
            }
        }
        if(flavor.getValue().equals("Meatzza")){
            if (rbSmall.isSelected()){
                price.setText("15.99");
            }
            if(rbMedium.isSelected()){
                price.setText("17.99");
            }
            if(rbLarge.isSelected()){
                price.setText("19.99");
            }
        }
        if (flavor.getValue().equals("Build your own")){
            if (rbSmall.isSelected()){
                price.setText("8.99");
            }
            if(rbMedium.isSelected()){
                price.setText("10.99");
            }
            if(rbLarge.isSelected()){
                price.setText("12.99");
            }
        }
    }

    /**
     * Helper method that changes all the required fields when the selected flavor is changed
     */
    public void flavorChange() {
        if (flavor.getValue().equals("Deluxe")){
            flavorDeluxe();
        }
        if (flavor.getValue().equals("BBQ Chicken")){
            flavorBBQChicken();
        }
        if (flavor.getValue().equals("Meatzza")){
            flavorMeatzza();
        }
        if(flavor.getValue().equals("Build your own")){
            flavorBuildYourOwn();
        }
    }

    /**
     * Helper method that executes when the add button is clicked
     */
    public void onAddButtonClick(){
        if (getNumOfElementsInList(selectedToppings) < 7) {
            String selectedItem = toppings.getSelectionModel().getSelectedItem();
            int selectedID = toppings.getSelectionModel().getSelectedIndex();
            listToppingsBuildYourOwn.add(selectedItem);
            if(toppings.getSelectionModel().getSelectedIndex() < 0){
                errorWindow();
            } else{
                toppings.getItems().remove(selectedID);
                selectedToppings.getItems().add(selectedItem);
                if (flavor.getValue().equals("Build your own")) {
                    price.setText(String.valueOf(df.format(Double.parseDouble(price.getText()) + 1.59)));
                }

            }
        } else {
            errorWindow();
        }
    }

    /**
     * Helper method that executes when the remove button is clicked
     */
    public void onRemoveButtonClick(){
        if(getNumOfElementsInList(selectedToppings) >= 1){
            String selectedItem = selectedToppings.getSelectionModel().getSelectedItem();
            int selectedID = selectedToppings.getSelectionModel().getSelectedIndex();
            if(selectedToppings.getSelectionModel().getSelectedIndex() < 0){
                errorWindow();
            }
            else{
                selectedToppings.getItems().remove(selectedID);
                toppings.getItems().add(selectedItem);
                if(flavor.getValue().equals("Build your own")){
                    price.setText(String.valueOf(df.format(Double.parseDouble(price.getText()) - 1.59)));
                }
            }
        }
        else{
            errorWindow();
        }
    }

    /**
     * Helper method that returns the number of elements in the inputted ListView
     * @param list inputted ListView
     * @return integer number of how many elements are in the inputted ListView
     */
    public int getNumOfElementsInList(ListView list){
        return (int) list.getItems().stream().count();
    }

    /**
     * Helper method that modifies all relevant fields when the flavor is deluxe
     */
    public void flavorDeluxe(){
        add.setDisable(true);
        toppings.getItems().clear();
        toppings.getItems().addAll(listToppings);
        selectedToppings.getItems().clear();;
        Image deluxePizza = new Image(getClass().getResourceAsStream("DeluxeChicagoPizza.jpg"));
        picture.setImage(deluxePizza);
        crust.setText("Deep Dish");
        toppings.getItems().removeAll(listToppingsDeluxe);
        selectedToppings.getItems().addAll(listToppingsDeluxe);
        changePrice();
    }

    /**
     * Helper method that modifies all relevant fields when the flavor is BBQChicken
     */
    public void flavorBBQChicken(){
        add.setDisable(true);
        toppings.getItems().clear();
        toppings.getItems().addAll(listToppings);
        selectedToppings.getItems().clear();
        Image BBQChicken = new Image(getClass().getResourceAsStream("ChicagoBBQChickenPizza.jpg"));
        picture.setImage(BBQChicken);
        crust.setText("Pan");
        toppings.getItems().removeAll(listToppingsBBQChicken);
        selectedToppings.getItems().addAll(listToppingsBBQChicken);
        changePrice();
    }

    /**
     * Helper method that modifies all relevant fields when the flavor is Meatzza
     */
    public void flavorMeatzza(){
        add.setDisable(true);
        toppings.getItems().clear();
        toppings.getItems().addAll(listToppings);
        selectedToppings.getItems().clear();
        Image Meatzza = new Image(getClass().getResourceAsStream("ChicagoMeatzza.jpg"));
        picture.setImage(Meatzza);
        crust.setText("Stuffed");
        toppings.getItems().removeAll(listToppingsMeatzza);
        selectedToppings.getItems().addAll(listToppingsMeatzza);
        changePrice();
    }

    /**
     * Helper method that modifies all relevant fields when the flavor is build your own
     */
    public void flavorBuildYourOwn(){
        add.setDisable(true);
        toppings.getItems().clear();
        toppings.getItems().addAll(listToppings);
        selectedToppings.getItems().clear();
        add.setDisable(false);
        remove.setDisable(false);
        Image buildYourOwn = new Image(getClass().getResourceAsStream("ChicagoMakeYourOwn.jpg"));
        picture.setImage(buildYourOwn);
        crust.setText("Pan");
        changePrice();
    }

    /**
     * Helper method that calls the error window GUI
     */
    public void errorWindow(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Error");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Helper method that adds the inputted pizza into the current order
     */
    public void AddToOrder(){
        PizzaFactory pizzaFactory = new NYPizza();
        Pizza pizza;
        if (flavor.getValue().toString().equals("Deluxe")){
            pizza = pizzaFactory.createDeluxe();
        }
        else if (flavor.getValue().toString().equals("Meatzza")){
            pizza = pizzaFactory.createMeatzza();
        }
        else if(flavor.getValue().toString().equals("BBQChicken")){
            pizza = pizzaFactory.createBBQChicken();
        }
        else {
            pizza = pizzaFactory.createBuildYourOwn();
        }
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(pizza);
        myOrder = new Order(pizzas);
    }
    public Order getOrder(){
        return myOrder;
    }

}
