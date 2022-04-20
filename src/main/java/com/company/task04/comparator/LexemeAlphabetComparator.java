package com.company.task04.comparator;

import com.company.task04.composite.TextComponent;
import com.company.task04.composite.impl.SymbolLeaf;

import java.util.Comparator;

public class LexemeAlphabetComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        SymbolLeaf symbolLeaf1 = (SymbolLeaf) o1.getTextComponents().get(0);
        SymbolLeaf symbolLeaf2 = (SymbolLeaf) o2.getTextComponents().get(0);
        return Character.compare(symbolLeaf1.getSymbol(), symbolLeaf2.getSymbol());
    }
}
