package com.company.task04.parse.impl;

import com.company.task04.composite.SymbolLeafType;
import com.company.task04.composite.TextComponent;
import com.company.task04.composite.TextComponentType;
import com.company.task04.composite.impl.SymbolLeaf;
import com.company.task04.composite.impl.TextComposite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {

    private SentenceParser sentenceParser;

    @BeforeClass
    public void setUp() {
        sentenceParser = SentenceParser.getInstance();
    }

    @AfterClass
    public void tearDown() {
        sentenceParser = null;
    }

    @Test
    public void parsePositiveTest() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf6 = new SymbolLeaf(',', SymbolLeafType.PUNCTUATION);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        textComponent1.add(symbolLeaf6);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf12 = new SymbolLeaf('.', SymbolLeafType.PUNCTUATION);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        textComponent2.add(symbolLeaf12);
        TextComponent expected = new TextComposite(TextComponentType.SENTENCE);
        expected.add(textComponent1);
        expected.add(textComponent2);
        String sentence = "Hello, world.";
        TextComponent actual = sentenceParser.parse(sentence);
        assertEquals(actual, expected);
    }

    @Test
    public void parseNegativeTest() {
        TextComponent textComponent1 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf1 = new SymbolLeaf('H', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf2 = new SymbolLeaf('e', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf3 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf4 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf5 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        textComponent1.add(symbolLeaf1);
        textComponent1.add(symbolLeaf2);
        textComponent1.add(symbolLeaf3);
        textComponent1.add(symbolLeaf4);
        textComponent1.add(symbolLeaf5);
        TextComponent textComponent2 = new TextComposite(TextComponentType.LEXEME);
        SymbolLeaf symbolLeaf7 = new SymbolLeaf('w', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf8 = new SymbolLeaf('o', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf9 = new SymbolLeaf('r', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf10 = new SymbolLeaf('l', SymbolLeafType.LETTER);
        SymbolLeaf symbolLeaf11 = new SymbolLeaf('d', SymbolLeafType.LETTER);
        textComponent2.add(symbolLeaf7);
        textComponent2.add(symbolLeaf8);
        textComponent2.add(symbolLeaf9);
        textComponent2.add(symbolLeaf10);
        textComponent2.add(symbolLeaf11);
        TextComponent expected = new TextComposite(TextComponentType.SENTENCE);
        expected.add(textComponent1);
        expected.add(textComponent2);
        String sentence = "Hello, world";
        TextComponent actual = sentenceParser.parse(sentence);
        assertNotEquals(actual, expected);
    }
}