package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.nucleo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.buzz.cs.lexer.BuzzLex;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class NucleoTest {

    private Token[] lex(byte[] payload) {
        Lexer lexer = new Lexer(Nucleo.class);
        return lexer.lex(payload);
    }

    @Test
    void happyRangeHex() {
        byte[] payload = "0xEF-0xFF [".getBytes();
        Token[] t = lex(payload);
        assertEquals(9, t.length);
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x45] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(
                "Token { Kind[HYPHEN_MINUS] Lexeme[0x2D] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:7 7}:{1:8 8}] }", t[7].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
    }

    @Test
    void happyWord() {
        byte[] payload = "'cs'".getBytes();
        Token[] t = lex(payload);
        Assertions.assertEquals(4, t.length);
        Assertions.assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        Assertions.assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        Assertions.assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        Assertions.assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
    }

    @Test
    void happyUnit() {
        byte[] payload = "!c?!s*".getBytes();
        assertEquals(6, payload.length);
        Token[] t = lex(payload);
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
    void happyBuzz() {
        byte[] payload = "<".getBytes();
        assertThrows(BuzzLex.class, () -> lex(payload));
    }
}
