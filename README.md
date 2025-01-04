# Sudovrum - Sistema de Aluguel de Veículos

## Visão Geral
Sudovrum é um sistema simples e interativo de gerenciamento de aluguel de veículos. Ele permite que usuários registrem veículos, aluguéis e cupons de desconto, fornecendo uma experiência completa para administração de uma frota de veículos.

## Funcionalidades
- **Gerenciamento de Veículos:**
  - Adicionar veículos de diferentes tipos: carros, motos e caminhões.
  - Listar todos os veículos cadastrados.

- **Sistema de Aluguel:**
  - Registrar novos aluguéis.
  - Calcular o custo do aluguel com ou sem aplicação de cupons de desconto.
  - Listar todos os aluguéis registrados.

- **Gerenciamento de Cupons:**
  - Gerar cupons de desconto com percentual de 0% a 100%.
  - Listar cupons disponíveis.
  - Validar cupons durante o processo de registro de aluguel.

## Requisitos

- **Java 17 ou superior**
- IDE para Java (IntelliJ IDEA, Eclipse, NetBeans, etc.)
- JDK instalado e configurado

## Estrutura do Projeto

O projeto é estruturado da seguinte maneira:

```plaintext
src/
  |-- com.mycompany.sudovrum
  |    |-- Sudovrum.java   // Classe principal contendo o sistema interativo
  |
  |-- model
  |    |-- Veiculo.java    // Classe abstrata para veículos
  |    |-- Carro.java      // Implementação específica para carros
  |    |-- Moto.java       // Implementação específica para motos
  |    |-- Caminhao.java   // Implementação específica para caminhões
  |    |-- Cliente.java    // Modelo de cliente
  |
  |-- service
  |    |-- gerenciador
  |         |-- GerenciadorVeiculos.java  // Gerencia a frota de veículos
  |         |-- GerenciadorAlugueis.java  // Gerencia os aluguéis
  |         |-- GerenciadorCupons.java    // Gerencia os cupons
```

## Como Usar

### 1. Clone o Repositório
```bash
git clone https://github.com/SudoMaster7/GerenciadorVeiculos.git
cd GerenciadorVeiculos
```

### 2. Compile e Execute o Projeto

Usando o terminal, compile e execute o projeto:
```bash
javac -d bin src/**/*.java
java -cp bin com.mycompany.sudovrum.Sudovrum
```

Ou execute diretamente pela sua IDE favorita.

### 3. Explore as Funcionalidades
Navegue pelo menu interativo:
- Listar veículos.
- Registrar um aluguel.
- Gerar e aplicar cupons.
- Listar aluguéis registrados.

## Exemplo de Execução

```plaintext
=== Sistema de Aluguel de Veículos ===
1. Listar Veículos
2. Registrar Aluguel
3. Listar Aluguéis
4. Gerar Cupom
5. Listar Cupons
0. Sair
Escolha uma opção:
```

## Contribuições

Contribuições são bem-vindas! Siga os passos abaixo:
1. Faça um fork do repositório.
2. Crie uma branch para sua funcionalidade ou correção:
   ```bash
   git checkout -b minha-nova-funcionalidade
   ```
3. Envie suas alterações:
   ```bash
   git push origin minha-nova-funcionalidade
   ```
4. Abra um Pull Request.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).

---

Esperamos que o Sudovrum ajude a simplificar o gerenciamento de aluguel de veículos!

