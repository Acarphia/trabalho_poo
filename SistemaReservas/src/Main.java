import java.util.*;

public class Main {
    //Ana Clara Fagundes Curcino - 12321BSI279; Luiza Vieira Pavarina - 12411GIN047; Marcos Paulo Alves - 12311GIN022

    private static Map<Integer, Reserva> reservas = new HashMap<>();
    private static int contadorCodigo = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> criarReserva();
                    case 2 -> listarReservas();
                    case 3 -> listarPorTipo();
                    case 4 -> exibirValor();
                    case 5 -> cancelarReserva();
                    case 0 -> System.out.println("\n Saindo do sistema... até logo!");
                    default -> System.out.println("\n Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("\n Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n======================================");
        System.out.println("        SISTEMA DE RESERVAS DE VIAGEM ");
        System.out.println("======================================");
        System.out.println("1 - Criar nova reserva");
        System.out.println("2 - Listar todas as reservas");
        System.out.println("3 - Listar reservas por tipo");
        System.out.println("4 - Exibir valor total de uma reserva");
        System.out.println("5 - Cancelar uma reserva");
        System.out.println("0 - Sair");
        System.out.println("======================================");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarReserva() {
        System.out.println("\n--- Criar nova reserva ---");
        System.out.println("Tipo de reserva (1=Voo, 2=Hotel, 3=Carro, 4=Pacote): ");
        int tipo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do cliente: ");
        String cliente = sc.nextLine();

        ReservaFactory factory = null;
        Reserva reserva = null;

        switch (tipo) {
            case 1 -> {
                System.out.print("Classe do assento (econômica, executiva, primeira): ");
                String classe = sc.nextLine();
                System.out.print("Preço base: ");
                double preco = sc.nextDouble();
                factory = new ReservaVooFactory();
                reserva = factory.criarReserva(contadorCodigo++, cliente, classe, preco);
            }
            case 2 -> {
                System.out.print("Quantidade de dias: ");
                int dias = sc.nextInt();
                System.out.print("Preço da diária: ");
                double preco = sc.nextDouble();
                factory = new ReservaHotelFactory();
                reserva = factory.criarReserva(contadorCodigo++, cliente, dias, preco);
            }
            case 3 -> {
                System.out.print("Quantidade de dias: ");
                int dias = sc.nextInt();
                System.out.print("Preço por dia: ");
                double preco = sc.nextDouble();
                factory = new ReservaCarroFactory();
                reserva = factory.criarReserva(contadorCodigo++, cliente, dias, preco);
            }
            case 4 -> {
                System.out.print("Valor total dos serviços: ");
                double valorServicos = sc.nextDouble();
                factory = new ReservaPacoteFactory();
                reserva = factory.criarReserva(contadorCodigo++, cliente, valorServicos);
            }
            default -> System.out.println("\n Tipo inválido.");
        }

        if (reserva != null) {
            reservas.put(reserva.getCodigo(), reserva);
            System.out.println("\n--------------------------------------");
            System.out.println(" Reserva criada com sucesso!");
            System.out.println(reserva);
            System.out.println("--------------------------------------");
        }
    }

    private static void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("\n Nenhuma reserva cadastrada.");
        } else {
            System.out.println("\n===== LISTA DE RESERVAS =====");
            reservas.values().forEach(r -> {
                System.out.println(r);
                System.out.println("-----------------------------");
            });
        }
    }

    private static void listarPorTipo() {
        System.out.print("\nDigite o tipo (Voo, Hotel, Carro, Pacote): ");
        String tipo = sc.nextLine().toLowerCase();

        System.out.println("\n===== RESERVAS DO TIPO: " + tipo.toUpperCase() + " =====");
        reservas.values().stream()
                .filter(r -> r.getClass().getSimpleName().toLowerCase().contains(tipo))
                .forEach(r -> {
                    System.out.println(r);
                    System.out.println("-----------------------------");
                });
    }

    private static void exibirValor() {
        System.out.print("\nDigite o código da reserva: ");
        int codigo = sc.nextInt();
        Reserva r = reservas.get(codigo);
        if (r != null) {
            System.out.println("\n Valor total da reserva " + codigo + ": R$ " + r.getValor());
        } else {
            System.out.println("\n Reserva não encontrada.");
        }
    }

    private static void cancelarReserva() {
        System.out.print("\nDigite o código da reserva: ");
        int codigo = sc.nextInt();
        if (reservas.remove(codigo) != null) {
            System.out.println("\n Reserva cancelada com sucesso!");
        } else {
            System.out.println("\n Reserva não encontrada.");
        }
    }
}
