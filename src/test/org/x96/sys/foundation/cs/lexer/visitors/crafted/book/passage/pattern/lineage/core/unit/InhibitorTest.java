package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.unit.Inhibitor;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class InhibitorTest {
    @Test
    void happy() {
        byte[] payload = "!!".getBytes();
        Lexer lexer = new Lexer(Inhibitor.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[inhibitor] Lexeme[0x21] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x21, t[0].lexeme().b());
        assertEquals(Kind.EXCLAMATION_MARK, t[0].kind());
        assertEquals("inhibitor", t[0].overKind);
    }
}
