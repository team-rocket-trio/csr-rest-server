package ru.teamrocket.csrsystemweb.service;

import ru.teamrocket.csrsystemweb.model.Characteristic;
import javax.ws.rs.core.Response;

/**
 * Created by Kate on 04.02.2017.
 */

public interface CharacteristicService {
    Characteristic getCharacteristicById(int id);
    Response getCharacteristics();
    Response insertCharacteristic(Characteristic characteristic);
    Response deleteCharacteristic(int id);
    Response updateCharacteristic(Characteristic characteristic);
}
