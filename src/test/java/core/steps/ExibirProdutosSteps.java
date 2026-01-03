    package core.steps;

    import com.codeborne.selenide.Selenide;
    import core.setup.TestSetup;
    import io.cucumber.java.After;
    import io.cucumber.java.pt.Dado;
    import io.cucumber.java.pt.E;
    import io.cucumber.java.pt.Então;
    import io.cucumber.java.pt.Quando;

    public class ExibirProdutosSteps extends TestSetup {

        @Quando("a home for acessada")
        public void a_home_for_acessada() {
            exibirProdutosPage.validarHomePage();

        }

        @Dado("que seja exibido o produto na home {string} {string} {string}")
        public void queSejaExibidoOProdutoNaHome(String nome, String descricao, String preco) {
            exibirProdutosPage.validarProdutoNaHome(
                    nome,
                    descricao,
                    preco
                    , "");

        }
        @Então("deve ser exibido o produto na Home {string} {string} {string}")
        public void exibirProdutoNaHome(String nome, String descricao, String preco) {
            queSejaExibidoOProdutoNaHome(
                    nome,
                    descricao,
                    preco);

        }
        @Dado("que as imagens sejam carregadas na Home {string}")
        public void queAsImagenSejamCarregadasNaHome(String nome) {
            exibirProdutosPage.validarImagemProdutoCarregada(
                    nome
            );
        }
        @E("continuar comprando")
        public void continuarComprando(){
            cartPage.clicarContinuarComprando();
        }
        @E("validar redes sociais")
        public void validarRedes(){
            cartPage.validarRedesSociais();
        }

        @E("clicar no botão about")
        public void clicarBotaoAbout(){
            cartPage.clicarBotaoAbout();
        }

    }