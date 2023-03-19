package main.java.week3.transliterator;

public interface Transliterator {
    /**
     * Транслитерирует прописные символы кириллицы на соответствующую группу символов латиницы.
     * @param source Строка, которую необходимо транслитерировать.
     * @return Транслитерованная строка.
     */
    String transliterate(String source);
}
