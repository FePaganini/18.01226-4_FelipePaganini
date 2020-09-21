package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.dao.PokeCardDAO;
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
    public void start(){
        start = true;
        list.pokeCardList =  pokeCardDAO.getAll();
        btnStart.setVisible(false);
    }
}
