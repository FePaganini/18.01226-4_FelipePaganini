package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import sample.dao.PokeCardDAO;
import sample.model.PokeCard;
import sample.model.PokeCardList;

/**
 * @author Felipe dos Santos Paganini 18.01226-4
 * @author Thiago T. Yara de Araujo 18.01363-5
 * @since 21/09/2020
 */

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
    private BorderPane borpanePreviousNext, borpaneCreateUpdate;
    @FXML
    private GridPane gridpaneId,gridpaneSeries;

    /**
     * A partir do banco de dados, carrega uma lista que terá todos os dados. A primeira Poke Carta e suas informações
     * dessa lista é apresentada e os botões para a ativação de outras funções são liberados.
     */
    @FXML
    public void start(){
        start = true;
        list.pokeCardList =  pokeCardDAO.getAll();
        btnStart.setVisible(false);
        borpaneCreateUpdate.setVisible(true);
        borpanePreviousNext.setVisible(true);
        gridpaneId.setVisible(true);
        gridpaneSeries.setVisible(true);
        showInfo(list.pokeCardList.get(actualCard));
    }

    /**
     * Será exibida a Poke Carta anterior da lista, caso essa Poke Carta seja a primeira da lista retornará para a
     * última Poke Carta
     */
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

    /**
     * Será exibida a Poke Carta seguinte da lista, caso essa Poke Carta seja a última da lista retornará para a
     * primeira Poke Carta
     */
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

    /**
     * A partir dos valores obtidos nos Text Fields haverá a criação de uma nova Poke Carta, esta será adicionada ao
     * arquivo do banco de dados e este será salvo. A lista receberá novamente os dados para que não seja necessário
     * fechar o programa para navergar por eles. Apagará os valores do Text Field após isto.
     * Caso ocorra erro será mostra uma mensagem de erro que o Id já tinha sido cadastrado
     * OBS: os valores de Id não pode ser repetido e nem nulo
     */
    @FXML
    public void createCard(){
        if(!list.idValidate(txtId.getText()) && !txtId.getText().isEmpty()) {
            PokeCard pokeCard = new PokeCard(
                    txtUrl.getText(),
                    txtId.getText(),
                    txtName.getText(),
                    txtRarity.getText(),
                    txtSeries.getText(),
                    txtSet.getText()
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

    /**
     * A partir dos valores obtidos nos Text Fields haverá a atualização da Poke Carta visualizada, a partir do seu id,
     * no arquivo do banco de dados e este será salvo. A lista receberá novamente os dados para que não seja necessário
     * fechar o programa para navergar por eles, também já mostrando os dados atualizados. Apagará os valores do Text
     * Field após isto.
     * Caso ocorra erro será mostra uma mensagem de erro que o Id inserido tem que ser o da carta apresentada
     */
    @FXML
    public void updateCard(){
        if(list.pokeCardList.get(actualCard).getId().equals(txtId.getText())) {
            PokeCard pokeCard = new PokeCard(
                    txtUrl.getText(),
                    txtId.getText(),
                    txtName.getText(),
                    txtRarity.getText(),
                    txtSeries.getText(),
                    txtSet.getText()
            );
            pokeCardDAO.update(pokeCard);
            list.pokeCardList = pokeCardDAO.getAll();
            showInfo(list.pokeCardList.get(actualCard));
            clearText();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Enter id of the displayed card");
            alert.showAndWait();
            txtId.clear();
        }
    }

    /**
     * Mostra o id, nome, raridade, serie, set(coleção), url e foto da Poke Carta atual
     * @param pokeCard Poke Carta que será visualizada
     */
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
