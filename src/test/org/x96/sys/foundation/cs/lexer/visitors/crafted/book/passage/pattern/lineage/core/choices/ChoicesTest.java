package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class ChoicesTest {

    @Test
    void happyChoicesBetweenWords() {
        byte[] payload = "( 'cs' | 'sc' )(".getBytes();
        Token[] t = lex(Choices.class, payload);
        Assertions.assertEquals(15, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

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

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals("Token { Kind[word] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x63, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[3].kind());
        assertEquals("word", t[3].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals("Token { Kind[word] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x73, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[4].kind());
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

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                t[7].toString());
        assertEquals(0x7C, t[7].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[7].kind());
        assertEquals("VERTICAL_LINE", t[7].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x20, t[8].lexeme().b());
        assertEquals(Kind.SPACE, t[8].kind());
        assertEquals("empty_space", t[8].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:9 9}:{1:10 10}] }", t[9].toString());
        assertEquals(0x27, t[9].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[9].kind());
        assertEquals("q", t[9].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:10 10}:{1:11 11}] }", t[10].toString());
        assertEquals(0x73, t[10].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[10].kind());
        assertEquals("word", t[10].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:11 11}:{1:12 12}] }", t[11].toString());
        assertEquals(0x63, t[11].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[11].kind());
        assertEquals("word", t[11].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:12 12}:{1:13 13}] }", t[12].toString());
        assertEquals(0x27, t[12].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[12].kind());
        assertEquals("q", t[12].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }",
                t[13].toString());
        assertEquals(0x20, t[13].lexeme().b());
        assertEquals(Kind.SPACE, t[13].kind());
        assertEquals("empty_space", t[13].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:14 14}:{1:15 15}] }",
                t[14].toString());
        assertEquals(0x29, t[14].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[14].kind());
        assertEquals("RIGHT_PARENTHESIS", t[14].overKind);
    }

    @Test
    void happyChoicesBetweenWordAndUnit() {
        byte[] payload = "( 'cs' | sc ) ".getBytes();
        Token[] t = lex(Choices.class, payload);
        Assertions.assertEquals(14, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

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

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals("Token { Kind[word] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x63, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[3].kind());
        assertEquals("word", t[3].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals("Token { Kind[word] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x73, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[4].kind());
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

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                t[7].toString());
        assertEquals(0x7C, t[7].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[7].kind());
        assertEquals("VERTICAL_LINE", t[7].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x20, t[8].lexeme().b());
        assertEquals(Kind.SPACE, t[8].kind());
        assertEquals("empty_space", t[8].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:9 9}:{1:10 10}] }", t[9].toString());
        assertEquals(0x73, t[9].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[9].kind());
        assertEquals("glyph", t[9].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:10 10}:{1:11 11}] }", t[10].toString());
        assertEquals(0x63, t[10].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[10].kind());
        assertEquals("glyph", t[10].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:11 11}:{1:12 12}] }",
                t[11].toString());
        assertEquals(0x20, t[11].lexeme().b());
        assertEquals(Kind.SPACE, t[11].kind());
        assertEquals("empty_space", t[11].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:12 12}:{1:13 13}] }",
                t[12].toString());
        assertEquals(0x29, t[12].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[12].kind());
        assertEquals("RIGHT_PARENTHESIS", t[12].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }",
                t[13].toString());
        assertEquals(0x20, t[13].lexeme().b());
        assertEquals(Kind.SPACE, t[13].kind());
        assertEquals("empty_space", t[13].overKind);
    }

    @Test
    void happy() {
        byte[] payload = "( 0x61 | sc ) {".getBytes();
        assertEquals(15, payload.length);
        Token[] t = lex(Choices.class, payload);
        Assertions.assertEquals(14, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x30] 48 (0) [DIGIT_ZERO] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x30, t[2].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[2].kind());
        assertEquals("hex", t[2].overKind);

        // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x78, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_X, t[3].kind());
        assertEquals("hex", t[3].overKind);

        // [0x36] 54 (6) [DIGIT_SIX] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x36] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x36, t[4].lexeme().b());
        assertEquals(Kind.DIGIT_SIX, t[4].kind());
        assertEquals("hex", t[4].overKind);

        // [0x31] 49 (1) [DIGIT_ONE] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x31] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x31, t[5].lexeme().b());
        assertEquals(Kind.DIGIT_ONE, t[5].kind());
        assertEquals("hex", t[5].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals(0x20, t[6].lexeme().b());
        assertEquals(Kind.SPACE, t[6].kind());
        assertEquals("empty_space", t[6].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:7 7}:{1:8 8}] }",
                t[7].toString());
        assertEquals(0x7C, t[7].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[7].kind());
        assertEquals("VERTICAL_LINE", t[7].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x20, t[8].lexeme().b());
        assertEquals(Kind.SPACE, t[8].kind());
        assertEquals("empty_space", t[8].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:9 9}:{1:10 10}] }", t[9].toString());
        assertEquals(0x73, t[9].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[9].kind());
        assertEquals("glyph", t[9].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:10 10}:{1:11 11}] }", t[10].toString());
        assertEquals(0x63, t[10].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[10].kind());
        assertEquals("glyph", t[10].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:11 11}:{1:12 12}] }",
                t[11].toString());
        assertEquals(0x20, t[11].lexeme().b());
        assertEquals(Kind.SPACE, t[11].kind());
        assertEquals("empty_space", t[11].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:12 12}:{1:13 13}] }",
                t[12].toString());
        assertEquals(0x29, t[12].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[12].kind());
        assertEquals("RIGHT_PARENTHESIS", t[12].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:13 13}:{1:14 14}] }",
                t[13].toString());
        assertEquals(0x20, t[13].lexeme().b());
        assertEquals(Kind.SPACE, t[13].kind());
        assertEquals("empty_space", t[13].overKind);
    }

    @Test
    void happyRecursive() {
        byte[] payload = "( ( 0x63 | 0x61 ) | 'sc' ) {".getBytes();
        assertEquals(28, payload.length);
        Token[] t = lex(Choices.class, payload);
        Assertions.assertEquals(27, t.length);
        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

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

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x20, t[3].lexeme().b());
        assertEquals(Kind.SPACE, t[3].kind());
        assertEquals("empty_space", t[3].overKind);

        // [0x30] 48 (0) [DIGIT_ZERO] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x30, t[4].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[4].kind());
        assertEquals("hex", t[4].overKind);

        // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x78, t[5].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_X, t[5].kind());
        assertEquals("hex", t[5].overKind);

        // [0x36] 54 (6) [DIGIT_SIX] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x36] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals(0x36, t[6].lexeme().b());
        assertEquals(Kind.DIGIT_SIX, t[6].kind());
        assertEquals("hex", t[6].overKind);

        // [0x33] 51 (3) [DIGIT_THREE] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x33] Span[{1:7 7}:{1:8 8}] }", t[7].toString());
        assertEquals(0x33, t[7].lexeme().b());
        assertEquals(Kind.DIGIT_THREE, t[7].kind());
        assertEquals("hex", t[7].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x20, t[8].lexeme().b());
        assertEquals(Kind.SPACE, t[8].kind());
        assertEquals("empty_space", t[8].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:9 9}:{1:10 10}] }",
                t[9].toString());
        assertEquals(0x7C, t[9].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[9].kind());
        assertEquals("VERTICAL_LINE", t[9].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:10 10}:{1:11 11}] }",
                t[10].toString());
        assertEquals(0x20, t[10].lexeme().b());
        assertEquals(Kind.SPACE, t[10].kind());
        assertEquals("empty_space", t[10].overKind);

        // [0x30] 48 (0) [DIGIT_ZERO] [hex]
        assertEquals(
                "Token { Kind[hex] Lexeme[0x30] Span[{1:11 11}:{1:12 12}] }", t[11].toString());
        assertEquals(0x30, t[11].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[11].kind());
        assertEquals("hex", t[11].overKind);

        // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
        assertEquals(
                "Token { Kind[hex] Lexeme[0x78] Span[{1:12 12}:{1:13 13}] }", t[12].toString());
        assertEquals(0x78, t[12].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_X, t[12].kind());
        assertEquals("hex", t[12].overKind);

        // [0x36] 54 (6) [DIGIT_SIX] [hex]
        assertEquals(
                "Token { Kind[hex] Lexeme[0x36] Span[{1:13 13}:{1:14 14}] }", t[13].toString());
        assertEquals(0x36, t[13].lexeme().b());
        assertEquals(Kind.DIGIT_SIX, t[13].kind());
        assertEquals("hex", t[13].overKind);

        // [0x31] 49 (1) [DIGIT_ONE] [hex]
        assertEquals(
                "Token { Kind[hex] Lexeme[0x31] Span[{1:14 14}:{1:15 15}] }", t[14].toString());
        assertEquals(0x31, t[14].lexeme().b());
        assertEquals(Kind.DIGIT_ONE, t[14].kind());
        assertEquals("hex", t[14].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:15 15}:{1:16 16}] }",
                t[15].toString());
        assertEquals(0x20, t[15].lexeme().b());
        assertEquals(Kind.SPACE, t[15].kind());
        assertEquals("empty_space", t[15].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:16 16}:{1:17 17}] }",
                t[16].toString());
        assertEquals(0x29, t[16].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[16].kind());
        assertEquals("RIGHT_PARENTHESIS", t[16].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:17 17}:{1:18 18}] }",
                t[17].toString());
        assertEquals(0x20, t[17].lexeme().b());
        assertEquals(Kind.SPACE, t[17].kind());
        assertEquals("empty_space", t[17].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:18 18}:{1:19 19}] }",
                t[18].toString());
        assertEquals(0x7C, t[18].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[18].kind());
        assertEquals("VERTICAL_LINE", t[18].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:19 19}:{1:20 20}] }",
                t[19].toString());
        assertEquals(0x20, t[19].lexeme().b());
        assertEquals(Kind.SPACE, t[19].kind());
        assertEquals("empty_space", t[19].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:20 20}:{1:21 21}] }", t[20].toString());
        assertEquals(0x27, t[20].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[20].kind());
        assertEquals("q", t[20].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [word]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:21 21}:{1:22 22}] }", t[21].toString());
        assertEquals(0x73, t[21].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[21].kind());
        assertEquals("word", t[21].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [word]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:22 22}:{1:23 23}] }", t[22].toString());
        assertEquals(0x63, t[22].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[22].kind());
        assertEquals("word", t[22].overKind);

        // [0x27] 39 (') [APOSTROPHE] [q]
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:23 23}:{1:24 24}] }", t[23].toString());
        assertEquals(0x27, t[23].lexeme().b());
        assertEquals(Kind.APOSTROPHE, t[23].kind());
        assertEquals("q", t[23].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:24 24}:{1:25 25}] }",
                t[24].toString());
        assertEquals(0x20, t[24].lexeme().b());
        assertEquals(Kind.SPACE, t[24].kind());
        assertEquals("empty_space", t[24].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:25 25}:{1:26 26}] }",
                t[25].toString());
        assertEquals(0x29, t[25].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[25].kind());
        assertEquals("RIGHT_PARENTHESIS", t[25].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:26 26}:{1:27 27}] }",
                t[26].toString());
        assertEquals(0x20, t[26].lexeme().b());
        assertEquals(Kind.SPACE, t[26].kind());
        assertEquals("empty_space", t[26].overKind);
    }

    @Test
    void happySegment() {
        byte[] payload = "( [c] | s ) {".getBytes();
        assertEquals(13, payload.length);
        Token[] t = lex(Choices.class, payload);
        Assertions.assertEquals(12, t.length);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x28, t[0].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[0].kind());
        assertEquals("LEFT_PARENTHESIS", t[0].overKind);

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

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x63, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x5D] 93 (]) [RIGHT_SQUARE_BRACKET] [RIGHT_SQUARE_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:4 4}:{1:5 5}] }",
                t[4].toString());
        assertEquals(0x5D, t[4].lexeme().b());
        assertEquals(Kind.RIGHT_SQUARE_BRACKET, t[4].kind());
        assertEquals("RIGHT_SQUARE_BRACKET", t[4].overKind);

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

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:8 8}:{1:9 9}] }", t[8].toString());
        assertEquals(0x73, t[8].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[8].kind());
        assertEquals("glyph", t[8].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:9 9}:{1:10 10}] }",
                t[9].toString());
        assertEquals(0x20, t[9].lexeme().b());
        assertEquals(Kind.SPACE, t[9].kind());
        assertEquals("empty_space", t[9].overKind);

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
