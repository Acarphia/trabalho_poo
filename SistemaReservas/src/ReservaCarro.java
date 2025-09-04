public class ReservaCarro extends Reserva {
    private int dias;
    private double precoPorDia;

    public ReservaCarro(int codigo, String cliente, int dias, double precoPorDia) {
        super(codigo, cliente);
        this.dias = dias;
        this.precoPorDia = precoPorDia;
        validar();
        calcularValor();
    }

    @Override
    public void calcularValor() {
        this.valor = dias * precoPorDia;
    }

    @Override
    public void validar() {
        if (dias <= 0) throw new IllegalArgumentException("Quantidade de dias deve ser positiva.");
        if (precoPorDia <= 0) throw new IllegalArgumentException("Preço por dia deve ser positivo.");
    }
}
