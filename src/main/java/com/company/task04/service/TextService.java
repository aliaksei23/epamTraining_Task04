package com.company.task04.service;

import com.company.task04.composite.TextComponent;
import com.company.task04.exception.IncorrectDataException;

public interface TextService {
    TextComponent sortParagraphsByAmountOfSentences(TextComponent text)
            throws IncorrectDataException;

    TextComponent sortSentencesByMaxWordLength(TextComponent paragraph)
            throws IncorrectDataException;

    TextComponent sortSentencesByMaxLexemeLength(TextComponent paragraph)
            throws IncorrectDataException;

    TextComponent sortLexemesByEntryOfSymbol(TextComponent sentence, char symbol)
            throws IncorrectDataException;
}
