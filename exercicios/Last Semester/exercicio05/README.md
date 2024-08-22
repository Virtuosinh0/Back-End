# Rotas de consumo da api

## Buscar nome da equipe
```json
http://localhost:8080/ajuda
```
> Response body (200 OK)
```json
{
    "nomes": "Daniel, Gean, Kauan, Silvio",
    "projeto": "Canal de notícias"
}
```
___
## Cadastrar noticias 
```json
http://localhost:8080/news
```
```json
{
    "news_title":"Titulo da noticias",
    "news_country":"Brasil",
    "news_date":"01/09/2024"
}
```
> Response Body (201 Created)
```json
{
    "news_id": 1,
    "news_title": "Titulo da noticias",
    "news_country": "Brasil",
    "news_date": "01/09/2024"
}
```
> Exceptions (400 Bad Request)

```json
{
    "status": "BAD_REQUEST",
    "message": "Titulo não pode estar vazio."
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "País não pode estar vazio."
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "Data não pode estar vazio"
}
```
___
## Buscar todas as noticias ordenado por data mais recente.
```json
http://localhost:8080/news
```
> Response body (200 OK)
```json
[
    {
        "news_id": 1,
        "news_title": "Titulo da noticias",
        "news_country": "Brasil",
        "news_date": "01/12/2024",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/news/1"
            }
        ]
    },
    {
        "news_id": 2,
        "news_title": "Titulo da noticias",
        "news_country": "Brasil",
        "news_date": "01/10/2024",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/news/2"
            }
        ]
    },
    {
        "news_id": 3,
        "news_title": "Titulo da noticias",
        "news_country": "Brasil",
        "news_date": "01/09/2024",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/news/3"
            }
        ]
    }
]
```
___
## Buscar noticia por id unico
```json
http://localhost:8080/news/{id}
```
> Response body (200 OK)
```json
{
    "news_id": 1,
    "news_title": "Titulo da noticias",
    "news_country": "Brasil",
    "news_date": "01/12/2024",
    "links": [
        {
            "rel": "Todas as noticias",
            "href": "http://localhost:8080/news"
        }
    ]
}
```
> Exeption (404 Not Found)
````Nenhum noticia com este id````
___
## Atualizar noticia por id unico
```json
http://localhost:8080/news/{id}
```
```json
{
    "news_title":"Titulo da noticias atualizado",
    "news_country":"Brasil",
    "news_date":"01/09/2024"
}
```
> Response body (200 ok)
```json
{
    "news_id": 1,
    "news_title": "Titulo da noticias atualizado",
    "news_country": "Brasil",
    "news_date": "01/09/2024"
}
```
> Exceptions (400 Bad Request)

```json
{
    "status": "BAD_REQUEST",
    "message": "Titulo não pode estar vazio."
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "País não pode estar vazio."
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "Data não pode estar vazio"
}
```
___
## Deletar noticia por id
```json
http://localhost:8080/news/{id}
```
> Response (204 No Content)

> Exception (404)
````Nenhum noticia com este id````
___
## Cadastrar esportes 
```json
http://localhost:8080/sport
```
```json
{
    "sport_title":"Titulo",
    "sport_team":"Real Madrid",
    "sport_date":"01/01/2023"
}
```
> Response Body (201 Created)
```json
{
    "sport_id": 1,
    "sport_title": "Titulo",
    "sport_team": "Real Madrid",
    "sport_date": "01/01/2023"
}
```
> Exceptions
```json
{
    "status": "BAD_REQUEST",
    "message": "Campo titulo não pode estar vazio"
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "Campo nome de time não pode estar vazio"
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "O campo data não pode estar nulo"
}
```
___
## Buscar todos os esportes ordenado por data da postagem
```json
http://localhost:8080/sport
```
> Response (200 OK)
```json
[
    {
        "sport_id": 1,
        "sport_title": "Titulo",
        "sport_team": "Real Madrid",
        "sport_date": "01/09/2023",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/sport/1"
            }
        ]
    },
    {
        "sport_id": 2,
        "sport_title": "Titulo",
        "sport_team": "Real Madrid",
        "sport_date": "01/01/2023",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/sport/2"
            }
        ]
    }
]
```
___
## Buscar postagem de esporte por id
```json
http://localhost:8080/sport/{id}
```
> Response body (200 OK)
```json
{
    "sport_id": 1,
    "sport_title": "Titulo",
    "sport_team": "Real Madrid",
    "sport_date": "01/09/2023",
    "links": [
        {
            "rel": "Lista de esportes",
            "href": "http://localhost:8080/sport"
        }
    ]
}
```
___
## Atualizar postagem de esporte por id
```json
http://localhost:8080/sport/{id}
```
```json
{
    "sport_title":"Titulo",
    "sport_team":"Real Madrid",
    "sport_date":"01/01/2023"
}
```
> Response body (200 OK)
```json
{
    "sport_id": 1,
    "sport_title": "Titulo atualizado",
    "sport_team": "Real Madrid",
    "sport_date": "01/01/2023"
}
```
> Exceptions (400 Bad Request)
```json
{
    "status": "BAD_REQUEST",
    "message": "Campo titulo não pode estar vazio"
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "Campo nome de time não pode estar vazio"
}
```
```json
{
    "status": "BAD_REQUEST",
    "message": "O campo data não pode estar nulo"
}
```
## Deletar postagem de esporte por id
```json
http://localhost:8080/sport/1
```
> Response (204 Not Content)
