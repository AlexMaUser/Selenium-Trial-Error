package org.template;

import org.openqa.selenium.By;

public class PracticeFormPage extends FormsPage {
    private By femaleRadioButton = By.id("gender-radio-2");
    private By sportsHobbyCheckBox = By.id("hobbies-checkbox-1");
    private By readingHobbyCheckBox = By.id("hobbies-checkbox-2");
    private By musicHobbyCheckBox = By.id("hobbies-checkbox-3");
    private By submitButton = By.id("submit");


    public void clickFemaleRadioButton() {
        JavaScriptUtility.scrollToElementJS(femaleRadioButton);
        JavaScriptUtility.clickJS(femaleRadioButton);
    }

    public boolean isFemaleRadioButtonSelected() {
        return find(femaleRadioButton).isSelected();
    }

    public void clickSportsHubbyCheckBox() {
        if(!find(sportsHobbyCheckBox).isSelected()) {
            JavaScriptUtility.scrollToElementJS(sportsHobbyCheckBox);
            JavaScriptUtility.clickJS(sportsHobbyCheckBox);
        }
    }

    public void clickReadingHubbyCheckBox() {
        if(!find(readingHobbyCheckBox).isSelected()) {
            JavaScriptUtility.scrollToElementJS(readingHobbyCheckBox);
            JavaScriptUtility.clickJS(readingHobbyCheckBox);
        }
    }

    public void clickMusicHubbyCheckBox() {
        if(!find(musicHobbyCheckBox).isSelected()) {
            JavaScriptUtility.scrollToElementJS(musicHobbyCheckBox);
            JavaScriptUtility.clickJS(musicHobbyCheckBox);
        }
    }

    public void unclickReadingHubbyCheckBox() {
        if(find(readingHobbyCheckBox).isSelected()) {
            JavaScriptUtility.scrollToElementJS(readingHobbyCheckBox);
            JavaScriptUtility.clickJS(readingHobbyCheckBox);
        }
    }

    public boolean isReadingSelected() {
        return find(readingHobbyCheckBox).isSelected();
    }

    public void clickSubmitButton() {
        click(submitButton);
    }
}
