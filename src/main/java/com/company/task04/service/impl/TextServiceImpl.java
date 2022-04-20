package com.company.task04.service.impl;

import com.company.task04.comparator.*;
import com.company.task04.composite.TextComponent;
import com.company.task04.composite.TextComponentType;
import com.company.task04.composite.impl.TextComposite;
import com.company.task04.exception.IncorrectDataException;
import com.company.task04.service.TextService;

import java.util.ArrayList;
import java.util.List;

public class TextServiceImpl implements TextService {
    @Override
    public TextComponent sortParagraphsByAmountOfSentences(TextComponent text) throws IncorrectDataException {
        if (!text.getTextComponentType().equals(TextComponentType.TEXT)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedText = new TextComposite(TextComponentType.TEXT);
        List<TextComponent> paragraphs = new ArrayList<>(text.getTextComponents());
        paragraphs.sort(new ParagraphSentenceAmountComparator());
        for (TextComponent paragraph : paragraphs) {
            sortedText.add(paragraph);
        }
        return sortedText;
    }

    @Override
    public TextComponent sortSentencesByMaxWordLength(TextComponent paragraph) throws IncorrectDataException {
        if (!paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
        sentences.sort(new SentenceMaxWordLengthComparator());
        for (TextComponent sentence : sentences) {
            sortedParagraph.add(sentence);
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortSentencesByMaxLexemeLength(TextComponent paragraph) throws IncorrectDataException {
        if (!paragraph.getTextComponentType().equals(TextComponentType.PARAGRAPH)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.PARAGRAPH);
        List<TextComponent> sentences = new ArrayList<>(paragraph.getTextComponents());
        sentences.sort(new SentenceMaxLexemeLengthComparator());
        for (TextComponent sentence : sentences) {
            sortedParagraph.add(sentence);
        }
        return sortedParagraph;
    }

    @Override
    public TextComponent sortLexemesByEntryOfSymbol(TextComponent sentence, char symbol) throws IncorrectDataException {
        if (!sentence.getTextComponentType().equals(TextComponentType.SENTENCE)) {
            throw new IncorrectDataException("Incorrect text component type");
        }
        TextComponent sortedParagraph = new TextComposite(TextComponentType.SENTENCE);
        List<TextComponent> lexemes = new ArrayList<>(sentence.getTextComponents());
        lexemes.sort(new LexemeSymbolEntranceComparator(symbol).reversed().thenComparing(new LexemeAlphabetComparator()));
        for (TextComponent lexeme : lexemes) {
            sortedParagraph.add(lexeme);
        }
        return sortedParagraph;
    }
}
