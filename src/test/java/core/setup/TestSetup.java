package core.setup;

import pages.CartPage;
import pages.ExibirProdutosPage;
import pages.LoginPage;
import pages.MenuPage;

public class TestSetup {

    public LoginPage loginPage;
    public ExibirProdutosPage exibirProdutosPage;
    public MenuPage menuPage;
    public CartPage cartPage;

    public TestSetup(){
        loginPage = new LoginPage();
        exibirProdutosPage = new ExibirProdutosPage();
        menuPage = new MenuPage();
        cartPage = new CartPage();
    }

}
