import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta();

        // Pedir o nome do usuário
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        conta.setNome(nome); // Armazenar o nome na instância de Conta

        System.out.println("Alo " + conta.getNome()); // Exibir o nome usando a instância de Conta

        int opcao;

        do {
            // Exibir o menu de opções
            System.out.println("\n \n \n bem vindo a Bullacredi");
            System.out.println("Seu saldo é : " + conta.getSaldo());
            System.out.println("Seu investimento  é : " + conta.getInvestido());
            System.out.println("1. Depositar");
            System.out.println("2. Resgatar");
            System.out.println("3. Investimento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            // Ler a opção escolhida pelo usuário
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    BigDecimal valorDeposito = scanner.nextBigDecimal();
                    conta.deposito(valorDeposito); // Realizar o depósito
                    System.out.println("Depósito realizado com sucesso! Seu saldo é: " + conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do resgate: ");
                    BigDecimal valorResgate = scanner.nextBigDecimal();
                    BigDecimal valorRetirado = conta.retirar(valorResgate); // Realizar o resgate
                    if (valorRetirado.compareTo(BigDecimal.ZERO) > 0) {
                        System.out.println("Resgate realizado com sucesso! Valor retirado: " + valorRetirado);
                    } else {
                        System.out.println("Saldo insuficiente para o resgate ou valor inválido.");
                    }
                    System.out.println("Seu saldo atual é: " + conta.getSaldo());
                    break;
                case 3:
                    System.out.print("Digite o valor do investimento: ");
                    BigDecimal valorInvestimento = scanner.nextBigDecimal();
                    conta.investir(valorInvestimento); // Realizar o investimento
                    System.out.println("Investimento realizado com sucesso! Seu saldo é: " + conta.getSaldo());
                    break;
                case 4:
                    System.out.println("Obrigado por usar nosso sistema, " + conta.getNome() + "!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }

            // Aumentar o valor investido em 5% a cada iteração
            BigDecimal aumentoInvestimento = conta.getInvestido().multiply(new BigDecimal("0.05"));
            conta.setInvestido(conta.getInvestido().add(aumentoInvestimento));

        } while (opcao != 4);

        scanner.close();
    }
}
