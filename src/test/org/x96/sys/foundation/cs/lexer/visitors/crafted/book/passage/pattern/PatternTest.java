package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.cs.lexer.visitors.passage.pattern.Pattern;
import org.x96.sys.io.ByteStream;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

class PatternTest {

    @Test
    void happy() {
        byte[] payloadLineage = "c s;".getBytes();
        byte[] payloadCasing = "{c s}".getBytes();
        assertTrue(new Pattern(new Tokenizer(ByteStream.raw(payloadLineage))).allowed());
        assertTrue(new Pattern(new Tokenizer(ByteStream.raw(payloadCasing))).allowed());

        byte[] payloadLineageGhost = "_c s;".getBytes();
        byte[] payloadCasingShell = "@{c s}".getBytes();
        assertTrue(new Pattern(new Tokenizer(ByteStream.raw(payloadLineageGhost))).allowed());
        assertTrue(new Pattern(new Tokenizer(ByteStream.raw(payloadCasingShell))).allowed());
    }

    @Test
    void happyVisitGhost() {
        byte[] payloadCasingGhost = "_{c s}".getBytes();
        Pattern v = new Pattern(new Tokenizer(ByteStream.raw(payloadCasingGhost)));
        assertTrue(v.allowed());
        Token[] t = v.visit();

        // [0x5F] 95 (_) [LOW_LINE] [ghost]
        assertEquals("Token { Kind[ghost] Lexeme[0x5F] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x5F, t[0].lexeme().b());
        assertEquals(Kind.LOW_LINE, t[0].kind());
        assertEquals("ghost", t[0].overKind);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{1:1 1}:{1:2 2}] }",
                t[1].toString());
        assertEquals(0x7B, t[1].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[1].kind());
        assertNull(t[1].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x63, t[2].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        assertEquals("glyph", t[2].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x20, t[3].lexeme().b());
        assertEquals(Kind.SPACE, t[3].kind());
        assertEquals("d", t[3].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x73, t[4].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[4].kind());
        assertEquals("glyph", t[4].overKind);

        // [0x7D] 125 (}) [RIGHT_CURLY_BRACKET] [RIGHT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[RIGHT_CURLY_BRACKET] Lexeme[0x7D] Span[{1:5 5}:{1:6 6}] }",
                t[5].toString());
        assertEquals(0x7D, t[5].lexeme().b());
        assertEquals(Kind.RIGHT_CURLY_BRACKET, t[5].kind());
        assertNull(t[5].overKind);
    }

    @Test
    void happyVisitShell() {
        byte[] payloadLineageShell = "@c s;".getBytes();
        Pattern v = new Pattern(new Tokenizer(ByteStream.raw(payloadLineageShell)));
        assertTrue(v.allowed());
        Token[] t = v.visit();

        // [0x40] 64 (@) [COMMERCIAL_AT] [shell]
        assertEquals("Token { Kind[shell] Lexeme[0x40] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x40, t[0].lexeme().b());
        assertEquals(Kind.COMMERCIAL_AT, t[0].kind());
        assertEquals("shell", t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("glyph", t[1].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x20, t[2].lexeme().b());
        assertEquals(Kind.SPACE, t[2].kind());
        assertEquals("d", t[2].overKind);

        // [0x73] 115 (s) [LATIN_SMALL_LETTER_S] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x73] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(0x73, t[3].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_S, t[3].kind());
        assertEquals("glyph", t[3].overKind);

        // [0x3B] 59 (;) [SEMICOLON] [SEMICOLON]
        assertEquals(
                "Token { Kind[SEMICOLON] Lexeme[0x3B] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals(0x3B, t[4].lexeme().b());
        assertEquals(Kind.SEMICOLON, t[4].kind());
        assertNull(t[4].overKind);
    }

    @Test
    void happyLineage() {
        byte[] payload = "c s;".getBytes();
        assertEquals(4, payload.length);
        Token[] t = lex(Pattern.class, payload);
        assertEquals(4, t.length);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x63, t[0].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[0].kind());
        assertEquals("glyph", t[0].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x20, t[1].lexeme().b());
        assertEquals(Kind.SPACE, t[1].kind());
        assertEquals("d", t[1].overKind);

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
        assertNull(t[3].overKind);
    }

    @Test
    void happyCasing() {
        byte[] payload = "{c s}".getBytes();
        assertEquals(5, payload.length);
        Token[] t = lex(Pattern.class, payload);
        assertEquals(5, t.length);

        // [0x7B] 123 ({) [LEFT_CURLY_BRACKET] [LEFT_CURLY_BRACKET]
        assertEquals(
                "Token { Kind[LEFT_CURLY_BRACKET] Lexeme[0x7B] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x7B, t[0].lexeme().b());
        assertEquals(Kind.LEFT_CURLY_BRACKET, t[0].kind());
        assertNull(t[0].overKind);

        // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals(0x63, t[1].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        assertEquals("glyph", t[1].overKind);

        // [0x20] 32 ( ) [SPACE] [empty_space]
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals(0x20, t[2].lexeme().b());
        assertEquals(Kind.SPACE, t[2].kind());
        assertEquals("d", t[2].overKind);

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
        assertNull(t[4].overKind);
    }

    @Test
    void happyReturnBuzz() {
        byte[] payload = ">".getBytes();
        assertThrows(BuzzLex.class, () -> lex(Pattern.class, payload));
    }
}
