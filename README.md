# 🚀 Smart Gateway 

O **Smart Gateway** é um projeto desenvolvido para a disciplina de **Sistemas Distribuídos**, com o objetivo de criar um **sistema distribuído para um ambiente inteligente**, nesse caso uma estufa inteligente. O projeto faz uso de tecnologias modernas como **gRPC, RabbitMQ** para gerenciar sensores e atuadores de maneira eficiente. 🌍💡

## 📌 Funcionalidade do Projeto
O **Smart Gateway** atua como um **intermediário** entre **sensores** e **atuadores**, garantindo a comunicação assíncrona e eficiente entre os dispositivos. Ele funciona da seguinte forma:

1️⃣ **Sensores** publicam dados em **RabbitMQ** (exemplo: temperatura, luminosidade).  
2️⃣ O **Gateway** recebe essas mensagens e processa os dados.  
3️⃣ O usuário pode visualizar os dados via **API REST**.  
4️⃣ O usuário pode enviar comandos para **atuadores** (exemplo: ligar/desligar lâmpadas) via **API REST**.

---

## 🛠️ Tecnologias Utilizadas
Este projeto utiliza diversas tecnologias modernas para garantir um funcionamento eficiente:

- **🖥️ Java 17**
- **🌱 Spring Boot 3.4.2** 
- **💬 gRPC** 
- **📩 RabbitMQ** 
- **🛠️ Protobuf**
- **💿 H2 Database**
---

## ⚙️ Configuração de Ambiente

### 🖥️ **Pré-requisitos**
Antes de rodar o projeto, certifique-se de ter instalado:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/)
- [Intellij IDEA](https://www.jetbrains.com/idea/) ou IDE de sua preferência
- [RabbitMQ](https://www.rabbitmq.com/docs/download)
- [Protobuf](https://protobuf.dev/downloads)

## ▶️ Executando o Projeto

1. Clone o repositório:

```sh
git clone https://github.com/ferreira-eric/smart-gateway.git
cd smart-gateway
```

2. Instale as dependências e execute o projeto:

```sh
mvn spring-boot:run
```

3. O servidor será iniciado em `http://localhost:8080`

---
## 📐 Arquitetura do Projeto
O **Smart Gateway** atua como um **intermediário** entre os **sensores** e **atuadores** e o cliente, como está descrito no diagrama abaixo:

![Distribuidos arquitetura-C8 Architecture (3)](https://github.com/user-attachments/assets/37df8cfb-dbdb-4786-8a93-4cbf3fd4d0d9)

---
## 🧮 Cliente, Sensores e Atuadores
Para poder acessar todas as funcionalidades do projeto, simulando os demais componentes deve-ser seguir os passos descrito em:

https://github.com/pauloricms12/smart_greenhouse_2

## 📜 Licença

MIT, Apache 2.0
