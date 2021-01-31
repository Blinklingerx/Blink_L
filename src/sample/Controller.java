package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label textAnswerQuestions;

    @FXML
    private Text textBodyFatPercentage;

    @FXML
    private TextField bodyFatPercentage;

    @FXML
    private Text textFavoriteFoods;

    @FXML
    private RadioButton favFodFish;

    @FXML
    private RadioButton favFodMeal;

    @FXML
    private RadioButton favFodCookies;

    @FXML
    private RadioButton favFodDairyProducts;

    @FXML
    private RadioButton favFodSweets;

    @FXML
    private RadioButton favFodBread;

    @FXML
    private RadioButton favFodGreens;

    @FXML
    private RadioButton favFodNuts;

    @FXML
    private Text textChooseLifestyle;

    @FXML
    private RadioButton lifestyleActive;

    @FXML
    private ToggleGroup lifeStyleGroup;

    @FXML
    private RadioButton lifestyleMedium;

    @FXML
    private RadioButton lifestyleSedentary;

    @FXML
    private Button replyGetAMealPlan;

    @FXML
    private Text chectAnsweredAllQuestions;

    @FXML
    private Button enterFavFod;

    @FXML
    private Button enterLifestyle;

    @FXML
    private Button enterPercentageBodyFat;

    @FXML
    private Text textMealPlan;

    @FXML
    void initialize() {
        ArrayList<RadioButton> offFod = new ArrayList<>();
        textMealPlan.setVisible(false);

        enterFavFod.setOnAction(event -> {
            if(favFodBread.isSelected()){
                offFod.add(favFodBread);
            }

            else if(favFodFish.isSelected()){
                offFod.add(favFodFish);
            }

            else if(favFodMeal.isSelected()){
                offFod.add(favFodMeal);
            }

            else if(favFodCookies.isSelected()){
                offFod.add(favFodCookies);
            }

            else if(favFodSweets.isSelected()){
                offFod.add(favFodSweets);
            }

            else if(favFodNuts.isSelected()){
                offFod.add(favFodNuts);
            }

            else if(favFodDairyProducts.isSelected()){
                offFod.add(favFodDairyProducts);
            }

            favFodGreens.setVisible(false);
            favFodCookies.setVisible(false);
            favFodBread.setVisible(false);
            favFodDairyProducts.setVisible(false);
            favFodFish.setVisible(false);
            favFodMeal.setVisible(false);
            favFodNuts.setVisible(false);
            favFodSweets.setVisible(false);
            textFavoriteFoods.setVisible(false);
            enterFavFod.setVisible(false);
        });

        enterLifestyle.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) lifeStyleGroup.getSelectedToggle();
            if(selectedRadioButton != null){
                lifestyleActive.setVisible(false);
                lifestyleMedium.setVisible(false);
                lifestyleSedentary.setVisible(false);
                textChooseLifestyle.setVisible(false);
                enterLifestyle.setVisible(false);
            }
        });

        enterPercentageBodyFat.setOnAction(event -> {
            Integer inputFatBodyPer = Integer.parseInt(bodyFatPercentage.getText());
            if(inputFatBodyPer > 0){
                bodyFatPercentage.setVisible(false);
                enterPercentageBodyFat.setVisible(false);
                textBodyFatPercentage.setVisible(false);
            }
        });

        replyGetAMealPlan.setOnAction(event -> {
            if(enterPercentageBodyFat.isVisible() == false){
                if(enterLifestyle.isVisible() == false){
                    if(enterFavFod.isVisible() == false){
                        replyGetAMealPlan.setVisible(false);
                        chectAnsweredAllQuestions.setVisible(false);
                        textAnswerQuestions.setVisible(false);
                        textMealPlan.setVisible(true);
                        if(Integer.parseInt(bodyFatPercentage.getText()) >= 25){
                            if(favFodDairyProducts.isDisable() == false){
                                if(lifestyleSedentary.isSelected() == true){
                                    textMealPlan.setText("The morning should start with boiled eggs, the daily ration should be made up of small portions, and eat every 2-3 hours." +
                                            "You need to give up cookies and sweets and foods that have a high percentage of fat. " +
                                            "Change your lifestyle from inactive to passive, " +
                                            "go for walking, and add a 30 minute strength training session. " +
                                            "During the day, consume complex carbohydrates, various cereals, buckwheat, or rice, " +
                                            "be sure to add salads, as well as meat, but only cooked chicken breast, " +
                                            "it is very important to consume 1.5 grams of protein per 1 kg of weight. " +
                                            "When you want something sweet, you can eat dried fruits.");
                                }
                            }
                        }
                        if(lifestyleActive.isSelected() == true){
                            textMealPlan.setText("The morning should start with boiled eggs, the daily ration should be made up of small portions, and eat every 2-3 hours.\n" +
                                    "You need to give up cookies and sweets and foods that have a high percentage of fat. " +
                                    "During the day, consume complex carbohydrates, various cereals, buckwheat, or rice, be sure to add salads, as well as meat, " +
                                    "but only cooked chicken breast, " +
                                    "it is very important to consume 1.5 grams of protein per 1 kg of weight. " +
                                    "When you want something sweet, you can eat dried fruits. In the evening, have a snack with non-fat cottage cheese. ");
                        }
                        else if(lifestyleActive.isSelected() == true){
                            textMealPlan.setText("For more effective weight loss, you should go jogging, as well as add strength training to your daily schedule. " +
                                    "The morning should start with boiled eggs, the daily ration should be made up of small portions, and eat every 2-3 hours.\n" +
                                    "You need to give up cookies and sweets and foods that have a high percentage of fat. During the day, consume complex carbohydrates, " +
                                    "various cereals, buckwheat, or rice, be sure to add greens to the meal, as well as meat, but only cooked chicken breast, it is very " +
                                    "important to consume 1.5 grams of protein per 1 kg of weight. When you want something sweet, you can eat dried fruits. " +
                                    "In the evening, have a snack with non-fat cottage cheese. ");
                        }
                        else if(Integer.parseInt(bodyFatPercentage.getText()) >= 15){
                            textMealPlan.setText("For more effective weight loss, you should go jogging, as well as add strength training to your daily schedule. " +
                                    "The morning should start with boiled eggs, the daily ration should be made up of small portions, and eat every 2-3 hours.\n" +
                                    "You need to give up cookies and sweets and foods that have a high percentage of fat. " +
                                    "During the day, consume complex carbohydrates, various cereals, buckwheat, or rice, be sure to add greens to the meal, " +
                                    "as well as meat, but only cooked chicken breast, it is very important to consume 1.5 grams of protein per 1 kg of weight. " +
                                    "When you want something sweet, you can eat dried fruits. " +
                                    "In the evening, have a snack with non-fat cottage cheese. ");
                        }
                        else if(Integer.parseInt(bodyFatPercentage.getText()) >= 10){
                            textMealPlan.setText("For more effective weight loss, you should go jogging, as well as add strength training to your daily schedule, " +
                                    "paying special attention to the legs and back, as these are the largest muscle groups. " +
                                    "The morning should start with boiled eggs, the daily ration should be made up of small portions, and eat every 2-3 hours.\n" +
                                    "You need to give up cookies and sweets and foods that have a high percentage of fat. " +
                                    "During the day, consume complex carbohydrates, various cereals, buckwheat, or rice, " +
                                    "be sure to add greens to the meal, as well as meat, but only cooked chicken breast, " +
                                    "it is very important to consume 1.5 grams of protein per 1 kg of weight. When you want something sweet, " +
                                    "you can eat dried fruits. In the evening, have a snack with non-fat cottage cheese. ");
                        }
                    }

                    else{
                        System.out.println("Ошибка 404");
                    }
                }
            }
        });
    }
}
