package pl.library.app;

import pl.library.exception.NoSuchOptionException;

public enum Option {

    EXIT(0," - wyjście"),
    ADD_BOOK(1," - dodaj nową ksążke"),
    SHOW_BOOK(2," - wyświetl książki"),
    ADD_MAGAZINE(3," - dodaj nowy magazyn"),
    SHOW_MAGAZINE(4," - wyświetl magazyn");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + description;
    }

    static Option createFromInt(int option) throws NoSuchOptionException {
    try {
        return Option.values()[option];
    } catch (ArrayIndexOutOfBoundsException e) {
    throw new NoSuchOptionException("Brak opcji o ID " + option);
    }
    }
}
