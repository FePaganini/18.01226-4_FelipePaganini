package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.dao.PokeCardDAO;
import sample.model.PokeCard;
import sample.model.PokeCardList;


public class Controller {
    private boolean start = false;
    private PokeCardList list = new PokeCardList();
    private PokeCardDAO pokeCardDAO = new PokeCardDAO();
    private int actualCard = 0;

    @FXML
    private Button btnStart, btnUpdate, btnNext, btnPrevious, btnCreate;
    @FXML
    private TextField txtId, txtName, txtRarity, txtSeries, txtSet, txtUrl;
    @FXML
    private Label lblId, lblName, lblRarity, lblSeries, lblSet, lblUrl;
    @FXML
    private ImageView imageCard;

    @FXML
    public void start(){
        start = true;
        list.pokeCardList =  pokeCardDAO.getAll();
        btnStart.setVisible(false);
        showInfo(list.pokeCardList.get(actualCard));
    }

    @FXML
    public void previousCard(){
        if(actualCard == 0) {
            actualCard = list.pokeCardList.size()-1;
        }
        else{
            actualCard--;
        }
        showInfo(list.pokeCardList.get(actualCard));
    }

    @FXML
    public void nextCard(){
        if(actualCard == list.pokeCardList.size()-1) {
            actualCard = 0;
        }
        else{
            actualCard++;
        }
        showInfo(list.pokeCardList.get(actualCard));
    }

    @FXML
    public void createCard(){
        if(!list.idValidate(txtId.getText())) {
            PokeCard pokeCard = new PokeCard(
                    txtUrl.getText(),
                    txtId.getText(),
                    txtName.getText(),
                    txtRarity.getText(),
                    txtSeries.getId(),
                    txtSet.getId()
            );
            pokeCardDAO.create(pokeCard);
            list.pokeCardList = pokeCardDAO.getAll();
            clearText();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Id already exists, try another one");
            alert.showAndWait();
            txtId.clear();
        }
    }

    @FXML
    public void showInfo(PokeCard pokeCard){
        lblId.setText(pokeCard.getId());
        lblName.setText(pokeCard.getName());
        lblRarity.setText(pokeCard.getRarity());
        lblSeries.setText(pokeCard.getSeries());
        lblSet.setText(pokeCard.getSet());
        lblUrl.setText(pokeCard.getUrl());
        showImage(pokeCard.getUrl());
    }

    @FXML
    public void showImage(String url){
        try {
            Image image = new Image(url);
            imageCard.setImage(image);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Card image not found");
            alert.show();
        }
    }

    @FXML
    public void clearText(){
        txtId.clear();
        txtName.clear();
        txtRarity.clear();
        txtSeries.clear();
        txtSet.clear();
        txtUrl.clear();
    }
}
