package ru.netology;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Player name) {
        super("Игрок " + name + " не найден");
    }
}
