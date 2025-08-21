package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class DigitTest {
    @Test
    void happy() {
        byte[] payload = "01".getBytes();
        Lexer lexer = new Lexer(Digit.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[digit] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x30, t[0].lexeme().b());
        assertEquals(Kind.DIGIT_ZERO, t[0].kind());
        assertEquals("digit", t[0].overKind);
    }
}
