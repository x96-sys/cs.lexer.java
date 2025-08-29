package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class DocOrEmptySpaceTest {
    @Test
    void happySpace() {
        byte[] payload = " ".getBytes();
        Lexer lexer = new Lexer(DocOrEmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[d] Lexeme[0x20] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x20, t[0].lexeme().b());
        assertEquals(Kind.SPACE, t[0].kind());
        assertEquals("d", t[0].overKind);
    }

    @Test
    void happyDoc() {
        byte[] payload = "#".getBytes();
        Lexer lexer = new Lexer(DocOrEmptySpace.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[d] Lexeme[0x23] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x23, t[0].lexeme().b());
        assertEquals(Kind.NUMBER_SIGN, t[0].kind());
        assertEquals("d", t[0].overKind);
    }
}
