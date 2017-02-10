package ru.teamrocket.csrsystemweb.dao;

import ru.teamrocket.csrsystemweb.model.CharacteristicValue;
import java.util.List;

/**
 * Created by Kate on 04.02.2017.
 */

public interface CharacteristicValueDAO {
    CharacteristicValue getCharacteristicValueById(int id);
    List<CharacteristicValue> getCharacteristicValues();
    void createCharacteristicValue(CharacteristicValue characteristicValue);
    void deleteCharacteristicValue(int id);
    void updateCharacteristicValue(CharacteristicValue characteristicValue);
}
