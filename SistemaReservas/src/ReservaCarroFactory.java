public class ReservaCarroFactory extends ReservaFactory {
    @Override
    public Reserva criarReserva(int codigo, String cliente, Object... dados) {
        return new ReservaCarro(codigo, cliente, (int) dados[0], (double) dados[1]);
    }
}
