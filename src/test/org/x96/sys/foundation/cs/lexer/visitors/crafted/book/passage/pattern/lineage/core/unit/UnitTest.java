package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.unit.Unit;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class UnitTest {
    @Test
    void happyInhibitorQuantifier() {
        byte[] payload = "!c?!s*".getBytes();
        assertEquals(6, payload.length);
        Lexer lexer = new Lexer(Unit.class);
        Token[] t = lexer.lex(payload);
        assertEquals(3, t.length);
        assertEquals(
                "Token { Kind[inhibitor] Lexeme[0x21] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(
                "Token { Kind[quantifier] Lexeme[0x3F] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x21, t[0].lexeme().b());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(0x3F, t[2].lexeme().b());
        assertEquals(Kind.EXCLAMATION_MARK, t[0].kind());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals(Kind.QUESTION_MARK, t[2].kind());
    }

    @Test
    void happyQuantifier() {
        byte[] payload = "sofi+c*".getBytes();
        // assertEquals(4, payload.length);
        Lexer lexer = new Lexer(Unit.class);
        Token[] t = lexer.lex(payload);
    }
}
