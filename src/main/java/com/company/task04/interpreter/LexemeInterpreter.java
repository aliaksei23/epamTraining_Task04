package com.company.task04.interpreter;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class LexemeInterpreter {

    private static final String ENGINE_NAME = "js";
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String EXPRESSION_REGEX = ".*\\d.*";

    public String interpretLexeme(String lexeme) {
        String expressionSolution = lexeme;
        if (lexeme.matches(EXPRESSION_REGEX)) {
            try {
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine engine = scriptEngineManager.getEngineByExtension(ENGINE_NAME);
                Object solution = engine.eval(lexeme);
                expressionSolution = solution.toString();
            } catch (ScriptException e) {
                LOGGER.log(Level.WARN, "Error with lexeme expression", e);
            }
        }
        return expressionSolution;
    }
}
