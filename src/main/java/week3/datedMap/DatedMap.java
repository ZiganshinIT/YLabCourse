package main.java.week3.datedMap;

import java.util.Date;
import java.util.Set;

public interface DatedMap {
    /**
     * Добавляет пору ключ-значение
     * @param key ключ
     * @param value значение
     */
    void put(String key, String value);

    /**
     * Получение значения по ключу
     * @param key ключ
     * @return значение по ключу
     */
    String get(String key);

    /**
     * Проверка на содержание ключа
     * @param key ключ
     * @return true/false
     */
    boolean containsKey(String key);

    /**
     * Удаление пары по ключу
     * @param key ключ
     */
    void remove(String key);

    /**
     * Множество ключей
     * @return множество ключей
     */
    Set<String> keySet();

    /**
     * Возвращает дату добавление элмента
     * @param key ключ
     * @return дату добавления
     */
    Date getKeyLastInsertionDate(String key);
}
