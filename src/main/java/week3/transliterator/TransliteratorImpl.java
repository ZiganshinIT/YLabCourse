package week3.transliterator;

import java.util.HashMap;
import java.util.Map;

public class TransliteratorImpl implements Transliterator {
    private static final Map <Character, String> transliteratTable = new HashMap<>();

    private static final Character[] cyrillicCharacters = new Character[]{
            'А', 'Б', 'В', 'Г', 'Д', 'Е',
            'Ё', 'Ж', 'З', 'И', 'Й', 'К',
            'Л', 'М', 'Н', 'О', 'П', 'Р',
            'С', 'Т', 'У', 'Ф', 'Х', 'Ц',
            'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Ъ',
            'Э', 'Ю', 'Я'
    };
    private static final String[] latinCharacters = {
            "A", "B", "V", "G", "D", "E",
            "E", "ZH", "Z", "I", "I", "K",
            "L", "M", "N", "O", "P", "R",
            "S", "T", "U", "F", "KH", "TS",
            "CH", "SH", "SHCH", "Y", "", "IE",
            "E", "IU", "IA"
    };

    static {
        for (int i = 0; i < cyrillicCharacters.length; i++) {
            transliteratTable.put(cyrillicCharacters[i], latinCharacters[i]);
        }
    }

    @Override
    public String transliterate(String source) {
        StringBuilder result = new StringBuilder();
        for (char ch : source.toCharArray()) {
            if (transliteratTable.containsKey(ch)) {
                result.append(transliteratTable.get(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
