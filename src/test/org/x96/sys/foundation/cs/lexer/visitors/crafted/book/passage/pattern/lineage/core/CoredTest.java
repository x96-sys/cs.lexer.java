package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.buzz.cs.lexer.BuzzLex;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class CoredTest {
    @Test
    void happyUnit() {
        byte[] payload = "cs".getBytes();
        assertEquals(2, payload.length);
        Token[] t = lex(Cored.class, payload);
        assertEquals(2, t.length);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x63, t[0].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[0].kind());
        assertEquals("glyph", t[0].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x73, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[1].kind());
        assertEquals("glyph", t[1].overKind);
    }

    @Test
    void happyWordSpaceAfter() {
        byte[] payload = "'cs' ".getBytes();
        assertEquals(5, payload.length);
        Token[] t = lex(Cored.class, payload);
        assertEquals(5, t.length);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x27, t[0].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[0].kind());
        assertEquals("q", t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals("Token { Kind[word] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("word", t[1].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals("Token { Kind[word] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x73, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[2].kind());
        assertEquals("word", t[2].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x27, t[3].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[3].kind());
        assertEquals("q", t[3].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x20, t[4].lexeme().b());
        assertEquals(Kind.SPACE, t[4].kind());
        assertEquals("empty_space", t[4].overKind);
    }

    @Test
    void happySpaceBefore() {
        byte[] payload = " cs".getBytes();
        assertEquals(3, payload.length);
        assertThrows(BuzzLex.class, () -> lex(Cored.class, payload));
    }

    @Test
    void happyChoice() {
        byte[] payload = "(c|s) ".getBytes();
        assertEquals(6, payload.length);
        Token[] t = lex(Cored.class, payload);
        assertEquals(6, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("glyph", t[1].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:2 2}:{1:3 3}] }",
                t[2].toString());
        assertEquals(0x7C, t[2].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[2].kind());
        assertEquals("VERTICAL_LINE", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:4 4}:{1:5 5}] }",
                t[4].toString());
        assertEquals(0x29, t[4].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[4].kind());
        assertEquals("RIGHT_PARENTHESIS", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);
    }

    @Test
    void happyChoiceFollowedByDirt() {
        byte[] payload = "(c|s) (".getBytes();
        assertEquals(7, payload.length);
        Token[] t = lex(Cored.class, payload);
        assertEquals(6, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("glyph", t[1].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:2 2}:{1:3 3}] }",
                t[2].toString());
        assertEquals(0x7C, t[2].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[2].kind());
        assertEquals("VERTICAL_LINE", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:4 4}:{1:5 5}] }",
                t[4].toString());
        assertEquals(0x29, t[4].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[4].kind());
        assertEquals("RIGHT_PARENTHESIS", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);
    }
}
