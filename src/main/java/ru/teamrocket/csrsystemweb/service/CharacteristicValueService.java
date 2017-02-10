package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.CharacteristicValue;
import javax.ws.rs.core.Response;

/**
 * Created by Kate on 04.02.2017.
 */

public interface CharacteristicValueService {
    CharacteristicValue getCharacteristicById(int id);
    Response getCharacteristicValues();
    Response insertCharacteristicValue(CharacteristicValue characteristicValue);
    Response deleteCharacteristicValue(int id);
    Response updateCharacteristicValue(CharacteristicValue characteristicValue);
}
