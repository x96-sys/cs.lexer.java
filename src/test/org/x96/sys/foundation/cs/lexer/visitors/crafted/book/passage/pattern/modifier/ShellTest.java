package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.modifier.Shell;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class ShellTest {

    @Test
    void happy() {
        byte[] bytes = "@@".getBytes();
        Lexer lexer = new Lexer(Shell.class);
        Token[] t = lexer.lex(bytes);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[shell] Lexeme[0x40] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x40, t[0].lexeme().b());
        assertEquals(Kind.COMMERCIAL_AT, t[0].kind());
    }
}
