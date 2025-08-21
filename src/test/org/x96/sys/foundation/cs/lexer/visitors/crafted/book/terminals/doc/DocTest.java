package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.doc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Token;

class DocTest {

    @Test
    void happy() {
        byte[] payload = "# doc \n# doc".getBytes();
        Lexer lexer = new Lexer(Doc.class);
        Token[] t = lexer.lex(payload);
        assertEquals(6, t.length);
        assertEquals("Token { Kind[doc] Lexeme[0x23] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals("Token { Kind[doc] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals("Token { Kind[doc] Lexeme[0x64] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals("Token { Kind[doc] Lexeme[0x6F] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals("Token { Kind[doc] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals("Token { Kind[doc] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
    }
}
