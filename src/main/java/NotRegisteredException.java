public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String playerName) {
        super("Пользователь " + playerName + " " + "не зарегистрирован");
    }
}
