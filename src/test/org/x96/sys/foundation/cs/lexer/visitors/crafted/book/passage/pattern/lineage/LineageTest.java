package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.StringJoiner;

class LineageTest {
    @Test
    void happy() {
        byte[] payload = "c s;".getBytes();
        assertEquals(4, payload.length);
        Token[] t = lex(Lineage.class, payload);
        assertEquals(4, t.length);

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

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x63, t[0].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[0].kind());
        assertEquals("glyph", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x73, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x3B] 59 (;) [SEMICOLON] [SEMICOLON]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x3B, t[3].lexeme().b());
        assertEquals(Kind.SEMICOLON, t[3].kind());
        assertEquals("SEMICOLON", t[3].overKind);
    }

    @Test
    void happyStop() {
        byte[] payload = "c s; start_of_another_rule = ...".getBytes();
        assertEquals(32, payload.length);
        Token[] t = lex(Lineage.class, payload);
        assertEquals(4, t.length);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x63, t[0].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[0].kind());
        assertEquals("glyph", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("empty_space", t[1].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x73, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x3B] 59 (;) [SEMICOLON] [SEMICOLON]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x3B, t[3].lexeme().b());
        assertEquals(Kind.SEMICOLON, t[3].kind());
        assertEquals("SEMICOLON", t[3].overKind);
    }
}
