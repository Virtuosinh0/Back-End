| | | | | | | |
|-|-|-|-|-|-|-|
| |Spotify| | | | | |
| |Descrição |URI|Método HTTP|Corpo|Resposta Esperada|Erros Esperados|
| |Retornar informações de um usuário|GET /usuarios/{usuario-id}|GET|Vazio|200 OK |404 Not Found - usuário não foi encontrado.|
| |Criar novo usuário|POST /usuarios|POST|{ "nome": "João", "email": "joao@email.com" }|201 Created|400 Bad Request - dados inválidos.|
| |Atualizar informações do usuário|PUT /usuarios/{usuario-id}|PUT|{ "nome": "João Silva", "email": "joao@novoemail.com" }|200 OK |404 Not Found - usuário não foi encontrado.|
| |Deletar um usuário|DELETE /usuarios/{usuario-id}|DELETE|Vazio|200 OK |404 Not Found - usuário não foi encontrado.|
| |Retornar playlists do usuário|GET /usuarios/{usuario-id}/playlists|GET|Vazio|200 OK |404 Not Found - usuário não foi encontrado.|
| |Criar nova playlist|POST /usuarios/{usuario-id}/playlists|POST|{ "nome": "Rock Clássico", "musicas": ["musica1", "musica2"] }|201 Created|400 Bad Request - dados inválidos.|
| |Retornar playlist específica|GET /usuarios/{usuario-id}/playlists/{playlist-id}|GET|Vazio|200 OK|404 Not Found - playlist não foi encontrada.|
| |Atualizar playlist|PUT /usuarios/{usuario-id}/playlists/{playlist-id}|PUT|{ "nome": "Rock Atualizado", "musicas": ["musica1", "musica3"] }|200 OK|404 Not Found - playlist não foi encontrada.|
| |Deletar uma playlist|DELETE /usuarios/{usuario-id}/playlists/{playlist-id}|DELETE|Vazio|200 OK|404 Not Found - playlist não foi encontrada.|
