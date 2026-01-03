package core.steps;

import com.codeborne.selenide.Selenide;
import core.setup.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.CartPage;

public class CartSteps extends TestSetup {

    @After
public void after(){
    Selenide.closeWebDriver();
}
    @Quando("o usuario selecionar o produto {string} na home")
    public void oUsuarioSelecionarOProdutoNaHome(String nomeProduto) {
        System.out.println(nomeProduto);
        cartPage.clicarAdicionarProdutoNoCarrinho(nomeProduto);
    }
    @Quando("clicar no carrinho")
public void clica_no_carrinho() {
    cartPage.clicarNoCarrinho();

}

    @Então("sera validado dentro do carrinho o {string} {string} {string} do produto")
public void seraValidadoDentroDoCarrinhoDoProduto(String nome, String descricao, String preco) {
    cartPage.validarProdutoNoCarrinho(
            nome,
            descricao,
            preco
            , "");

}
    @Quando("o usuario clicar em checkout")
public void clicarEmCheckout() {
    cartPage.clicarNoCheckout();
}

    @Quando("preencher as informações de entrega {string} {string} {string}")
public void preencherAsInformacoesDeEntrega(String firstName, String lastName, String postalCode) {
    cartPage.preencherAsInformacoesDeEntrega(
            firstName,
            lastName,
            postalCode
    );
}
    @Quando("clicar em continuar")
public void clicarEmContinue(){
    cartPage.clicarEmContinue();
}
    @Então("sera exibido a tela de checkout com todos os dados do produto {string} {string} {string}")
public void seraValidadoDentroDoCheckout(String nome, String descricao, String preco) {
    cartPage.validarProdutoCheckout(
            nome,
            descricao,
            preco);
}
    @Quando("clicar em finish para finalizar a compra")
public void finalizarCompra(){
    cartPage.clicarEmFinish();
}
    @Então("sera validado a mensagem de agradecimento pela compra")
public void validarMensagemAgradecimentoPelaCompraFinalizada(){
    cartPage.validarMensagemDeAgradecimentoPelaCompra();
}
    @Então("sera validado o texto de despacho da compra")
public void validarTextoDeDespachoDaCompra(){
    cartPage.validarTextoDeDespachoDaCompra();
}
    @Quando("clicar em back home para voltar ao menu inicial")
public void clicarEmBackHome(){
    cartPage.clicarEmBackHome();
}
    @Quando("o usuário clicar no nome do produto {string}")
    public void clicarNoNomeDoProduto(String nomeProduto) {
        cartPage.clicarNoNomeDoProduto(nomeProduto);
    }
    @Dado("que o usuário tenha adicionado o produto ao carrinho")
    public void queOUsuarioTenhaAdicionadoOProdutoAoCarrinho() {
        cartPage.clicarBotaoCarrinho();
    }

    @Quando("acessar o carrinho")
    public void acessarOCarrinho() {
      cartPage.clicarNoCarrinho();
    }

    @E("remover o produto {string}")
    public void removerOProduto(String nomeProduto) {
        cartPage.clicarBotaoRemoverItem(nomeProduto);

    }

    @Então("o carrinho está vazio")
    public void oCarrinhoEstaVazio() {
        menuPage.validarCarrinhoVazio();
    }
}