package org.x96.sys.foundation.cs.lexer;

import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.visitor.Visitor;

public class LexerTest {
    public static Token[] lex(Class<? extends Visitor> v, byte[] payload) {
        Lexer lexer = new Lexer(v);
        return lexer.lex(payload);
    }
}
