public class ReservaPacote extends Reserva {
    private double valorTotalServicos;

    public ReservaPacote(int codigo, String cliente, double valorTotalServicos) {
        super(codigo, cliente);
        this.valorTotalServicos = valorTotalServicos;
        validar();
        calcularValor();
    }

    @Override
    public void calcularValor() {
        this.valor = valorTotalServicos * 0.9; // 10% de desconto em pacotes
    }

    @Override
    public void validar() {
        if (valorTotalServicos <= 0) throw new IllegalArgumentException("Valor dos serviços deve ser positivo.");
    }
}
