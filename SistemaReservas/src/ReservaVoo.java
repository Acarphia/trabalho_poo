public class ReservaVoo extends Reserva {
    private String classeAssento; // econômica, executiva, primeira
    private double precoBase;

    public ReservaVoo(int codigo, String cliente, String classeAssento, double precoBase) {
        super(codigo, cliente);
        this.classeAssento = classeAssento;
        this.precoBase = precoBase;
        validar();
        calcularValor();
    }

    @Override
    public void calcularValor() {
        switch (classeAssento.toLowerCase()) {
            case "executiva" -> this.valor = precoBase * 1.5;
            case "primeira" -> this.valor = precoBase * 2.0;
            default -> this.valor = precoBase;
        }
    }

    @Override
    public void validar() {
        if (precoBase <= 0) throw new IllegalArgumentException("Preço da passagem deve ser positivo.");
    }
}
