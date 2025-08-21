package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class ChoiceTest {
    @Test
    void happyChoiceWord() {
        byte[] payload = "| 'sc' ".getBytes();
        assertEquals(7, payload.length);
        Token[] t = lex(Choice.class, payload);
        assertEquals(7, t.length);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7C, t[0].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[0].kind());
        assertEquals("VERTICAL_LINE", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x27, t[2].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[2].kind());
        assertEquals("q", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals("Token { Kind[word] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("word", t[3].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals("Token { Kind[word] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x63, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[4].kind());
        assertEquals("word", t[4].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x27, t[5].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[5].kind());
        assertEquals("q", t[5].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals(0x20, t[6].lexeme().b());
        assertEquals(Kind.SPACE, t[6].kind());
        assertEquals("empty_space", t[6].overKind);
    }

    @Test
    void happyChoiceUnit() {
        byte[] payload = "| cs (".getBytes();
        assertEquals(6, payload.length);
        Token[] t = lex(Choice.class, payload);
        assertEquals(5, t.length);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7C, t[0].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[0].kind());
        assertEquals("VERTICAL_LINE", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x63, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x20, t[4].lexeme().b());
        assertEquals(Kind.SPACE, t[4].kind());
        assertEquals("empty_space", t[4].overKind);
    }

    @Test
    void happyChoiceSegment() {
        byte[] payload = "| [sc cs] [".getBytes();
        assertEquals(11, payload.length);
        Token[] t = lex(Choice.class, payload);
        assertEquals(10, t.length);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7C, t[0].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[0].kind());
        assertEquals("VERTICAL_LINE", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x5B] 91 ([) [LEFT_SQUARE_BRACKET] [LEFT_SQUARE_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_SQUARE_BRACKET] Lexeme[0x5B] Span[{1:2 2}:{1:3 3}] }",
                t[2].toString());
        assertEquals(0x5B, t[2].lexeme().b());
        assertEquals(Kind.LEFT_SQUARE_BRACKET, t[2].kind());
        assertEquals("LEFT_SQUARE_BRACKET", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x63, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[4].kind());
        assertEquals("glyph", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals(0x63, t[6].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[6].kind());
        assertEquals("glyph", t[6].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:7 7}:{1:8 8}] }", t[7].toString());
        assertEquals(0x73, t[7].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[7].kind());
        assertEquals("glyph", t[7].overKind);

        // [0x5D] 93 (]) [RIGHT_SQUARE_BRACKET] [RIGHT_SQUARE_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:8 8}:{1:9 9}] }",
                t[8].toString());
        assertEquals(0x5D, t[8].lexeme().b());
        assertEquals(Kind.RIGHT_SQUARE_BRACKET, t[8].kind());
        assertEquals("RIGHT_SQUARE_BRACKET", t[8].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:9 9}:{1:10 10}] }",
                t[9].toString());
        assertEquals(0x20, t[9].lexeme().b());
        assertEquals(Kind.SPACE, t[9].kind());
        assertEquals("empty_space", t[9].overKind);
    }

    @Test
    void happyChoiceChoices() {
        byte[] payload = "| (sc | cs) {".getBytes();
        assertEquals(13, payload.length);
        Token[] t = lex(Choice.class, payload);
        assertEquals(12, t.length);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7C, t[0].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[0].kind());
        assertEquals("VERTICAL_LINE", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{1:2 2}:{1:3 3}] }",
                t[2].toString());
        assertEquals(0x28, t[2].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[2].kind());
        assertEquals("LEFT_PARENTHESIS", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x63, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[4].kind());
        assertEquals("glyph", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:6 6}:{1:7 7}] }",
                t[6].toString());
        assertEquals(0x7C, t[6].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[6].kind());
        assertEquals("VERTICAL_LINE", t[6].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:7 7}:{1:8 8}] }", t[7].toString());
        assertEquals(0x20, t[7].lexeme().b());
        assertEquals(Kind.SPACE, t[7].kind());
        assertEquals("empty_space", t[7].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x63, t[8].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[8].kind());
        assertEquals("glyph", t[8].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:9 9}:{1:10 10}] }", t[9].toString());
        assertEquals(0x73, t[9].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[9].kind());
        assertEquals("glyph", t[9].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:10 10}:{1:11 11}] }",
                t[10].toString());
        assertEquals(0x29, t[10].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[10].kind());
        assertEquals("RIGHT_PARENTHESIS", t[10].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:11 11}:{1:12 12}] }",
                t[11].toString());
        assertEquals(0x20, t[11].lexeme().b());
        assertEquals(Kind.SPACE, t[11].kind());
        assertEquals("empty_space", t[11].overKind);
    }
}
