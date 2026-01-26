# Desafio técnico Java do Itau

Um teste técnico pedido em vaga real do Itau.

## 📋 Descrição

Aplicação Spring Boot que gerencia transações financeiras e fornece estatísticas sobre elas. A aplicação permite adicionar transações, consultar estatísticas e deletar todas as transações.

## 🔧 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 17** ou superior
- **Maven 3.6+** ou use o Maven Wrapper incluído no projeto (`mvnw` ou `mvnw.cmd`)
- **Git** (opcional, para clonar o repositório)

### Verificando as instalações

```bash
java -version
mvn -version
```

## 🏗️ Como Buildar

### Usando Maven Wrapper (Recomendado)

O projeto inclui um Maven Wrapper, então você não precisa ter o Maven instalado globalmente.

**No Linux/macOS:**
```bash
./mvnw clean install
```

**No Windows:**
```bash
mvnw.cmd clean install
```

### Usando Maven instalado

Se você tem o Maven instalado globalmente:

```bash
mvn clean install
```

Este comando irá:
- Limpar o diretório `target/`
- Compilar o código fonte
- Executar os testes
- Gerar o arquivo JAR em `target/itauJava10x-0.0.1-SNAPSHOT.jar`

### Build sem executar testes

Se quiser apenas compilar sem executar os testes:

```bash
./mvnw clean install -DskipTests
```

## 🚀 Como Rodar

### Opção 1: Usando Maven (Recomendado para desenvolvimento)

**No Linux/macOS:**
```bash
./mvnw spring-boot:run
```

**No Windows:**
```bash
mvnw.cmd spring-boot:run
```

### Opção 2: Usando o JAR gerado

Após fazer o build, você pode executar o JAR diretamente:

```bash
java -jar target/itauJava10x-0.0.1-SNAPSHOT.jar
```

### Opção 3: Executando a classe principal

```bash
./mvnw exec:java -Dexec.mainClass="dev.java10x.itauJava10x.ItauJava10xApplication"
```

### Verificando se a aplicação está rodando

A aplicação estará disponível em:
- **URL Base:** `http://localhost:8080`

Você pode verificar se está funcionando acessando:
- `http://localhost:8080/estatistica` (deve retornar estatísticas vazias inicialmente)

## 🧪 Como Testar

### Executando todos os testes

**No Linux/macOS:**
```bash
./mvnw test
```

**No Windows:**
```bash
mvnw.cmd test
```

### Executando testes com Maven instalado

```bash
mvn test
```

### Executando um teste específico

```bash
./mvnw test -Dtest=ItauJava10xApplicationTests
```

### Visualizando relatórios de teste

Após executar os testes, os relatórios estarão disponíveis em:
- `target/surefire-reports/` - Relatórios em formato XML e TXT

## 📡 Endpoints da API

### Transações

#### POST `/transacao`
Adiciona uma nova transação.

**Exemplo de requisição:**
```bash
curl -X POST http://localhost:8080/transacao \
  -H "Content-Type: application/json" \
  -d '{
    "valor": 100.50,
    "dataHora": "2024-01-15T10:30:00Z"
  }'
```

**Respostas:**
- `201 Created` - Transação criada com sucesso
- `422 Unprocessable Entity` - Erro de validação
- `400 Bad Request` - Erro na requisição

#### DELETE `/transacao`
Deleta todas as transações armazenadas.

**Exemplo de requisição:**
```bash
curl -X DELETE http://localhost:8080/transacao
```

**Resposta:**
- `200 OK` - Transações deletadas com sucesso

### Estatísticas

#### GET `/estatistica`
Retorna estatísticas das transações dos últimos 60 segundos (configurável em `application.yml`).

**Exemplo de requisição:**
```bash
curl http://localhost:8080/estatistica
```

**Resposta:**
```json
{
  "soma": 100.50,
  "min": 100.50,
  "max": 100.50,
  "media": 100.50,
  "quantidade": 1
}
```

## ⚙️ Configuração

As configurações da aplicação estão em `src/main/resources/application.yml`:

```yaml
estatistica:
  segundos: 60
```

Este valor define quantos segundos no passado serão considerados para o cálculo das estatísticas.

## 🛠️ Tecnologias Utilizadas

- **Spring Boot 4.0.1** - Framework principal
- **Java 17** - Linguagem de programação
- **Maven** - Gerenciador de dependências
- **Lombok** - Redução de boilerplate
- **JUnit 5** - Framework de testes

## 📁 Estrutura do Projeto

```
itauJava10x/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/java10x/itauJava10x/
│   │   │       ├── Estatisticas/      # Controllers e DTOs de estatísticas
│   │   │       ├── Transacoes/        # Controllers, Services e Repository de transações
│   │   │       └── ItauJava10xApplication.java
│   │   └── resources/
│   │       └── application.yml        # Configurações da aplicação
│   └── test/
│       └── java/                      # Testes unitários
├── pom.xml                            # Configuração Maven
└── README.md                          # Este arquivo
```

## 🐛 Solução de Problemas

### Erro: "Java version not found"
Certifique-se de ter o Java 17 instalado e configurado no PATH.

### Erro: "Port 8080 already in use"
A porta 8080 já está em uso. Você pode:
- Parar a aplicação que está usando a porta
- Ou alterar a porta em `application.yml` adicionando:
  ```yaml
  server:
    port: 8081
  ```

### Erro ao executar `./mvnw`
Certifique-se de que o arquivo `mvnw` tem permissão de execução:
```bash
chmod +x mvnw
```

## 📝 Notas

- A aplicação armazena transações em memória (não persiste em banco de dados)
- As estatísticas são calculadas considerando apenas transações dos últimos N segundos (configurável)
- Ao reiniciar a aplicação, todas as transações são perdidas

## 📄 Licença

Este projeto é um teste técnico.
