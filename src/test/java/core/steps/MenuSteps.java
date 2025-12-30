package core.steps;

import com.codeborne.selenide.Selenide;
import core.setup.TestSetup;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class MenuSteps extends TestSetup {

        @Quando("o usuário selecionar o produto na Home {string}")
        public void selecionarProdutoNaHome(String nome){
            cartPage.clicarAdicionarProdutoNoCarrinho(nome);
        }
        @Quando("clicar no menu lateral esquerdo")
        public void abrirMenuLateral(){
            menuPage.abrirMenuLateral();
    }
        @Então("clicar em reset app state")
        public void clicaremResetAppState(){
            menuPage.clicarEmResetAppState();
        }
        @Então ("o carrinho deve ficar vazio")
        public void validarCarrinhoVazio(){
            menuPage.validarCarrinhoVazio();
        }
        @Quando("clicar em Back to products")
        public void clicarEmBackToProducts(){
            menuPage.clicarEmBackToProducts();
        }
        @Então("a home de produtos deve ser exibida")
        public void validarORetornoParaHomePage(){
            menuPage.validarRetornoParaHomePage();

        }

    }
