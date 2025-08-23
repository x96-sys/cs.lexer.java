package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Token;

class ChoicesTest {

    @Test
    void happyChoicesBetweenWords() {
        byte[] payload = "( 'cs' | 'sc' )(".getBytes();
        Token[] tokens = lex(Choices.class, payload);
        Assertions.assertEquals(15, tokens.length);

        assertEquals(15, tokens.length);
        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[0].kind().toString());
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[3].kind().toString());
        assertEquals("word", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[4].kind().toString());
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("VERTICAL_LINE", tokens[7].kind().toString());
        assertNull(tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("SPACE", tokens[8].kind().toString());
        assertEquals("d", tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{1:9 9}:{1:10 10}] }", tokens[9].toString());
        assertEquals("APOSTROPHE", tokens[9].kind().toString());
        assertEquals("q", tokens[9].overKind);
        assertEquals(1, tokens[9].span().start().line());
        assertEquals(9, tokens[9].span().start().column());
        assertEquals(9, tokens[9].span().start().offset());
        assertEquals(1, tokens[9].span().end().line());
        assertEquals(10, tokens[9].span().end().column());
        assertEquals(9, tokens[9].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:10 10}:{1:11 11}] }",
                tokens[10].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[10].kind().toString());
        assertEquals("word", tokens[10].overKind);
        assertEquals(1, tokens[10].span().start().line());
        assertEquals(10, tokens[10].span().start().column());
        assertEquals(10, tokens[10].span().start().offset());
        assertEquals(1, tokens[10].span().end().line());
        assertEquals(11, tokens[10].span().end().column());
        assertEquals(10, tokens[10].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:11 11}:{1:12 12}] }",
                tokens[11].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[11].kind().toString());
        assertEquals("word", tokens[11].overKind);
        assertEquals(1, tokens[11].span().start().line());
        assertEquals(11, tokens[11].span().start().column());
        assertEquals(11, tokens[11].span().start().offset());
        assertEquals(1, tokens[11].span().end().line());
        assertEquals(12, tokens[11].span().end().column());
        assertEquals(11, tokens[11].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{1:12 12}:{1:13 13}] }", tokens[12].toString());
        assertEquals("APOSTROPHE", tokens[12].kind().toString());
        assertEquals("q", tokens[12].overKind);
        assertEquals(1, tokens[12].span().start().line());
        assertEquals(12, tokens[12].span().start().column());
        assertEquals(12, tokens[12].span().start().offset());
        assertEquals(1, tokens[12].span().end().line());
        assertEquals(13, tokens[12].span().end().column());
        assertEquals(12, tokens[12].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }", tokens[13].toString());
        assertEquals("SPACE", tokens[13].kind().toString());
        assertEquals("d", tokens[13].overKind);
        assertEquals(1, tokens[13].span().start().line());
        assertEquals(13, tokens[13].span().start().column());
        assertEquals(13, tokens[13].span().start().offset());
        assertEquals(1, tokens[13].span().end().line());
        assertEquals(14, tokens[13].span().end().column());
        assertEquals(13, tokens[13].span().start().offset());

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:14 14}:{1:15 15}] }",
                tokens[14].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[14].kind().toString());
        assertNull(tokens[14].overKind);
        assertEquals(1, tokens[14].span().start().line());
        assertEquals(14, tokens[14].span().start().column());
        assertEquals(14, tokens[14].span().start().offset());
        assertEquals(1, tokens[14].span().end().line());
        assertEquals(15, tokens[14].span().end().column());
        assertEquals(14, tokens[14].span().start().offset());
    }

    @Test
    void happyChoicesBetweenWordAndUnit() {
        byte[] payload = "( 'cs' | sc ) ".getBytes();
        Token[] tokens = lex(Choices.class, payload);
        Assertions.assertEquals(14, tokens.length);
        assertEquals(14, tokens.length);
        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[0].kind().toString());
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[3].kind().toString());
        assertEquals("word", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[4].kind().toString());
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("VERTICAL_LINE", tokens[7].kind().toString());
        assertNull(tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("SPACE", tokens[8].kind().toString());
        assertEquals("d", tokens[8].overKind);
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:10 10}:{1:11 11}] }",
                tokens[10].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[10].kind().toString());
        assertEquals("glyph", tokens[10].overKind);
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

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:12 12}:{1:13 13}] }",
                tokens[12].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[12].kind().toString());
        assertNull(tokens[12].overKind);
        assertEquals(1, tokens[12].span().start().line());
        assertEquals(12, tokens[12].span().start().column());
        assertEquals(12, tokens[12].span().start().offset());
        assertEquals(1, tokens[12].span().end().line());
        assertEquals(13, tokens[12].span().end().column());
        assertEquals(12, tokens[12].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }", tokens[13].toString());
        assertEquals("SPACE", tokens[13].kind().toString());
        assertEquals("d", tokens[13].overKind);
        assertEquals(1, tokens[13].span().start().line());
        assertEquals(13, tokens[13].span().start().column());
        assertEquals(13, tokens[13].span().start().offset());
        assertEquals(1, tokens[13].span().end().line());
        assertEquals(14, tokens[13].span().end().column());
        assertEquals(13, tokens[13].span().start().offset());
    }

    @Test
    void happy() {
        byte[] payload = "( 0x61 | sc ) {".getBytes();
        assertEquals(15, payload.length);
        Token[] tokens = lex(Choices.class, payload);
        assertEquals(14, tokens.length);
        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[0].kind().toString());
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

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("DIGIT_ZERO", tokens[2].kind().toString());
        assertEquals("hexadecimal", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[3].kind().toString());
        assertEquals("hexadecimal", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x36] [DIGIT_SIX] [6]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x36] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("DIGIT_SIX", tokens[4].kind().toString());
        assertEquals("hexadecimal", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x31] [DIGIT_ONE] [1]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x31] Span[{1:5 5}:{1:6 6}] }",
                tokens[5].toString());
        assertEquals("DIGIT_ONE", tokens[5].kind().toString());
        assertEquals("hexadecimal", tokens[5].overKind);
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("VERTICAL_LINE", tokens[7].kind().toString());
        assertNull(tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("SPACE", tokens[8].kind().toString());
        assertEquals("d", tokens[8].overKind);
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:10 10}:{1:11 11}] }",
                tokens[10].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[10].kind().toString());
        assertEquals("glyph", tokens[10].overKind);
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

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:12 12}:{1:13 13}] }",
                tokens[12].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[12].kind().toString());
        assertNull(tokens[12].overKind);
        assertEquals(1, tokens[12].span().start().line());
        assertEquals(12, tokens[12].span().start().column());
        assertEquals(12, tokens[12].span().start().offset());
        assertEquals(1, tokens[12].span().end().line());
        assertEquals(13, tokens[12].span().end().column());
        assertEquals(12, tokens[12].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }", tokens[13].toString());
        assertEquals("SPACE", tokens[13].kind().toString());
        assertEquals("d", tokens[13].overKind);
        assertEquals(1, tokens[13].span().start().line());
        assertEquals(13, tokens[13].span().start().column());
        assertEquals(13, tokens[13].span().start().offset());
        assertEquals(1, tokens[13].span().end().line());
        assertEquals(14, tokens[13].span().end().column());
        assertEquals(13, tokens[13].span().start().offset());
    }

    @Test
    void happyRecursive() {
        byte[] payload = "( ( 0x63 | 0x61 ) | 'sc' ) {".getBytes();
        assertEquals(28, payload.length);
        Token[] tokens = lex(Choices.class, payload);
        assertEquals(27, tokens.length);

        assertEquals(27, tokens.length);
        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[0].kind().toString());
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

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("SPACE", tokens[3].kind().toString());
        assertEquals("d", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("DIGIT_ZERO", tokens[4].kind().toString());
        assertEquals("hexadecimal", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{1:5 5}:{1:6 6}] }",
                tokens[5].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[5].kind().toString());
        assertEquals("hexadecimal", tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x36] [DIGIT_SIX] [6]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x36] Span[{1:6 6}:{1:7 7}] }",
                tokens[6].toString());
        assertEquals("DIGIT_SIX", tokens[6].kind().toString());
        assertEquals("hexadecimal", tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x33] [DIGIT_THREE] [3]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x33] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("DIGIT_THREE", tokens[7].kind().toString());
        assertEquals("hexadecimal", tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("SPACE", tokens[8].kind().toString());
        assertEquals("d", tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:9 9}:{1:10 10}] }",
                tokens[9].toString());
        assertEquals("VERTICAL_LINE", tokens[9].kind().toString());
        assertNull(tokens[9].overKind);
        assertEquals(1, tokens[9].span().start().line());
        assertEquals(9, tokens[9].span().start().column());
        assertEquals(9, tokens[9].span().start().offset());
        assertEquals(1, tokens[9].span().end().line());
        assertEquals(10, tokens[9].span().end().column());
        assertEquals(9, tokens[9].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:10 10}:{1:11 11}] }", tokens[10].toString());
        assertEquals("SPACE", tokens[10].kind().toString());
        assertEquals("d", tokens[10].overKind);
        assertEquals(1, tokens[10].span().start().line());
        assertEquals(10, tokens[10].span().start().column());
        assertEquals(10, tokens[10].span().start().offset());
        assertEquals(1, tokens[10].span().end().line());
        assertEquals(11, tokens[10].span().end().column());
        assertEquals(10, tokens[10].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{1:11 11}:{1:12 12}] }",
                tokens[11].toString());
        assertEquals("DIGIT_ZERO", tokens[11].kind().toString());
        assertEquals("hexadecimal", tokens[11].overKind);
        assertEquals(1, tokens[11].span().start().line());
        assertEquals(11, tokens[11].span().start().column());
        assertEquals(11, tokens[11].span().start().offset());
        assertEquals(1, tokens[11].span().end().line());
        assertEquals(12, tokens[11].span().end().column());
        assertEquals(11, tokens[11].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{1:12 12}:{1:13 13}] }",
                tokens[12].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[12].kind().toString());
        assertEquals("hexadecimal", tokens[12].overKind);
        assertEquals(1, tokens[12].span().start().line());
        assertEquals(12, tokens[12].span().start().column());
        assertEquals(12, tokens[12].span().start().offset());
        assertEquals(1, tokens[12].span().end().line());
        assertEquals(13, tokens[12].span().end().column());
        assertEquals(12, tokens[12].span().start().offset());

        // [0x36] [DIGIT_SIX] [6]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x36] Span[{1:13 13}:{1:14 14}] }",
                tokens[13].toString());
        assertEquals("DIGIT_SIX", tokens[13].kind().toString());
        assertEquals("hexadecimal", tokens[13].overKind);
        assertEquals(1, tokens[13].span().start().line());
        assertEquals(13, tokens[13].span().start().column());
        assertEquals(13, tokens[13].span().start().offset());
        assertEquals(1, tokens[13].span().end().line());
        assertEquals(14, tokens[13].span().end().column());
        assertEquals(13, tokens[13].span().start().offset());

        // [0x31] [DIGIT_ONE] [1]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x31] Span[{1:14 14}:{1:15 15}] }",
                tokens[14].toString());
        assertEquals("DIGIT_ONE", tokens[14].kind().toString());
        assertEquals("hexadecimal", tokens[14].overKind);
        assertEquals(1, tokens[14].span().start().line());
        assertEquals(14, tokens[14].span().start().column());
        assertEquals(14, tokens[14].span().start().offset());
        assertEquals(1, tokens[14].span().end().line());
        assertEquals(15, tokens[14].span().end().column());
        assertEquals(14, tokens[14].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:15 15}:{1:16 16}] }", tokens[15].toString());
        assertEquals("SPACE", tokens[15].kind().toString());
        assertEquals("d", tokens[15].overKind);
        assertEquals(1, tokens[15].span().start().line());
        assertEquals(15, tokens[15].span().start().column());
        assertEquals(15, tokens[15].span().start().offset());
        assertEquals(1, tokens[15].span().end().line());
        assertEquals(16, tokens[15].span().end().column());
        assertEquals(15, tokens[15].span().start().offset());

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:16 16}:{1:17 17}] }",
                tokens[16].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[16].kind().toString());
        assertNull(tokens[16].overKind);
        assertEquals(1, tokens[16].span().start().line());
        assertEquals(16, tokens[16].span().start().column());
        assertEquals(16, tokens[16].span().start().offset());
        assertEquals(1, tokens[16].span().end().line());
        assertEquals(17, tokens[16].span().end().column());
        assertEquals(16, tokens[16].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:17 17}:{1:18 18}] }", tokens[17].toString());
        assertEquals("SPACE", tokens[17].kind().toString());
        assertEquals("d", tokens[17].overKind);
        assertEquals(1, tokens[17].span().start().line());
        assertEquals(17, tokens[17].span().start().column());
        assertEquals(17, tokens[17].span().start().offset());
        assertEquals(1, tokens[17].span().end().line());
        assertEquals(18, tokens[17].span().end().column());
        assertEquals(17, tokens[17].span().start().offset());

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:18 18}:{1:19 19}] }",
                tokens[18].toString());
        assertEquals("VERTICAL_LINE", tokens[18].kind().toString());
        assertNull(tokens[18].overKind);
        assertEquals(1, tokens[18].span().start().line());
        assertEquals(18, tokens[18].span().start().column());
        assertEquals(18, tokens[18].span().start().offset());
        assertEquals(1, tokens[18].span().end().line());
        assertEquals(19, tokens[18].span().end().column());
        assertEquals(18, tokens[18].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:19 19}:{1:20 20}] }", tokens[19].toString());
        assertEquals("SPACE", tokens[19].kind().toString());
        assertEquals("d", tokens[19].overKind);
        assertEquals(1, tokens[19].span().start().line());
        assertEquals(19, tokens[19].span().start().column());
        assertEquals(19, tokens[19].span().start().offset());
        assertEquals(1, tokens[19].span().end().line());
        assertEquals(20, tokens[19].span().end().column());
        assertEquals(19, tokens[19].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{1:20 20}:{1:21 21}] }", tokens[20].toString());
        assertEquals("APOSTROPHE", tokens[20].kind().toString());
        assertEquals("q", tokens[20].overKind);
        assertEquals(1, tokens[20].span().start().line());
        assertEquals(20, tokens[20].span().start().column());
        assertEquals(20, tokens[20].span().start().offset());
        assertEquals(1, tokens[20].span().end().line());
        assertEquals(21, tokens[20].span().end().column());
        assertEquals(20, tokens[20].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:21 21}:{1:22 22}] }",
                tokens[21].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[21].kind().toString());
        assertEquals("word", tokens[21].overKind);
        assertEquals(1, tokens[21].span().start().line());
        assertEquals(21, tokens[21].span().start().column());
        assertEquals(21, tokens[21].span().start().offset());
        assertEquals(1, tokens[21].span().end().line());
        assertEquals(22, tokens[21].span().end().column());
        assertEquals(21, tokens[21].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:22 22}:{1:23 23}] }",
                tokens[22].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[22].kind().toString());
        assertEquals("word", tokens[22].overKind);
        assertEquals(1, tokens[22].span().start().line());
        assertEquals(22, tokens[22].span().start().column());
        assertEquals(22, tokens[22].span().start().offset());
        assertEquals(1, tokens[22].span().end().line());
        assertEquals(23, tokens[22].span().end().column());
        assertEquals(22, tokens[22].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals(
                "Token { Kind[q] Lexeme[0x27] Span[{1:23 23}:{1:24 24}] }", tokens[23].toString());
        assertEquals("APOSTROPHE", tokens[23].kind().toString());
        assertEquals("q", tokens[23].overKind);
        assertEquals(1, tokens[23].span().start().line());
        assertEquals(23, tokens[23].span().start().column());
        assertEquals(23, tokens[23].span().start().offset());
        assertEquals(1, tokens[23].span().end().line());
        assertEquals(24, tokens[23].span().end().column());
        assertEquals(23, tokens[23].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:24 24}:{1:25 25}] }", tokens[24].toString());
        assertEquals("SPACE", tokens[24].kind().toString());
        assertEquals("d", tokens[24].overKind);
        assertEquals(1, tokens[24].span().start().line());
        assertEquals(24, tokens[24].span().start().column());
        assertEquals(24, tokens[24].span().start().offset());
        assertEquals(1, tokens[24].span().end().line());
        assertEquals(25, tokens[24].span().end().column());
        assertEquals(24, tokens[24].span().start().offset());

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:25 25}:{1:26 26}] }",
                tokens[25].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[25].kind().toString());
        assertNull(tokens[25].overKind);
        assertEquals(1, tokens[25].span().start().line());
        assertEquals(25, tokens[25].span().start().column());
        assertEquals(25, tokens[25].span().start().offset());
        assertEquals(1, tokens[25].span().end().line());
        assertEquals(26, tokens[25].span().end().column());
        assertEquals(25, tokens[25].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{1:26 26}:{1:27 27}] }", tokens[26].toString());
        assertEquals("SPACE", tokens[26].kind().toString());
        assertEquals("d", tokens[26].overKind);
        assertEquals(1, tokens[26].span().start().line());
        assertEquals(26, tokens[26].span().start().column());
        assertEquals(26, tokens[26].span().start().offset());
        assertEquals(1, tokens[26].span().end().line());
        assertEquals(27, tokens[26].span().end().column());
        assertEquals(26, tokens[26].span().start().offset());
    }

    @Test
    void happySegment() {
        byte[] payload = "( [c] | s ) {".getBytes();
        assertEquals(13, payload.length);
        Token[] tokens = lex(Choices.class, payload);
        assertEquals(12, tokens.length);
        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[0].kind().toString());
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

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[3].kind().toString());
        assertEquals("glyph", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x5D] [RIGHT_SQUARE_BRACKET] []]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("RIGHT_SQUARE_BRACKET", tokens[4].kind().toString());
        assertNull(tokens[4].overKind);
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

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:8 8}:{1:9 9}] }", tokens[8].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[8].kind().toString());
        assertEquals("glyph", tokens[8].overKind);
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
