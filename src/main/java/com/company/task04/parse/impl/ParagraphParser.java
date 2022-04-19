package com.company.task04.parse.impl;

import com.company.task04.composite.TextComponent;
import com.company.task04.composite.TextComponentType;
import com.company.task04.composite.impl.TextComposite;
import com.company.task04.parse.BaseParser;

public class ParagraphParser implements BaseParser {
    private static final ParagraphParser INSTANCE = new ParagraphParser();
    private final SentenceParser sentenceParser = SentenceParser.getInstance();
    private static final String PARAGRAPH_DELIMITER =
            "(?<=\\.)\\s|(?<=\\?)\\s|(?<=!)\\s|(?<=\\.{3})\\s+";

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return INSTANCE;
    }

    @Override
    public TextComponent parse(String paragraph) {
        TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
        String[] sentences = paragraph.split(PARAGRAPH_DELIMITER);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = sentenceParser.parse(sentence);
            paragraphComponent.add(sentenceComponent);
        }
        return paragraphComponent;
    }
}
