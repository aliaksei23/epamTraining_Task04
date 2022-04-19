package com.company.task04.composite;

import java.util.List;

public interface TextComponent {

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    TextComponent getChild(int index);

    TextComponentType getTextComponentType();

    List<TextComponent> getTextComponents();

}
