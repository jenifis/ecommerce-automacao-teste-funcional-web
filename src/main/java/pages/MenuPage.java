package pages;

import com.codeborne.selenide.*;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
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
    public void aplicarFiltro(String filtro){
        $(byXpath("//select[@class='product_sort_container']")).shouldBe(Condition.visible,Duration.ofSeconds(30))
                .selectOption(filtro);
    }
    public void filtroPrecoCrescente(){
        aplicarFiltro("Price (low to high)");
    }
    public void filtroprecoDescresente(){
        aplicarFiltro("Price (high to low)");
    }
    public void filtroNomeAZ(){
        aplicarFiltro("Name (A to Z)");
    }
    public void filtroNomeZA(){
        aplicarFiltro("Name (Z to A)");
    }
    public void validarProdutosOrdenadosPorNomeCrescente() {
        ElementsCollection nomes =$$(byXpath("//div[@class='inventory_item_name']"));
        String nomeAnterior = "";
        for (SelenideElement nome : nomes) {
            String nomeAtual = nome.text();
            if (nomeAtual.compareTo(nomeAnterior) < 0) {
                throw new AssertionError("Os produtos não estão ordenados de A a Z.");
            }
            nomeAnterior = nomeAtual;
        }
    }
    public void validarProdutosOrdenadosPorNomeDecrescente() {
        ElementsCollection nomes = $$(byXpath("//div[@class='inventory_item_name']"));
        String nomeAnterior = "ZZZ"; // Algo que venha após todos os nomes reais
        for (SelenideElement nome : nomes) {
            String nomeAtual = nome.text();
            if (nomeAtual.compareTo(nomeAnterior) > 0) {
                throw new AssertionError("Os produtos não estão ordenados de Z a A.");
            }
            nomeAnterior = nomeAtual;
        }
    }
    public void validarProdutosOrdenadosPorPrecoCrescente() {
        ElementsCollection precos = $$(byXpath("//div[@class='inventory_item_price']"));
        double precoAnterior = -1;
        for (SelenideElement preco : precos) {
            double precoAtual = Double.parseDouble(preco.text().replace("$", "").trim());
            if (precoAtual < precoAnterior) {
                throw new AssertionError("Os produtos não estão ordenados do menor para o maior preço.");
            }
            precoAnterior = precoAtual;
        }
    }
    public void validarProdutosOrdenadosPorPrecoDecrescente() {
        ElementsCollection precos = $$(byXpath("//div[@class='inventory_item_price']"));
        double precoAnterior = Double.MAX_VALUE;
        for (SelenideElement preco : precos) {
            double precoAtual = Double.parseDouble(preco.text().replace("$", "").trim());
            if (precoAtual > precoAnterior) {
                throw new AssertionError("Os produtos não estão ordenados do maior para o menor preço.");
            }
            precoAnterior = precoAtual;
        }
    }
    public void clicarMenu(){
        $(byId("react-burger-menu-btn")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
    public void clicarBotaoLogout(){
        $(byId("logout_sidebar_link")).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

    }
    public void verificarTelaLogin() {
        $(byId("login-button")).shouldBe(Condition.visible, Duration.ofSeconds(10));

    }
}

