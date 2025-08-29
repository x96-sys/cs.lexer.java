package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.casing.Casing;
import org.x96.sys.lexer.token.Token;

class CasingTest {
    @Test
    void happy() {
        byte[] payload = "{c s}".getBytes();
        // assertEquals(5, payload.length);
        Token[] t = lex(Casing.class, payload);

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
        Token[] tokens = lex(Casing.class, payload);

        assertEquals(5, tokens.length);
        // [0x7B] [LEFT_CURLY_BRACKET] [{]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_CURLY_BRACKET", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", tokens[1].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[1].kind().toString());
        assertEquals("glyph", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("SPACE", tokens[2].kind().toString());
        assertEquals("d", tokens[2].overKind);
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

        // [0x7D] [RIGHT_CURLY_BRACKET] [}]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("RIGHT_CURLY_BRACKET", tokens[4].kind().toString());
        assertNull(tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());
    }

    @Test
    void happy2() {
        byte[] payload = "{[c s]}".getBytes();
        assertEquals(7, payload.length);
        Token[] tokens = lex(Casing.class, payload);
        assertEquals(7, tokens.length);
        // [0x7B] [LEFT_CURLY_BRACKET] [{]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_CURLY_BRACKET", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x5B] [LEFT_SQUARE_BRACKET] [[]
        assertEquals(
                "Token { Kind[LEFT_SQUARE_BRACKET] Lexeme[0x5B] Span[{1:1 1}:{1:2 2}] }",
                tokens[1].toString());
        assertEquals("LEFT_SQUARE_BRACKET", tokens[1].kind().toString());
        assertNull(tokens[1].overKind);
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

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[4].kind().toString());
        assertEquals("glyph", tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x5D] [RIGHT_SQUARE_BRACKET] []]
        assertEquals(
                "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:5 5}:{1:6 6}] }",
                tokens[5].toString());
        assertEquals("RIGHT_SQUARE_BRACKET", tokens[5].kind().toString());
        assertNull(tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x7D] [RIGHT_CURLY_BRACKET] [}]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:6 6}:{1:7 7}] }",
                tokens[6].toString());
        assertEquals("RIGHT_CURLY_BRACKET", tokens[6].kind().toString());
        assertNull(tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());
    }

    @Test
    void happy3() {
        byte[] payload = "{(c | s)}".getBytes();
        assertEquals(9, payload.length);
        Token[] tokens = lex(Casing.class, payload);
        assertEquals(9, tokens.length);
        // [0x7B] [LEFT_CURLY_BRACKET] [{]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("LEFT_CURLY_BRACKET", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x28] [LEFT_PARENTHESIS] [(]
        assertEquals(
                "Token { Kind[LEFT_PARENTHESIS] Lexeme[0x28] Span[{1:1 1}:{1:2 2}] }",
                tokens[1].toString());
        assertEquals("LEFT_PARENTHESIS", tokens[1].kind().toString());
        assertNull(tokens[1].overKind);
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("VERTICAL_LINE", tokens[4].kind().toString());
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

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[glyph] Lexeme[0x73] Span[{1:6 6}:{1:7 7}] }", tokens[6].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[6].kind().toString());
        assertEquals("glyph", tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[7].kind().toString());
        assertNull(tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x7D] [RIGHT_CURLY_BRACKET] [}]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:8 8}:{1:9 9}] }",
                tokens[8].toString());
        assertEquals("RIGHT_CURLY_BRACKET", tokens[8].kind().toString());
        assertNull(tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());
    }
}
