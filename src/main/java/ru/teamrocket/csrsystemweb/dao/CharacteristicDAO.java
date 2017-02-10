package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.Characteristic;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */
public interface CharacteristicDAO {
    Characteristic getCharacteristicById(int id);
    List<Characteristic> getCharacteristics();
    void createCharacteristic(Characteristic characteristic);
    void deleteCharacteristic(int id);
    void updateCharacteristic(Characteristic characteristic);
}
