package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.assignor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.assignor.Assignor;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class AssignorTest {

    @Test
    void happy() {
        byte[] payload = "==".getBytes();
        Lexer lexer = new Lexer(Assignor.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[assignor] Lexeme[0x3D] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x3D, t[0].lexeme().b());
        assertEquals(Kind.EQUALS, t[0].kind());
    }
}
