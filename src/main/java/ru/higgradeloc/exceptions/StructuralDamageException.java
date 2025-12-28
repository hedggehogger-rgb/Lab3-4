package ru.higgradeloc.exceptions;

public class StructuralDamageException extends Exception {

    public StructuralDamageException(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return "КРИТИЧЕСКОЕ ПОВРЕЖДЕНИЕ КОНСТРУКЦИИ: " + super.getMessage();
    }
}