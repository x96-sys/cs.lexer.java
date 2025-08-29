package org.x96.sys.foundation.cs.lexer.visitors.crafted.book;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.Book;
import org.x96.sys.lexer.token.Token;

class BookTest {
    @Test
    void happyChoiceWord() {
        String source =
                """
                \u0002
                c = 0x63;
                s = {0x73}
                \u0003 :D\
                """;
        byte[] payload = source.getBytes();
        assertEquals(27, payload.length);
        Token[] tokens = lex(Book.class, payload);
        assertEquals(24, tokens.length);

        // [0x2] [STX] [\u0002]
        assertEquals(
                "Token { Kind[open_book] Lexeme[0x2] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("STX", tokens[0].kind().toString());
        assertEquals("open_book", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0xA] [LF] [\n]
        assertEquals("Token { Kind[d] Lexeme[0xA] Span[{1:1 1}:{2:1 2}] }", tokens[1].toString());
        assertEquals("LF", tokens[1].kind().toString());
        assertEquals("d", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(2, tokens[1].span().end().line());
        assertEquals(1, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{2:1 2}:{2:2 3}] }", tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[2].kind().toString());
        assertEquals("glyph", tokens[2].overKind);
        assertEquals(2, tokens[2].span().start().line());
        assertEquals(1, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(2, tokens[2].span().end().line());
        assertEquals(2, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{2:2 3}:{2:3 4}] }", tokens[3].toString());
        assertEquals("SPACE", tokens[3].kind().toString());
        assertEquals("d", tokens[3].overKind);
        assertEquals(2, tokens[3].span().start().line());
        assertEquals(2, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(2, tokens[3].span().end().line());
        assertEquals(3, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x3D] [EQUALS] [=]
        assertEquals(
                "Token { Kind[assignor] Lexeme[0x3D] Span[{2:3 4}:{2:4 5}] }",
                tokens[4].toString());
        assertEquals("EQUALS", tokens[4].kind().toString());
        assertEquals("assignor", tokens[4].overKind);
        assertEquals(2, tokens[4].span().start().line());
        assertEquals(3, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(2, tokens[4].span().end().line());
        assertEquals(4, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{2:4 5}:{2:5 6}] }", tokens[5].toString());
        assertEquals("SPACE", tokens[5].kind().toString());
        assertEquals("d", tokens[5].overKind);
        assertEquals(2, tokens[5].span().start().line());
        assertEquals(4, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(2, tokens[5].span().end().line());
        assertEquals(5, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{2:5 6}:{2:6 7}] }",
                tokens[6].toString());
        assertEquals("DIGIT_ZERO", tokens[6].kind().toString());
        assertEquals("hexadecimal", tokens[6].overKind);
        assertEquals(2, tokens[6].span().start().line());
        assertEquals(5, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(2, tokens[6].span().end().line());
        assertEquals(6, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{2:6 7}:{2:7 8}] }",
                tokens[7].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[7].kind().toString());
        assertEquals("hexadecimal", tokens[7].overKind);
        assertEquals(2, tokens[7].span().start().line());
        assertEquals(6, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(2, tokens[7].span().end().line());
        assertEquals(7, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x36] [DIGIT_SIX] [6]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x36] Span[{2:7 8}:{2:8 9}] }",
                tokens[8].toString());
        assertEquals("DIGIT_SIX", tokens[8].kind().toString());
        assertEquals("hexadecimal", tokens[8].overKind);
        assertEquals(2, tokens[8].span().start().line());
        assertEquals(7, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(2, tokens[8].span().end().line());
        assertEquals(8, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());

        // [0x33] [DIGIT_THREE] [3]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x33] Span[{2:8 9}:{2:9 10}] }",
                tokens[9].toString());
        assertEquals("DIGIT_THREE", tokens[9].kind().toString());
        assertEquals("hexadecimal", tokens[9].overKind);
        assertEquals(2, tokens[9].span().start().line());
        assertEquals(8, tokens[9].span().start().column());
        assertEquals(9, tokens[9].span().start().offset());
        assertEquals(2, tokens[9].span().end().line());
        assertEquals(9, tokens[9].span().end().column());
        assertEquals(9, tokens[9].span().start().offset());

        // [0x3B] [SEMICOLON] [;]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{2:9 10}:{2:10 11}] }",
                tokens[10].toString());
        assertEquals("SEMICOLON", tokens[10].kind().toString());
        assertNull(tokens[10].overKind);
        assertEquals(2, tokens[10].span().start().line());
        assertEquals(9, tokens[10].span().start().column());
        assertEquals(10, tokens[10].span().start().offset());
        assertEquals(2, tokens[10].span().end().line());
        assertEquals(10, tokens[10].span().end().column());
        assertEquals(10, tokens[10].span().start().offset());

        // [0xA] [LF] [\n]
        assertEquals(
                "Token { Kind[d] Lexeme[0xA] Span[{2:10 11}:{3:1 12}] }", tokens[11].toString());
        assertEquals("LF", tokens[11].kind().toString());
        assertEquals("d", tokens[11].overKind);
        assertEquals(2, tokens[11].span().start().line());
        assertEquals(10, tokens[11].span().start().column());
        assertEquals(11, tokens[11].span().start().offset());
        assertEquals(3, tokens[11].span().end().line());
        assertEquals(1, tokens[11].span().end().column());
        assertEquals(11, tokens[11].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{3:1 12}:{3:2 13}] }",
                tokens[12].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[12].kind().toString());
        assertEquals("glyph", tokens[12].overKind);
        assertEquals(3, tokens[12].span().start().line());
        assertEquals(1, tokens[12].span().start().column());
        assertEquals(12, tokens[12].span().start().offset());
        assertEquals(3, tokens[12].span().end().line());
        assertEquals(2, tokens[12].span().end().column());
        assertEquals(12, tokens[12].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{3:2 13}:{3:3 14}] }", tokens[13].toString());
        assertEquals("SPACE", tokens[13].kind().toString());
        assertEquals("d", tokens[13].overKind);
        assertEquals(3, tokens[13].span().start().line());
        assertEquals(2, tokens[13].span().start().column());
        assertEquals(13, tokens[13].span().start().offset());
        assertEquals(3, tokens[13].span().end().line());
        assertEquals(3, tokens[13].span().end().column());
        assertEquals(13, tokens[13].span().start().offset());

        // [0x3D] [EQUALS] [=]
        assertEquals(
                "Token { Kind[assignor] Lexeme[0x3D] Span[{3:3 14}:{3:4 15}] }",
                tokens[14].toString());
        assertEquals("EQUALS", tokens[14].kind().toString());
        assertEquals("assignor", tokens[14].overKind);
        assertEquals(3, tokens[14].span().start().line());
        assertEquals(3, tokens[14].span().start().column());
        assertEquals(14, tokens[14].span().start().offset());
        assertEquals(3, tokens[14].span().end().line());
        assertEquals(4, tokens[14].span().end().column());
        assertEquals(14, tokens[14].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[d] Lexeme[0x20] Span[{3:4 15}:{3:5 16}] }", tokens[15].toString());
        assertEquals("SPACE", tokens[15].kind().toString());
        assertEquals("d", tokens[15].overKind);
        assertEquals(3, tokens[15].span().start().line());
        assertEquals(4, tokens[15].span().start().column());
        assertEquals(15, tokens[15].span().start().offset());
        assertEquals(3, tokens[15].span().end().line());
        assertEquals(5, tokens[15].span().end().column());
        assertEquals(15, tokens[15].span().start().offset());

        // [0x7B] [LEFT_CURLY_BRACKET] [{]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{3:5 16}:{3:6 17}] }",
                tokens[16].toString());
        assertEquals("LEFT_CURLY_BRACKET", tokens[16].kind().toString());
        assertNull(tokens[16].overKind);
        assertEquals(3, tokens[16].span().start().line());
        assertEquals(5, tokens[16].span().start().column());
        assertEquals(16, tokens[16].span().start().offset());
        assertEquals(3, tokens[16].span().end().line());
        assertEquals(6, tokens[16].span().end().column());
        assertEquals(16, tokens[16].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{3:6 17}:{3:7 18}] }",
                tokens[17].toString());
        assertEquals("DIGIT_ZERO", tokens[17].kind().toString());
        assertEquals("hexadecimal", tokens[17].overKind);
        assertEquals(3, tokens[17].span().start().line());
        assertEquals(6, tokens[17].span().start().column());
        assertEquals(17, tokens[17].span().start().offset());
        assertEquals(3, tokens[17].span().end().line());
        assertEquals(7, tokens[17].span().end().column());
        assertEquals(17, tokens[17].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{3:7 18}:{3:8 19}] }",
                tokens[18].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[18].kind().toString());
        assertEquals("hexadecimal", tokens[18].overKind);
        assertEquals(3, tokens[18].span().start().line());
        assertEquals(7, tokens[18].span().start().column());
        assertEquals(18, tokens[18].span().start().offset());
        assertEquals(3, tokens[18].span().end().line());
        assertEquals(8, tokens[18].span().end().column());
        assertEquals(18, tokens[18].span().start().offset());

        // [0x37] [DIGIT_SEVEN] [7]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x37] Span[{3:8 19}:{3:9 20}] }",
                tokens[19].toString());
        assertEquals("DIGIT_SEVEN", tokens[19].kind().toString());
        assertEquals("hexadecimal", tokens[19].overKind);
        assertEquals(3, tokens[19].span().start().line());
        assertEquals(8, tokens[19].span().start().column());
        assertEquals(19, tokens[19].span().start().offset());
        assertEquals(3, tokens[19].span().end().line());
        assertEquals(9, tokens[19].span().end().column());
        assertEquals(19, tokens[19].span().start().offset());

        // [0x33] [DIGIT_THREE] [3]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x33] Span[{3:9 20}:{3:10 21}] }",
                tokens[20].toString());
        assertEquals("DIGIT_THREE", tokens[20].kind().toString());
        assertEquals("hexadecimal", tokens[20].overKind);
        assertEquals(3, tokens[20].span().start().line());
        assertEquals(9, tokens[20].span().start().column());
        assertEquals(20, tokens[20].span().start().offset());
        assertEquals(3, tokens[20].span().end().line());
        assertEquals(10, tokens[20].span().end().column());
        assertEquals(20, tokens[20].span().start().offset());

        // [0x7D] [RIGHT_CURLY_BRACKET] [}]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{3:10 21}:{3:11 22}] }",
                tokens[21].toString());
        assertEquals("RIGHT_CURLY_BRACKET", tokens[21].kind().toString());
        assertNull(tokens[21].overKind);
        assertEquals(3, tokens[21].span().start().line());
        assertEquals(10, tokens[21].span().start().column());
        assertEquals(21, tokens[21].span().start().offset());
        assertEquals(3, tokens[21].span().end().line());
        assertEquals(11, tokens[21].span().end().column());
        assertEquals(21, tokens[21].span().start().offset());

        // [0xA] [LF] [\n]
        assertEquals(
                "Token { Kind[d] Lexeme[0xA] Span[{3:11 22}:{4:1 23}] }", tokens[22].toString());
        assertEquals("LF", tokens[22].kind().toString());
        assertEquals("d", tokens[22].overKind);
        assertEquals(3, tokens[22].span().start().line());
        assertEquals(11, tokens[22].span().start().column());
        assertEquals(22, tokens[22].span().start().offset());
        assertEquals(4, tokens[22].span().end().line());
        assertEquals(1, tokens[22].span().end().column());
        assertEquals(22, tokens[22].span().start().offset());

        // [0x3] [ETX] [\u0003]
        assertEquals(
                "Token { Kind[close_book] Lexeme[0x3] Span[{4:1 23}:{4:2 24}] }",
                tokens[23].toString());
        assertEquals("ETX", tokens[23].kind().toString());
        assertEquals("close_book", tokens[23].overKind);
        assertEquals(4, tokens[23].span().start().line());
        assertEquals(1, tokens[23].span().start().column());
        assertEquals(23, tokens[23].span().start().offset());
        assertEquals(4, tokens[23].span().end().line());
        assertEquals(2, tokens[23].span().end().column());
        assertEquals(23, tokens[23].span().start().offset());
    }
}
