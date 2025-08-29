package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.emptySpace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.terminals.emptySpace.EmptySpace;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class EmptySpaceTest {
    @Test
    void happySpace() {
        byte[] payload = new byte[] {0x20, 0x9};
        Lexer lexer = new Lexer(EmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x20] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x20, t[0].lexeme().b());
        assertEquals(Kind.SPACE, t[0].kind());
        assertEquals("empty_space", t[0].overKind);
    }

    @Test
    void happyHT() {
        byte[] payload = new byte[] {0x9, 0x20};
        Lexer lexer = new Lexer(EmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0x9] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x9, t[0].lexeme().b());
        assertEquals(Kind.HT, t[0].kind());
        assertEquals("empty_space", t[0].overKind);
    }

    @Test
    void happyLF() {
        byte[] payload = new byte[] {0xA, 0xD};
        Lexer lexer = new Lexer(EmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0xA] Span[{0:0 0}:{2:1 1}] }", t[0].toString());
        assertEquals(0xA, t[0].lexeme().b());
        assertEquals(Kind.LF, t[0].kind());
        assertEquals("empty_space", t[0].overKind);
    }

    @Test
    void happyCR() {
        byte[] payload = new byte[] {0xD, 0xA};
        Lexer lexer = new Lexer(EmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[empty_space] Lexeme[0xD] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0xD, t[0].lexeme().b());
        assertEquals(Kind.CR, t[0].kind());
        assertEquals("empty_space", t[0].overKind);
    }
}
