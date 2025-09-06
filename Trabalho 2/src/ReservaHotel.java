public class ReservaHotel extends Reserva {
    private int dias;
    private double precoDiaria;

    public ReservaHotel(int codigo, String cliente, int dias, double precoDiaria) {
        super(codigo, cliente);
        this.dias = dias;
        this.precoDiaria = precoDiaria;
        validar();
        calcularValor();
    }

    @Override
    public void calcularValor() {
        this.valor = dias * precoDiaria;
    }

    @Override
    public void validar() {
        if (dias <= 0) throw new IllegalArgumentException("Quantidade de dias deve ser positiva.");
        if (precoDiaria <= 0) throw new IllegalArgumentException("Preço da diária deve ser positivo.");
    }
}
