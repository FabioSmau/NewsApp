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
- ui: módulo responsável por centralizar views do projeto
- utils: módulo responsável por centralizar extensions, utils, e outras classes que podem ser reusadas no projeto como um todo

## Observações
- O aplicativo tem uma interface visual simples, mas com uma arquitetura bastante completa, utilizando JetPack Compose, Navigation, injeção de dependencias com Koin
- Alguns testes unitários foram implementados nos módulos de acordo com sua responsabilidade, testando injeções de dependencia, viewmodels, repositories, configurações do retrofit, entre outros testes 
- Um GitHub action foi configurado para buildar o projeto e rodar os testes unitários

## Melhorias para o futuro
- A interface com usuário pode ser melhorada
- Pensando em escala do aplicativo, podemos melhorar a estrutura de navigation para suportar várias telas em vários contextos, sem tornar a responsável pela navegação extensa
- O aplicativo poderia ganhar novas funcionalidades, como noticias favoritas, ou assuntos favoritos, categorias de noticias, entre outras
- O github pode ser melhorado para assinar e subir o aplicativo na Google Play
