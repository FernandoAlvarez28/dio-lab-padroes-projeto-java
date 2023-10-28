# Explorando Padrões de Projetos na Prática com Java
Resolução do desafio "Explorando Padrões de Projetos na Prática com Java" da [Digital Innovation One](https://web.dio.me).

## Summary

[Digital Innovation One](https://web.dio.me)'s (PT-BR) "Exploring Project Patterns with Java" challenge resolution.

## Descrição
Este desafio envolve implementar um padrão de projeto com Java puro (sem frameworks, como o Spring). Para isso implementei um [Chain of Responsability](https://refactoring.guru/pt-br/design-patterns/chain-of-responsibility) para validar algumas informações inseridas no "console" e criar (ou não) um "Seguro".

## Como executar:
1. Abra o arquivo [App.java](src/main/java/alvarez/fernando/padroesprojetojava/App.java) na sua IDE Java de preferência e execute-o;
    - O projeto usa [Maven](https://maven.apache.org) mas não possui nenhuma dependência externa.
2. O programa vai pedir algumas informações no console, e passará elas numa cadeia de [Handlers](src/main/java/alvarez/fernando/padroesprojetojava/handler/Handler.java) para validar e criar ou não um [Seguro](src/main/java/alvarez/fernando/padroesprojetojava/domain/insurance/model/Insurance.java) num Repository falso.

