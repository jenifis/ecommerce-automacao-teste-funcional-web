package core.steps;

import com.codeborne.selenide.Selenide;
import core.setup.TestSetup;
import io.cucumber.java.pt.Dado;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps extends TestSetup {

    @Dado("que o usuário acesse a url {string}")
    public void que_o_usuario_acesse_a_url(String url) {
        open(url);
    }
    @Dado("realize login")
    public void realize_login() {
        loginPage.digitarUsuario("standard_user");
        loginPage.digitarSenha("secret_sauce");
        loginPage.clicarBotao();
    }
}