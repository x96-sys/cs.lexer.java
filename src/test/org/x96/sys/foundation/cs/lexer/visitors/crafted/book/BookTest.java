package org.x96.sys.foundation.cs.lexer.visitors.crafted.book;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.StringJoiner;

class BookTest {
    @Test
    void happyChoiceWord() {
        String source =
                """
                \u0002
                c = 0x63;
                s = {0x73}
                \u0003\
                """;
        byte[] payload = source.getBytes();
        assertEquals(24, payload.length);
        Token[] t = lex(Book.class, payload);
        assertEquals(24, t.length);

        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < t.length; i++) {
            byte b = t[i].lexeme().b();
            System.out.printf(
                    """
                    Token t%s = new Token(
                    Kind.%s,
                    new Lexeme((byte) 0x%X),
                    new Span(
                    new Position(%s, %s, %s),
                    new Position(%s, %s, %s)));
                    t%s.overKind("%s");
                    %n\
                    """,
                    i,
                    t[i].kind().toString(),
                    b,
                    t[i].span().start().line(),
                    t[i].span().start().column(),
                    t[i].span().start().offset(),
                    t[i].span().end().line(),
                    t[i].span().end().column(),
                    t[i].span().end().offset(),
                    i,
                    t[i].overKind);
            joiner.add("t" + i);
        }

        System.out.printf("Token[] t = new Token[]{%s};%n", joiner);

        // [0x2] 2 (\u0002) [STX] [open_book]
        assertEquals(
                "Token { Kind[open_book] Lexeme[0x2] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x2, t[0].lexeme().b());
        assertEquals(Kind.STX, t[0].kind());
        assertEquals("open_book", t[0].overKind);

        // [0xA] 10 (\n) [LF] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0xA] Span[{1:1 1}:{2:1 2}] }", t[1].toString());
        assertEquals(0xA, t[1].lexeme().b());
        assertEquals(Kind.LF, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{2:1 2}:{2:2 3}] }", t[2].toString());
        assertEquals(0x63, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{2:2 3}:{2:3 4}] }", t[3].toString());
        assertEquals(0x20, t[3].lexeme().b());
        assertEquals(Kind.SPACE, t[3].kind());
        assertEquals("empty_space", t[3].overKind);

        // [0x3D] 61 (=) [EQUALS] [assignor]
        assertEquals(
                "Token { Kind[assignor] Lexeme[0x3D] Span[{2:3 4}:{2:4 5}] }", t[4].toString());
        assertEquals(0x3D, t[4].lexeme().b());
        assertEquals(Kind.EQUALS, t[4].kind());
        assertEquals("assignor", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{2:4 5}:{2:5 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);

        // [0x30] 48 (0) [DIGIT_ZERO] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{2:5 6}:{2:6 7}] }", t[6].toString());
        assertEquals(0x30, t[6].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[6].kind());
        assertEquals("hex", t[6].overKind);

        // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{2:6 7}:{2:7 8}] }", t[7].toString());
        assertEquals(0x78, t[7].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_X, t[7].kind());
        assertEquals("hex", t[7].overKind);

        // [0x36] 54 (6) [DIGIT_SIX] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x36] Span[{2:7 8}:{2:8 9}] }", t[8].toString());
        assertEquals(0x36, t[8].lexeme().b());
        assertEquals(Kind.DIGIT_SIX, t[8].kind());
        assertEquals("hex", t[8].overKind);

        // [0x33] 51 (3) [DIGIT_THREE] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x33] Span[{2:8 9}:{2:9 10}] }", t[9].toString());
        assertEquals(0x33, t[9].lexeme().b());
        assertEquals(Kind.DIGIT_THREE, t[9].kind());
        assertEquals("hex", t[9].overKind);

        // [0x3B] 59 (;) [SEMICOLON] [SEMICOLON]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{2:9 10}:{2:10 11}] }",
                t[10].toString());
        assertEquals(0x3B, t[10].lexeme().b());
        assertEquals(Kind.SEMICOLON, t[10].kind());
        assertEquals("SEMICOLON", t[10].overKind);

        // [0xA] 10 (\n) [LF] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0xA] Span[{2:10 11}:{3:1 12}] }",
                t[11].toString());
        assertEquals(0xA, t[11].lexeme().b());
        assertEquals(Kind.LF, t[11].kind());
        assertEquals("empty_space", t[11].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{3:1 12}:{3:2 13}] }", t[12].toString());
        assertEquals(0x73, t[12].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[12].kind());
        assertEquals("glyph", t[12].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{3:2 13}:{3:3 14}] }",
                t[13].toString());
        assertEquals(0x20, t[13].lexeme().b());
        assertEquals(Kind.SPACE, t[13].kind());
        assertEquals("empty_space", t[13].overKind);

        // [0x3D] 61 (=) [EQUALS] [assignor]
        assertEquals(
                "Token { Kind[assignor] Lexeme[0x3D] Span[{3:3 14}:{3:4 15}] }", t[14].toString());
        assertEquals(0x3D, t[14].lexeme().b());
        assertEquals(Kind.EQUALS, t[14].kind());
        assertEquals("assignor", t[14].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{3:4 15}:{3:5 16}] }",
                t[15].toString());
        assertEquals(0x20, t[15].lexeme().b());
        assertEquals(Kind.SPACE, t[15].kind());
        assertEquals("empty_space", t[15].overKind);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{3:5 16}:{3:6 17}] }",
                t[16].toString());
        assertEquals(0x7B, t[16].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[16].kind());
        assertEquals("LEFT_CURLY_BRACKET", t[16].overKind);

        // [0x30] 48 (0) [DIGIT_ZERO] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{3:6 17}:{3:7 18}] }", t[17].toString());
        assertEquals(0x30, t[17].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[17].kind());
        assertEquals("hex", t[17].overKind);

        // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{3:7 18}:{3:8 19}] }", t[18].toString());
        assertEquals(0x78, t[18].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_X, t[18].kind());
        assertEquals("hex", t[18].overKind);

        // [0x37] 55 (7) [DIGIT_SEVEN] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x37] Span[{3:8 19}:{3:9 20}] }", t[19].toString());
        assertEquals(0x37, t[19].lexeme().b());
        assertEquals(Kind.DIGIT_SEVEN, t[19].kind());
        assertEquals("hex", t[19].overKind);

        // [0x33] 51 (3) [DIGIT_THREE] [hex]
        assertEquals("Token { Kind[hex] Lexeme[0x33] Span[{3:9 20}:{3:10 21}] }", t[20].toString());
        assertEquals(0x33, t[20].lexeme().b());
        assertEquals(Kind.DIGIT_THREE, t[20].kind());
        assertEquals("hex", t[20].overKind);

        // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{3:10 21}:{3:11 22}] }",
                t[21].toString());
        assertEquals(0x7D, t[21].lexeme().b());
        assertEquals(Kind.RIGHT_CURLY_BRACKET, t[21].kind());
        assertEquals("RIGHT_CURLY_BRACKET", t[21].overKind);

        // [0xA] 10 (\n) [LF] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0xA] Span[{3:11 22}:{4:1 23}] }",
                t[22].toString());
        assertEquals(0xA, t[22].lexeme().b());
        assertEquals(Kind.LF, t[22].kind());
        assertEquals("empty_space", t[22].overKind);

        // [0x3] 3 (\0003) [ETX] [close_book]
        assertEquals(
                "Token { Kind[close_book] Lexeme[0x3] Span[{4:1 23}:{4:2 24}] }", t[23].toString());
        assertEquals(0x3, t[23].lexeme().b());
        assertEquals(Kind.ETX, t[23].kind());
        assertEquals("close_book", t[23].overKind);
    }
}
