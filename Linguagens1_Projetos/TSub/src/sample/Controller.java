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
        showInfo(list.pokeCardList.get(0));
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Card image not found");
            alert.show();
        }
    }
}
