# PARQUE WEB API

## TRABALHO DA DISCIPLINA DE PROGRAMAÇÃO DE SOFWARE APLICADO

### Objetivo:
O objetivo é consolidar o conhecimento sobre conceitos e construção de sistemas web (cliente-servidor e
serviços) empresariais orientados a objetos em arquiteturas cliente-servidor multicamadas através da exploração dos tópicos discutidos na disciplina de Programação de Software Aplicado.

### Enunciado do problema:
Estamos interessados em um sistema de informação para realizar a venda de ingressos e gestão de entradas
em um parque de diversões. Uma análise inicial levantou as seguintes regras de negócio:
A política básica de preços de “passaportes” de acesso ao parque bastante simples: o valor é de U$ 100,00
por dia, mas se o cliente comprar um passaporte válido por mais dias (até um máximo de 7) os dias
subsequentes sofrem um desconto incremental de 20% ao dia (desconto de 20% sobre o valor do dia anterior).
O parque com frequência faz convênios com diferentes empresas e inventa novas promoções. Todas as
promoções são cumulativas, ou seja, se uma pessoa se enquadra em mais de uma situação pode acumular
as vantagens. Atualmente estão definidas as seguintes promoções, que são habilitadas ou desabilitadas pelo gestor do sistema.

1. Estudantes universitários têm desconto adicional de 10% a partir do 2º dia na compra de passaportes
para pelo menos 5 dias.
2. Quem paga com cartão de crédito da bandeira “PagueBem” tem um desconto adicional de 2% sobre
o valor total do passaporte.
3. Pessoas com mais de 65 anos tem direito a um desconto adicional de 15% a partir do 3º dia na
compra de passaportes para pelo menos 4 dias.
4. Segurados da empresa “SeguroGarantido” tem desconto adicional de 2% sobre o valor total do
passaporte na compra de passaportes para 7 dias.
Um código inicial que implementa estas regras de negócio está disponível e pode ser alterada pelo grupo
conforme a necessidade.

O sistema deve permitir os seguintes casos de uso por parte dos clientes:
- Solicitar orçamento para um passaporte dados uma data, número de dias e descontos aplicáveis.
- Confirmar a compra do passaporte, para isto deve estar logado no sistema. O sistema emite, então, um código de acesso contendo um código (passível de transformação para código de barras ou qr-code), data inicial e número de dias do passaporte.

O sistema deve permitir os seguintes casos de uso por parte das roletas de entrada:
- Validação de ticket para liberação da entrada. O sistema deve receber a data atual e número do ticket, e verificar se a entrada está liberada para o dia/ingresso. Este acesso deve estar disponível, também, na forma de um serviço RESTful.

O sistema deve permitir os seguintes casos de uso por parte do gestor do sistema:
- Habilitar e desabilitar promoções (que podem ser fixas no sistema)
- Gerar relatório contendo valores totais mensais, ou diários, de vendas de passaportes a partir de um período informado
- Gerar relatório contendo números totais de entradas diárias no parque a partir de um período informado

IMPORTANTE: Outros casos de uso podem ser implementados pelo grupo, caso sintam a necessidade.

### Requisitos:
Os seguintes itens são obrigatórios na implementação do sistema:
- Interface web.
- Arquitetura multicamada (pelo menos 3) com separação de responsabilidades.
- Uso dos padrões de projeto explorados nas disciplinas de Fundamentos de Desenvolvimento de Software e Programação de Software Aplicado sendo obrigatoriamente:
 - Uso do padrão MVC na camada de apresentação;
 - Uso do padrão “Facade” para isolar a camada de domínio da camada de apresentação;
 - Uso do padrão arquitetural “Domain Model” na camada de domínio;
 - Uso do padrão “DAO”/”Repository” na camada de persistência.
- O grupo poderá utilizar outros padrões que julgar necessário para atender os requisitos da aplicação.
- Persistência em base de dados relacional.
- A camada de persistência deve ser implementada utilizando um mapeador objeto-relacional.
- Tratamento correto do encapsulamento de exceções entre as camadas.
- A base de dados deverá ter sido previamente populada com um conjunto de dados suficiente para permitir
a avaliação adequada de todos os casos de uso propostos.