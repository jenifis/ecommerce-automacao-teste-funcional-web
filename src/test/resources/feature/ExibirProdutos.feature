#language:pt
Funcionalidade: Gerenciar navegação e carrinho

  Contexto: Realizar login
    Dado que o usuário acesse a url "https://www.saucedemo.com/inventory.html"
    E realize login
    Quando a home for acessada

  Cenário: Remover produto do carrinho
    Dado que o usuário tenha adicionado o produto ao carrinho
    Quando acessar o carrinho
    E remover o produto "<nome>"
    Então o carrinho está vazio

  Cenário: Testar Filtro de Produtos

    Dado que a página inicial é carregada
    Quando o usuário aplicar o filtro "Price (low to high)"
    Então os produtos devem ser exibidos do menor preço para o maior

    Quando o usuário aplicar o filtro "Price (high to low)"
    Então os produtos devem ser exibidos do maior preço para o menor

    Quando o usuário aplicar o filtro "Name (A to Z)"
    Então os produtos devem ser exibidos de A a Z pelo nome

    Quando o usuário aplicar o filtro "Name (Z to A)"
    Então os produtos devem ser exibidos de Z a A pelo nome

  Cenário: Usuário realiza logout e é redirecionado para a tela de login
    Dado que o usuário está na home
    Quando Clicar no menu e em seguida no botão de logout
    Então o usuário deve ser desconectado e redirecionado para a página de login