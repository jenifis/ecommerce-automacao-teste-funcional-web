#language:pt

Funcionalidade: Interações básicas do usuário

  Contexto:
    Dado que o usuário acesse a url "https://www.saucedemo.com/inventory.html"
    E realize login
    Quando a home for acessada

  Esquema do Cenario: Cenario: Resetar carrinho
    Quando o usuário selecionar o produto na Home "<nome>"
    E clicar no menu lateral esquerdo
    E clicar em reset app state
    Então o carrinho deve ficar vazio

    Exemplos:
      | nome                              |
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |
