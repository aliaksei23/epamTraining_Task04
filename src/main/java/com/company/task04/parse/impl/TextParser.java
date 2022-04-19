package com.company.task04.parse.impl;

import com.company.task04.composite.TextComponent;
import com.company.task04.composite.TextComponentType;
import com.company.task04.composite.impl.TextComposite;
import com.company.task04.parse.BaseParser;

public class TextParser implements BaseParser {
    private static final TextParser INSTANCE = new TextParser();
    private final ParagraphParser paragraphParser = ParagraphParser.getInstance();
    private static final String TEXT_DELIMITER = "\n\\s*";

    private TextParser() {
    }

    public static TextParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = text.split(TEXT_DELIMITER);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
