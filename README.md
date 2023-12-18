# NewsApp - App simples para exibição de noticias

Esse é um aplicativo simples, desenvolvido para estudos de arquitetura modular e boas prátiacas no desenvolvimendo Android
Ele consome a API de noticias pública https://newsapi.org/ para exibição das informações

## Estrutura
O app está estruturado seguindo a arquitetura MVVM, com os seguintes módulos seguindo a documentação da Google: https://developer.android.com/topic/modularization/patterns?hl=pt-br
- app: contém a main aplication, configurações de injeção de dependencias, configurações de dependencias principais via gradle
- data: módulo responsável por obter os dados relacionados à noticias. Ele funciona de forma transparente, quem utiliza o módulo não sabe se as informações são recebidas de um banco de dados, API ou Mock, de acordo com as diretrizes de desenvolvimento da Google
- network: módulo reponsável pela implementação do retrofit para chamar APIs. É uma estrutura centralizada, caso precise alterar a lib Retrofit por outra, apenas esse módulo será impactado
- models: módulo responsável por centralizar os modelos de dados do projeto. Através dele, é possível compartilhar modelos entre módulos, sem a necessidade de dependencias complexas entre módulos. 
- features: módulo responsável por centralizar outros módulos com as features do aplicativo, como o módulo newslist com a listagem principal das noticias, e o newsdetails, com os detalhes das noticias

## Observações


## Melhorias para o futuro

## Problemas conhecidos
