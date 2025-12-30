package pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuPage {

    public void abrirMenuLateral(){
        $(byXpath("//button[@id='react-burger-menu-btn']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click(ClickOptions.usingJavaScript());
        executeJavaScript("window.scrollTo(0, 0);");

    }
    public void clicarEmResetAppState() {
        $(byId("reset_sidebar_link"))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click(ClickOptions.usingJavaScript());
    }
    public void validarCarrinhoVazio() {
        $(byXpath("//span[@data-test='shopping_cart_badge']"))
                .shouldNotBe(Condition.exist);
        Selenide.sleep(2000);
    }
    public void clicarEmBackToProducts(){
        $(byXpath("//button[@data-test='back-to-products']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void validarRetornoParaHomePage(){
        $(byXpath("//div[@class='app_logo' and contains(text(),'Swag Labs')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//span[@data-test='title' and contains(text(),'Products')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}

