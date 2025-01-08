## Nome do Projeto: PicPay Simplificado

### Descrição Geral:
O PicPay Simplificado é uma plataforma de pagamentos simplificada desenvolvida em Java. A aplicação permite realizar transferências de dinheiro entre usuários.

### Tecnologias Utilizadas:
Linguagem: Java
Frameworks: Spring Boot
Banco de Dados: PostgreSQL
Gerenciamento de Dependências: Maven

### Como Rodar a Aplicação:
Faça o clone do repositório:
git clone [<URL_DO_REPOSITÓRIO>](https://github.com/mikaelle1992/JavaSpringPicpay.git)
Certifique-se de ter o Docker instalado.
Na pasta raiz do projeto, execute o comando:
sudo docker-compose up -d


### Endpoint de transferência

POST /Transaction
{
    "value":10,
    "senderId":1, 
    "receiverId":2
}

### Endpoint de users

POST /users
{
    "firstName": "Antonio", 
    "lastName":"Teste", 
    "cpf":"12345678000", 
    "email":"teste@gmail.com", 
    "password":"123456A74", 
    "balance":200, 
    "usertype": "COMMON"
}