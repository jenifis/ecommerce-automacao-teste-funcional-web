#language:pt

Funcionalidade: Comprar produtos


  Contexto: Realizar login
    Dado que o usuário acesse a url "https://www.saucedemo.com/inventory.html"
    E realize login
    Quando a home for acessada

  Esquema do Cenario: Selecionar produto e iniciar checkout

    Dado que seja exibido o produto na home "<nome>" "<descricao>" "<preco>"
    E que as imagens sejam carregadas na Home "<nome>"
    Quando o usuario selecionar o produto "<nome>" na home
    E clicar no carrinho
    Entao sera validado dentro do carrinho o "<nome>" "<descricao>" "<preco>" do produto
    Quando o usuario clicar em checkout
    E preencher as informações de entrega "<nomeComprador>" "<sobrenomeComprador>" "<cep>"
    E clicar em continuar

    Exemplos:
      | nome                              | descricao                                                                                                                                                              | preco | nomeComprador | sobrenomeComprador | cep                 |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | 29.99 | Thierry       | Soares             | 9                   |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | 9.99  | Gabriela      | Moreno             | 34                  |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | 15.99 | Maria         | Silva              | 2353212321233122332 |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | 49.99 | Sara          | Priscila           | 32332               |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | 7.99  | Jennifer      | Jardim             | CEP                 |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | 15.99 | Teste         | Teste              | 321                 |

  Esquema do Cenario: Finalizar compra e validar confirmação

    Dado que seja exibido o produto na home "<nome>" "<descricao>" "<preco>"
    Quando o usuario selecionar o produto "<nome>" na home
    E clicar no carrinho
    E continuar comprando
    E o usuario clicar em checkout
    E preencher as informações de entrega "<nomeComprador>" "<sobrenomeComprador>" "<cep>"
    E clicar em continuar
    Entao sera exibido a tela de checkout com todos os dados do produto "<nome>" "<descricao>" "<preco>"
    Quando clicar em finish para finalizar a compra
    Entao sera validado a mensagem de agradecimento pela compra
    E sera validado o texto de despacho da compra
    Quando clicar em back home para voltar ao menu inicial
    E validar redes sociais
    E clicar no botão about

    Exemplos:
      | nome                              | descricao                                                                                                                                                              | preco | nomeComprador | sobrenomeComprador | cep                 |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | 29.99 | Thierry       | Soares             | 9                   |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | 9.99  | Gabriela      | Moreno             | 34                  |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | 15.99 | Maria         | Silva              | 2353212321233122332 |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | 49.99 | Sara          | Priscila           | 32332               |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | 7.99  | Jennifer      | Jardim             | CEP                 |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | 15.99 | Teste         | Teste              | 321                 |

  Esquema do Cenario: Continuar comprando
    Quando o usuário clicar no nome do produto "<nome>"
    E clicar em Back to products
    Entao a home de produtos deve ser exibida
    E deve ser exibido o produto na Home "<nome>" "<descricao>" "<preco>"


    Exemplos:
      | nome                              | descricao                                                                                                                                                              | preco |
      | Sauce Labs Backpack               | carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.                                 | 29.99 |
      | Sauce Labs Bike Light             | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | 9.99  |
      | Sauce Labs Bolt T-Shirt           | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | 15.99 |
      | Sauce Labs Fleece Jacket          | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | 49.99 |
      | Sauce Labs Onesie                 | Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.        | 7.99  |
      | Test.allTheThings() T-Shirt (Red) | This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.              | 15.99 |

