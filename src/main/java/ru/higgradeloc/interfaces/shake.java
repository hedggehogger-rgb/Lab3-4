package ru.higgradeloc.interfaces;

import ru.higgradeloc.enums.intensity;
import ru.higgradeloc.exceptions.StructuralDamageException;

public interface shake {
    void beShaken(intensity level) throws StructuralDamageException;
}