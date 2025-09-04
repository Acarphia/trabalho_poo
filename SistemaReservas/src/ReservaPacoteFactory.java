public class ReservaPacoteFactory extends ReservaFactory {
    @Override
    public Reserva criarReserva(int codigo, String cliente, Object... dados) {
        return new ReservaPacote(codigo, cliente, (double) dados[0]);
    }
}
