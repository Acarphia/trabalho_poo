public class ReservaHotelFactory extends ReservaFactory {
    @Override
    public Reserva criarReserva(int codigo, String cliente, Object... dados) {
        return new ReservaHotel(codigo, cliente, (int) dados[0], (double) dados[1]);
    }
}
