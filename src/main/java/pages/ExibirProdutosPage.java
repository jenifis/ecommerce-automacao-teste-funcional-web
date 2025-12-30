package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExibirProdutosPage {
    public void validarHomePage() {
        $(byXpath("//div[@class='app_logo' and contains(text(),'Swag Labs')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//span[@data-test='title' and contains(text(),'Products')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

    }

    public void validarProdutoNaHome(String nomeProduto, String descricaoProduto, String valorProduto, String caminhoImagem) {
        $(byXpath("//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(30));

        $(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../..//div[@data-test='inventory-item-desc' and contains(text(),\"" + descricaoProduto + "\")]"))
                .shouldBe(Condition.visible, Duration.ofSeconds(5));

        System.out.println($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText());

        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains("$"));
        assertTrue($(byXpath("//div[@data-test='inventory-item-name' and contains(text(),'" + nomeProduto + "')]/../../..//div[@data-test='inventory-item-price']")).getOwnText().contains(valorProduto));

    }

    public void validarImagemProdutoCarregada(String nomeProduto) {
        SelenideElement img =
                $(byXpath("//div[@class='inventory_item'][.//div[text()='" + nomeProduto + "']]//img"));

        img.shouldBe(Condition.visible, Duration.ofSeconds(30));

        Boolean carregada = Selenide.executeJavaScript(
                "return arguments[0].complete && arguments[0].naturalWidth > 0;",
                img
        );

        assertTrue(carregada, "Imagem não carregou corretamente");
    }
}