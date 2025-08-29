package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.choices.Choice;
import org.x96.sys.lexer.token.Token;

class ChoiceTest {
    @Test
    void happyChoiceWord() {
        byte[] payload = "| 'sc' ".getBytes();
        assertEquals(7, payload.length);
        Token[] tokens = lex(Choice.class, payload);
        assertEquals(7, tokens.length);
        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("VERTICAL_LINE", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
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

        // [0x27] [APOSTROPHE] [']
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("APOSTROPHE", tokens[2].kind().toString());
        assertEquals("q", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[3].kind().toString());
        assertEquals("word", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[4].kind().toString());
        assertEquals("word", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:5 5}:{1:6 6}] }", tokens[5].toString());
        assertEquals("APOSTROPHE", tokens[5].kind().toString());
        assertEquals("q", tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:6 6}:{1:7 7}] }", tokens[6].toString());
        assertEquals("SPACE", tokens[6].kind().toString());
        assertEquals("d", tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());
    }

    @Test
    void happyChoiceUnit() {
        byte[] payload = "| cs (".getBytes();
        assertEquals(6, payload.length);
        Token[] tokens = lex(Choice.class, payload);
        assertEquals(5, tokens.length);
        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("VERTICAL_LINE", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[2].kind().toString());
        assertEquals("glyph", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[3].kind().toString());
        assertEquals("glyph", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("SPACE", tokens[4].kind().toString());
        assertEquals("d", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());
    }

    @Test
    void happyChoiceSegment() {
        byte[] payload = "| [sc cs] [".getBytes();
        assertEquals(11, payload.length);
        Token[] tokens = lex(Choice.class, payload);
        assertEquals(10, tokens.length);
        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("VERTICAL_LINE", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
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

        // [0x5B] [LEFT_SQUARE_BRACKET] [[]
        assertEquals(
                "Token { Kind[LEFT_SQUARE_BRACKET] Lexeme[0x5B] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("LEFT_SQUARE_BRACKET", tokens[2].kind().toString());
        assertNull(tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[3].kind().toString());
        assertEquals("glyph", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[4].kind().toString());
        assertEquals("glyph", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", tokens[5].toString());
        assertEquals("SPACE", tokens[5].kind().toString());
        assertEquals("d", tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:6 6}:{1:7 7}] }", tokens[6].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[6].kind().toString());
        assertEquals("glyph", tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:7 7}:{1:8 8}] }", tokens[7].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[7].kind().toString());
        assertEquals("glyph", tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x5D] [RIGHT_SQUARE_BRACKET] []]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:8 8}:{1:9 9}] }",
                tokens[8].toString());
        assertEquals("RIGHT_SQUARE_BRACKET", tokens[8].kind().toString());
        assertNull(tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:9 9}:{1:10 10}] }", tokens[9].toString());
        assertEquals("SPACE", tokens[9].kind().toString());
        assertEquals("d", tokens[9].overKind);
        assertEquals(1, tokens[9].span().start().line());
        assertEquals(9, tokens[9].span().start().column());
        assertEquals(9, tokens[9].span().start().offset());
        assertEquals(1, tokens[9].span().end().line());
        assertEquals(10, tokens[9].span().end().column());
        assertEquals(9, tokens[9].span().start().offset());
    }

    @Test
    void happyChoiceChoices() {
        byte[] payload = "| (sc | cs) {".getBytes();
        assertEquals(13, payload.length);
        Token[] tokens = lex(Choice.class, payload);
        assertEquals(12, tokens.length);
        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("VERTICAL_LINE", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
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

        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[2].kind().toString());
        assertNull(tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[3].kind().toString());
        assertEquals("glyph", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[4].kind().toString());
        assertEquals("glyph", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", tokens[5].toString());
        assertEquals("SPACE", tokens[5].kind().toString());
        assertEquals("d", tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:6 6}:{1:7 7}] }",
                tokens[6].toString());
        assertEquals("VERTICAL_LINE", tokens[6].kind().toString());
        assertNull(tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:7 7}:{1:8 8}] }", tokens[7].toString());
        assertEquals("SPACE", tokens[7].kind().toString());
        assertEquals("d", tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[8].kind().toString());
        assertEquals("glyph", tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:9 9}:{1:10 10}] }", tokens[9].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[9].kind().toString());
        assertEquals("glyph", tokens[9].overKind);
        assertEquals(1, tokens[9].span().start().line());
        assertEquals(9, tokens[9].span().start().column());
        assertEquals(9, tokens[9].span().start().offset());
        assertEquals(1, tokens[9].span().end().line());
        assertEquals(10, tokens[9].span().end().column());
        assertEquals(9, tokens[9].span().start().offset());

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:10 10}:{1:11 11}] }",
                tokens[10].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[10].kind().toString());
        assertNull(tokens[10].overKind);
        assertEquals(1, tokens[10].span().start().line());
        assertEquals(10, tokens[10].span().start().column());
        assertEquals(10, tokens[10].span().start().offset());
        assertEquals(1, tokens[10].span().end().line());
        assertEquals(11, tokens[10].span().end().column());
        assertEquals(10, tokens[10].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:11 11}:{1:12 12}] }", tokens[11].toString());
        assertEquals("SPACE", tokens[11].kind().toString());
        assertEquals("d", tokens[11].overKind);
        assertEquals(1, tokens[11].span().start().line());
        assertEquals(11, tokens[11].span().start().column());
        assertEquals(11, tokens[11].span().start().offset());
        assertEquals(1, tokens[11].span().end().line());
        assertEquals(12, tokens[11].span().end().column());
        assertEquals(11, tokens[11].span().start().offset());
    }
}
