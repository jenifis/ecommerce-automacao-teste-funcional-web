package pages;

import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public void digitarUsuario(String usuario) {
        $(byId("user-name")).shouldBe(Condition.visible, Duration.ofSeconds(30))
                .sendKeys(usuario);
    }

    public void digitarSenha(String senha) {
        $(byId("password")).shouldBe(Condition.visible, Duration.ofSeconds(30))
                .sendKeys(senha);
    }

    public void clicarBotao() {
        $(byId("login-button")).shouldBe(Condition.visible, Duration.ofSeconds(30))
                .click();
    }

}
