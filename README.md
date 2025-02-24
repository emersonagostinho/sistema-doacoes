---

# **Sistema de Doações Solidárias (Arquitetura de Microserviços) 🏗️**  
Plataforma completa para conectar doadores a campanhas sociais, permitindo a criação, gestão e acompanhamento de doações, com foco em simplicidade, transparência e escalabilidade.  

## **Índice 📚**  
- 📌 [Objetivo](#objetivo)  
- 🛠️ [Funcionalidades](#funcionalidades)  
- 🏗️ [Arquitetura](#arquitetura)  
- 🚀 [Tecnologias Utilizadas](#tecnologias-utilizadas)  
- 📂 [Estrutura do Projeto](#estrutura-do-projeto)  
- 🛢️ [Modelagem das Entidades](#modelagem-das-entidades)  
- 🔀 [Fluxo de Requisições](#fluxo-de-requisições)  
- 🌐 [Rotas da API](#rotas-da-api)  
- ✅ [Validações e Regras de Negócio](#validações-e-regras-de-negócio)  
- 🔒 [Segurança](#segurança)  
- 🧪 [Testes](#testes)  
- 📈 [Monitoramento e Logs](#monitoramento-e-logs)  
- 💻 [Interface Web (Sugestão)](#interface-web-sugestão)  
- 🏁 [Como Executar o Projeto](#como-executar-o-projeto)  
- 🛠️ [Próximos Passos](#próximos-passos)  
- 👤 [Autor](#autor)  

---

## **Objetivo 🎯**  
Criar uma aplicação web robusta e escalável para facilitar a arrecadação de doações, promovendo a conexão entre doadores e campanhas sociais, com uma API REST bem estruturada e fácil de integrar com interfaces web e mobile.  

---

## **Funcionalidades 🛠️**  
- 👥 **Cadastro de Usuários:** Registro, atualização e exclusão de usuários.  
- 📣 **Gestão de Campanhas:** Criação, edição, listagem e encerramento de campanhas.  
- 💰 **Doações:** Registro e rastreamento de doações.  
- 📊 **Relatórios:** Geração de relatórios de doações por campanha ou usuário.  
- 📩 **Notificações (Futuro):** Envio de e-mails ou WhatsApp para confirmar doações ou alertar sobre campanhas encerradas.  
- 🔑 **Autenticação:** Login e controle de acesso com JWT.  

---

## **Arquitetura 🏗️**  
- 🧩 **Microserviços:** Spring Boot (separados por domínio)  
  - 👤 **User Service:** Cadastro e gestão de usuários.  
  - 🎯 **Campaign Service:** Criação e gestão de campanhas.  
  - 💸 **Donation Service:** Registro e monitoramento de doações.  
  - 🔑 **Auth Service:** Autenticação e autorização com JWT.  
  - 🔔 **Notification Service (Futuro):** Gerenciamento de notificações.  
- 🔀 **API Gateway:** Spring Cloud Gateway para roteamento de requisições.  
- 🔎 **Service Discovery:** Eureka Server para registro de serviços.  
- ⚙️ **Config Server:** Centralização de configurações com Spring Cloud Config.  
- 📩 **Mensageria:** RabbitMQ para comunicação assíncrona entre serviços.  
- 🛢️ **Banco de Dados:** PostgreSQL (cada serviço com sua base isolada).  
- 🔐 **Segurança:** Spring Security com JWT e roles de acesso.  
- 📑 **Documentação da API:** Swagger/OpenAPI.  
- 📊 **Monitoramento:** Actuator + Prometheus + Grafana.  

---

## **Tecnologias Utilizadas 🚀**  
- **Backend:** Java, Spring Boot, Spring Cloud  
- **Banco de Dados:** PostgreSQL  
- **Mensageria:** RabbitMQ  
- **Monitoramento:** Prometheus, Grafana, ELK Stack  
- **Segurança:** JWT, Spring Security  
- **Ferramentas de Build:** Maven  
- **Versionamento:** Git, GitHub  
- **Containerização:** Docker, Docker Compose  

---

## **Estrutura do Projeto 📂**  
```
.
├── api-gateway/                     # API Gateway (roteamento)
├── discovery-server/                # Eureka Service Discovery
├── config-server/                   # Servidor de configuração
├── user-service/                    # Microserviço de usuários
├── campaign-service/                # Microserviço de campanhas
├── donation-service/                # Microserviço de doações
├── auth-service/                    # Microserviço de autenticação
└── notification-service/            # Microserviço de notificações (futuro)
```

---

## **Modelagem das Entidades 🛢️**  
- 👤 **Usuário:** id, nome, email, senha, tipo (doador ou organização)  
- 🎯 **Campanha:** id, título, descrição, meta de arrecadação, data de término  
- 💸 **Doação:** id, valor, data, usuárioId, campanhaId  

---

## **Fluxo de Requisições 🔀**  
1. 👤 **Usuário faz login:** Envia credenciais → API Gateway → Auth Service → JWT  
2. 📝 **Criar campanha:** JWT enviado → API Gateway → Campaign Service → PostgreSQL 
3. 💸 **Fazer doação:** JWT + dados → API Gateway → Donation Service → PostgreSQL 

---

## **Rotas da API 🌐**  
- **User Service:**  
  - ➕ `POST /users` → criar usuário  
  - 🔍 `GET /users/{id}` → buscar usuário  

- **Campaign Service:**  
  - ➕ `POST /campaigns` → criar campanha  
  - 🔍 `GET /campaigns/{id}` → buscar campanha  

- **Donation Service:**  
  - ➕ `POST /donations` → registrar doação  
  - 🔍 `GET /donations/{id}` → buscar doação  

---

## **Segurança 🔒**  
- **Autenticação:** 🔑 JWT para tokens  
- **Autorização:** 🔐 Roles e permissões com Spring Security  
- **Rate Limiting:** 🛡️ Proteção contra ataques de força bruta  

---

## **Testes 🧪**  
- **Testes Unitários:** JUnit e Mockito  
- **Testes de Integração:** Testcontainers  
- **Testes de Carga:** k6  

---

## **Monitoramento e Logs 📈**  
- 🩺 **Actuator:** Métricas e saúde dos serviços  
- 📊 **Prometheus & Grafana:** Coleta e visualização de métricas  
- 📝 **ELK Stack:** Centralização e análise de logs  

---

## **Como Executar o Projeto 🏁**  
1. **Clonar o repositório:**  
```bash
git clone https://github.com/emersonagostinho/sistema-doacoes.git
cd sistema-doacoes
```

2. **Subir os containers:**  
```bash
docker-compose up
```

3. **Acessar a API:**  
- 🔀 API Gateway: `http://localhost:8080`  
- 🔎 Eureka Server: `http://localhost:8761`  
- 📑 Swagger: `http://localhost:8080/swagger-ui.html`  

---

## **Próximos Passos 🛠️**  
- ⚡ Implementar resiliência com Circuit Breaker (Resilience4J)  
- 🚀 Adicionar cache com Redis para melhorar a performance  
- 📝 Implementar logging distribuído com ELK Stack  
- 📊 Criar dashboards de monitoramento com Grafana  

---

## **Autor 👤**  
**Emerson José**  
- 🐙 **GitHub:** emersonagostinho(#)
- 📩 **Email:** emersonagostinhoj@gmail.com  

---
#
