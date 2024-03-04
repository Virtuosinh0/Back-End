---
marp: true
theme: venson
author: Ramon Venson
title: Avaliação 01 - Exercícios
footer: Disciplina de Backend - Professor Ramon Venson - SATC 2024
header: Avaliação 01 - Exercícios
---

<!-- 
_class: lead
-->

# Avaliação 01 - Lista de Exercícios

---

<!--
paginate: true
-->

## Aula 02 - Exercício A

Implemente um programa em java que seja capaz de gerar e retornar no console o seguinte modelo de mensagem:

````
Cássio Ramos é um futebolista brasileiro de 32 anos que atua como goleiro. Atualmente defende o Corinthians.
````

A mensagem de texto deverá conter os seguintes requisitos:
* [Nome](https://venson.net.br/resources/data/nomes.txt) e [sobrenome](https://venson.net.br/resources/data/sobrenomes.txt) aleatórios
* Idade (entre 17 e 40 anos)
* [Posição](https://venson.net.br/resources/data/posicoes.txt) (aleatória)
* [Clube](https://venson.net.br/resources/data/clubes.txt) (aleatório)

---

## Aula 02 - Exercício B

Utilizando como base o exercício anterior, crie uma classe chamada `JogadorGerador` contendo um método capaz de realizar as requisições HTTP apenas uma vez e construir múltiplos objetos do tipo `Jogador`.

Crie também uma classe chamada `Jogador` contendo métodos que permitam que cada dado do jogador seja acessado individualmente através de métodos (`getNome`, `getSobrenome`, `getPosicao`, `getIdade`, `getClube`) e um método que gere a mensagem do exercício anterior (`getDescricao`).