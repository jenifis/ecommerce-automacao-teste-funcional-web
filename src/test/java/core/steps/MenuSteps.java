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
    @Dado("que a página inicial é carregada")
    public void queAPaginaInicialECarregada() {
        exibirProdutosPage.validarHomePage();
    }

    @Quando("o usuário aplicar o filtro {string}")
    public void oUsuarioAplicarOFiltro(String filtro) {
        switch (filtro) {
            case "Price (low to high)":
               menuPage.filtroPrecoCrescente();
                break;
            case "Price (high to low)":
                menuPage.filtroprecoDescresente();
                break;
            case "Name (A to Z)":
                menuPage.filtroNomeAZ();
                break;
            case "Name (Z to A)":
                menuPage.filtroNomeZA();
                break;
        }

    }

    @Então("os produtos devem ser exibidos do menor preço para o maior")
    public void osProdutosDevemSerExibidosDoMenorPrecoParaOMaior() {
        menuPage.validarProdutosOrdenadosPorPrecoCrescente();
    }

    @Então("os produtos devem ser exibidos do maior preço para o menor")
    public void osProdutosDevemSerExibidosDoMaiorPrecoParaOMenor() {
        menuPage.validarProdutosOrdenadosPorPrecoDecrescente();
    }

    @Então("os produtos devem ser exibidos de A a Z pelo nome")
    public void osProdutosDevemSerExibidosDeAAZPeloNome() {
        menuPage.validarProdutosOrdenadosPorNomeCrescente();
    }

    @Então("os produtos devem ser exibidos de Z a A pelo nome")
    public void osProdutosDevemSerExibidosDeZAAPeloNome() {
        menuPage.validarProdutosOrdenadosPorNomeDecrescente();
    }
    @Dado("que o usuário está na home")
    public void queOUsuarioEstaNaHome() {
        exibirProdutosPage.validarHomePage();
    }

    @Quando("Clicar no menu e em seguida no botão de logout")
    public void clicarNoMenuEEmSeguidaNoBotaoDeLogout() {
        menuPage.clicarMenu();
        menuPage.clicarBotaoLogout();

    }

    @Então("o usuário deve ser desconectado e redirecionado para a página de login")
    public void oUsuarioDeveSerDesconectadoERedirecionadoParaAPaginaDeLogin() {
        menuPage.verificarTelaLogin();
    }
}

