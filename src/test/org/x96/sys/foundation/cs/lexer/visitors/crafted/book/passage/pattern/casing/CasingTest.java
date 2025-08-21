package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.StringJoiner;

class CasingTest {
    @Test
    void happy() {
        byte[] payload = "{c s}".getBytes();
        // assertEquals(5, payload.length);
        Token[] t = lex(Casing.class, payload);

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

        // assertEquals(5, t.length);
        // // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        // assertEquals(
        // "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
        // t[0].toString());
        // assertEquals(0x7B, t[0].lexeme().b());
        // assertEquals(Kind.LEFT_CURLY_BRACKET, t[0].kind());
        // assertEquals("LEFT_CURLY_BRACKET", t[0].overKind);
        //
        // // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        // assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }",
        // t[1].toString());
        // assertEquals(0x63, t[1].lexeme().b());
        // assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        // assertEquals("glyph", t[1].overKind);
        //
        // // [0x20] 32 ( ) [SPACE] [empty_space]
        // assertEquals(
        // "Token { Kind[empty_space] Lexeme[0x20] Span[{1:2 2}:{1:3 3}] }",
        // t[2].toString());
        // assertEquals(0x20, t[2].lexeme().b());
        // assertEquals(Kind.SPACE, t[2].kind());
        // assertEquals("empty_space", t[2].overKind);
        //
        // // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        // assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }",
        // t[3].toString());
        // assertEquals(0x73, t[3].lexeme().b());
        // assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        // assertEquals("glyph", t[3].overKind);
        //
        // // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        // assertEquals(
        // "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:4 4}:{1:5 5}] }",
        // t[4].toString());
        // assertEquals(0x7D, t[4].lexeme().b());
        // assertEquals(Kind.RIGHT_CURLY_BRACKET, t[4].kind());
        // assertEquals("RIGHT_CURLY_BRACKET", t[4].overKind);
    }

    @Test
    void happyNaoAceitaQuantificador() {
        byte[] payload = "{c s}?".getBytes();
        assertEquals(6, payload.length);
        Token[] t = lex(Casing.class, payload);
        assertEquals(5, t.length);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7B, t[0].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[0].kind());
        assertEquals("LEFT_CURLY_BRACKET", t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("glyph", t[1].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x20, t[2].lexeme().b());
        assertEquals(Kind.SPACE, t[2].kind());
        assertEquals("empty_space", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:4 4}:{1:5 5}] }",
                t[4].toString());
        assertEquals(0x7D, t[4].lexeme().b());
        assertEquals(Kind.RIGHT_CURLY_BRACKET, t[4].kind());
        assertEquals("RIGHT_CURLY_BRACKET", t[4].overKind);
    }

    @Test
    void happy2() {
        byte[] payload = "{[c s]}".getBytes();
        assertEquals(7, payload.length);
        Token[] t = lex(Casing.class, payload);
        assertEquals(7, t.length);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7B, t[0].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[0].kind());
        assertEquals("LEFT_CURLY_BRACKET", t[0].overKind);

        // [0x5B] 91 ([) [LEFT_SQUARE_BRACKET] [LEFT_SQUARE_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_SQUARE_BRACKET] Lexeme[0x5B] Span[{1:1 1}:{1:2 2}] }",
                t[1].toString());
        assertEquals(0x5B, t[1].lexeme().b());
        assertEquals(Kind.LEFT_SQUARE_BRACKET, t[1].kind());
        assertEquals("LEFT_SQUARE_BRACKET", t[1].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x63, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x20, t[3].lexeme().b());
        assertEquals(Kind.SPACE, t[3].kind());
        assertEquals("empty_space", t[3].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x73, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[4].kind());
        assertEquals("glyph", t[4].overKind);

        // [0x5D] 93 (]) [RIGHT_SQUARE_BRACKET] [RIGHT_SQUARE_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:5 5}:{1:6 6}] }",
                t[5].toString());
        assertEquals(0x5D, t[5].lexeme().b());
        assertEquals(Kind.RIGHT_SQUARE_BRACKET, t[5].kind());
        assertEquals("RIGHT_SQUARE_BRACKET", t[5].overKind);

        // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:6 6}:{1:7 7}] }",
                t[6].toString());
        assertEquals(0x7D, t[6].lexeme().b());
        assertEquals(Kind.RIGHT_CURLY_BRACKET, t[6].kind());
        assertEquals("RIGHT_CURLY_BRACKET", t[6].overKind);
    }

    @Test
    void happy3() {
        byte[] payload = "{(c | s)}".getBytes();
        assertEquals(9, payload.length);
        Token[] t = lex(Casing.class, payload);
        assertEquals(9, t.length);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7B, t[0].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[0].kind());
        assertEquals("LEFT_CURLY_BRACKET", t[0].overKind);

        // [0x28] 40 (() [LEFT_PARENTHESIS] [LEFT_PARENTHESIS]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{1:1 1}:{1:2 2}] }",
                t[1].toString());
        assertEquals(0x28, t[1].lexeme().b());
        assertEquals(Kind.LEFT_PARENTHESIS, t[1].kind());
        assertEquals("LEFT_PARENTHESIS", t[1].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x63, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x20, t[3].lexeme().b());
        assertEquals(Kind.SPACE, t[3].kind());
        assertEquals("empty_space", t[3].overKind);

        // [0x7C] 124 (|) [VERTICAL_LINE] [VERTICAL_LINE]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:4 4}:{1:5 5}] }",
                t[4].toString());
        assertEquals(0x7C, t[4].lexeme().b());
        assertEquals(Kind.VERTICAL_LINE, t[4].kind());
        assertEquals("VERTICAL_LINE", t[4].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals(0x20, t[5].lexeme().b());
        assertEquals(Kind.SPACE, t[5].kind());
        assertEquals("empty_space", t[5].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals(0x73, t[6].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[6].kind());
        assertEquals("glyph", t[6].overKind);

        // [0x29] 41 ()) [RIGHT_PARENTHESIS] [RIGHT_PARENTHESIS]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:7 7}:{1:8 8}] }",
                t[7].toString());
        assertEquals(0x29, t[7].lexeme().b());
        assertEquals(Kind.RIGHT_PARENTHESIS, t[7].kind());
        assertEquals("RIGHT_PARENTHESIS", t[7].overKind);

        // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:8 8}:{1:9 9}] }",
                t[8].toString());
        assertEquals(0x7D, t[8].lexeme().b());
        assertEquals(Kind.RIGHT_CURLY_BRACKET, t[8].kind());
        assertEquals("RIGHT_CURLY_BRACKET", t[8].overKind);
    }
}
