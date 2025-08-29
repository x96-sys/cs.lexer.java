package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.Cored;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

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
        Token[] tokens = lex(Cored.class, payload);
        assertEquals(5, tokens.length);
        // [0x27] [APOSTROPHE] [']
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{0:0 0}:{1:1 1}] }", tokens[0].toString());
        assertEquals("APOSTROPHE", tokens[0].kind().toString());
        assertEquals("q", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[word] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", tokens[1].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[1].kind().toString());
        assertEquals("word", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x73] [LATIN_SMALL_LETTER_S] [s]
        assertEquals(
                "Token { Kind[word] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_S", tokens[2].kind().toString());
        assertEquals("word", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x27] [APOSTROPHE] [']
        assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:3 3}:{1:4 4}] }", tokens[3].toString());
        assertEquals("APOSTROPHE", tokens[3].kind().toString());
        assertEquals("q", tokens[3].overKind);
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
    void happySpaceBefore() {
        byte[] payload = " cs".getBytes();
        assertEquals(3, payload.length);
        assertThrows(BuzzLex.class, () -> lex(Cored.class, payload));
    }

    @Test
    void happyChoice() {
        byte[] payload = "(c|s) ".getBytes();
        assertEquals(6, payload.length);
        Token[] tokens = lex(Cored.class, payload);

        assertEquals(6, tokens.length);
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("VERTICAL_LINE", tokens[2].kind().toString());
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

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[4].kind().toString());
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
    }

    @Test
    void happyChoiceFollowedByDirt() {
        byte[] payload = "(c|s) (".getBytes();
        assertEquals(7, payload.length);
        Token[] tokens = lex(Cored.class, payload);

        assertEquals(6, tokens.length);
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

        // [0x7C] [VERTICAL_LINE] [|]
        assertEquals(
                "Token { Kind[VERTICAL_LINE] Lexeme[0x7C] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("VERTICAL_LINE", tokens[2].kind().toString());
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

        // [0x29] [RIGHT_PARENTHESIS] [)]
        assertEquals(
                "Token { Kind[RIGHT_PARENTHESIS] Lexeme[0x29] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("RIGHT_PARENTHESIS", tokens[4].kind().toString());
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
    }
}
