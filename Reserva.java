public abstract class Reserva {
    protected int codigo;
    protected String cliente;
    protected double valor;

    public Reserva(int codigo, String cliente) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio.");
        }
        this.codigo = codigo;
        this.cliente = cliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public double getValor() {
        return valor;
    }

    public abstract void calcularValor();
    public abstract void validar();

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", cliente='" + cliente + '\'' +
                ", valor=" + valor +
                '}';
    }
}
