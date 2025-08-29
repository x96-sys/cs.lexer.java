package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.Lineage;
import org.x96.sys.lexer.token.Token;

class LineageTest {
    @Test
    void happy() {
        byte[] payload = "c s;".getBytes();
        assertEquals(4, payload.length);
        Token[] tokens = lex(Lineage.class, payload);
        assertEquals(4, tokens.length);
        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", tokens[0].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[0].kind().toString());
        assertEquals("glyph", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", tokens[1].toString());
        assertEquals("SPACE", tokens[1].kind().toString());
        assertEquals("d", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[2].kind().toString());
        assertEquals("glyph", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x3B] [SEMICOLON] [;]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("SEMICOLON", tokens[3].kind().toString());
        assertNull(tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());
    }

    @Test
    void happyStop() {
        byte[] payload = "c s; start_of_another_rule = ...".getBytes();
        assertEquals(32, payload.length);
        Token[] tokens = lex(Lineage.class, payload);
        assertEquals(4, tokens.length);

        assertEquals(4, tokens.length);
        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", tokens[0].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[0].kind().toString());
        assertEquals("glyph", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", tokens[1].toString());
        assertEquals("SPACE", tokens[1].kind().toString());
        assertEquals("d", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[2].kind().toString());
        assertEquals("glyph", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x3B] [SEMICOLON] [;]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("SEMICOLON", tokens[3].kind().toString());
        assertNull(tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());
    }
}
