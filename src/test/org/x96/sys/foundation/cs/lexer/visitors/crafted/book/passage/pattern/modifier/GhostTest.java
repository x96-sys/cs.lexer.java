package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.modifier.Ghost;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class GhostTest {

    @Test
    void happy() {
        byte[] bytes = "__".getBytes();
        Lexer lexer = new Lexer(Ghost.class);
        Token[] t = lexer.lex(bytes);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[ghost] Lexeme[0x5F] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x5F, t[0].lexeme().b());
        assertEquals(Kind.LOW_LINE, t[0].kind());
    }
}
