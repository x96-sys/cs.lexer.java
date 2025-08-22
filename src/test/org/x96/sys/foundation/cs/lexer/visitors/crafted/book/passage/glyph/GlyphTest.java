package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.glyph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class GlyphTest {
    @Test
    void happy() {
        byte[] payload = "c_S".getBytes();
        Lexer lexer = new Lexer(Glyph.class);
        Token[] t = lexer.lex(payload);
        assertEquals(3, t.length);
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals("Token { Kind[glyph] Lexeme[0x5F] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals("Token { Kind[glyph] Lexeme[0x53] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[0].kind());
        assertEquals(Kind.LOW_LINE, t[1].kind());
        assertEquals(Kind.LATIN_CAPITAL_LETTER_S, t[2].kind());
    }
}
