package com.company.task04.parse.impl;

import com.company.task04.composite.TextComponent;
import com.company.task04.composite.TextComponentType;
import com.company.task04.composite.impl.TextComposite;
import com.company.task04.parse.BaseParser;

public class SentenceParser implements BaseParser {
    private static final SentenceParser INSTANCE = new SentenceParser();
    private final LexemeParser lexemeParser = LexemeParser.getInstance();
    private static final String SENTENCE_DELIMITER = "\\s+";

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String sentence) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] lexemes = sentence.split(SENTENCE_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = lexemeParser.parse(lexeme);
            sentenceComponent.add(lexemeComponent);
        }
        return sentenceComponent;
    }
}
