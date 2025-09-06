public class ReservaVooFactory extends ReservaFactory {
    @Override
    public Reserva criarReserva(int codigo, String cliente, Object... dados) {
        return new ReservaVoo(codigo, cliente, (String) dados[0], (double) dados[1]);
    }
}
