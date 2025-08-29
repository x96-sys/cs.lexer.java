package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.casing.Quantifier;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class QuantifierTest {
    @Test
    void happyZeroOrOne() {
        byte[] payload = "??".getBytes();
        Lexer lexer = new Lexer(Quantifier.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[quantifier] Lexeme[0x3F] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x3F, t[0].lexeme().b());
        assertEquals(Kind.QUESTION_MARK, t[0].kind());
    }

    @Test
    void happyOneOrMore() {
        byte[] payload = "++".getBytes();
        Lexer lexer = new Lexer(Quantifier.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[quantifier] Lexeme[0x2B] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x2B, t[0].lexeme().b());
        assertEquals(Kind.PLUS, t[0].kind());
    }

    @Test
    void happyZeroOrMore() {
        byte[] payload = "**".getBytes();
        Lexer lexer = new Lexer(Quantifier.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[quantifier] Lexeme[0x2A] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x2A, t[0].lexeme().b());
        assertEquals(Kind.ASTERISK, t[0].kind());
    }
}
