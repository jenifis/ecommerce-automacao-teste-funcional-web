package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage {

    public void clicarAdicionarProdutoNoCarrinho(String nomeProduto) {
        $(byXpath("//div[@data-test='inventory-item-name' and contains(text(), '" + nomeProduto + "')]"
                + "/ancestor::div[@class='inventory_item']//button[text()='Add to cart']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }

    public void validarProdutoNoCarrinho(String nomeProduto, String descricaoProduto, String valorProduto, String caminhoImagem) {
        $(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//div[@data-test='inventory-item-desc' and contains(text(),\"" + descricaoProduto + "\")]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(5));

        System.out.println($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText());

        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains("$"));
        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains(valorProduto));

    }

    public void clicarNoCarrinho() {
        $(byXpath("//div[@class='shopping_cart_container']//a[@class='shopping_cart_link']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void clicarNoCheckout(){
        $(byXpath("//button[@data-test='checkout']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void preencherAsInformacoesDeEntrega(String firstName, String lastName, String postalCode) {
        $(byXpath("//input[@data-test='firstName']")).setValue(firstName)
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//input[@data-test='lastName']")).setValue(lastName)
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//input[@data-test='postalCode']")).setValue(postalCode)
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

    }
    public void clicarEmContinue(){
        $(byXpath("//input[@data-test='continue']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void validarProdutoCheckout(String nomeProduto, String descricaoProduto, String valorProduto) {
        $(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//div[@data-test='inventory-item-desc' and contains(text(),\"" + descricaoProduto + "\")]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(5));

        System.out.println($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText());

        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains("$"));
        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains(valorProduto));

    }
    public void clicarEmFinish(){
        $(byXpath("//button[@data-test='finish']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void validarMensagemDeAgradecimentoPelaCompra(){
        $(byXpath("//h2[@class='complete-header' and contains(text(),'Thank you for your order!')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
    public void validarTextoDeDespachoDaCompra(){
        $(byXpath("//div[@class='complete-text' and contains(text(), 'Your order has been dispatched, and will arrive just as fast as the pony can get there!')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
    public void clicarEmBackHome(){
        $(byXpath("//button[@data-test='back-to-products']"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void clicarNoNomeDoProduto(String nomeProduto) {
        $(byXpath("//div[@data-test='inventory-item-name' and contains(text(), '"+nomeProduto+"')]/.."))
                .shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void clicarContinuarComprando(){
        $(byXpath("//*[@id=\"continue-shopping\"]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));
    }

    public void validarRedesSociais() {

        $("[data-test='social-twitter']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("href", "https://twitter.com/saucelabs"));

        $("[data-test='social-facebook']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("href", "https://www.facebook.com/saucelabs"));

        $("[data-test='social-linkedin']")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attribute("href", "https://www.linkedin.com/company/sauce-labs/"));
    }

    public void clicarBotaoAbout(){
        $(byXpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        $(byXpath("//*[@id=\"about_sidebar_link\"]")).click();
    }
    public void clicarBotaoCarrinho() {
        $(byId("add-to-cart-sauce-labs-backpack")).shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }
    public void clicarBotaoRemoverItem (String nomeProduto){
        $(byXpath("//button[contains(@id, 'remove-')]"))
                .shouldBe(Condition.visible,Duration.ofSeconds(30)).click();
    }

}
