package com.company.task04.comparator;

import com.company.task04.composite.TextComponent;

import java.util.Comparator;

public class ParagraphSentenceAmountComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return Integer.compare(o1.getTextComponents().size(),
                o2.getTextComponents().size());
    }
}
