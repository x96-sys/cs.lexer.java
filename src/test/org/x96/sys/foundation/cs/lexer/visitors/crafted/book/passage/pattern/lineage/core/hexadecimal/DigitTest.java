package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal.Digit;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;

class DigitTest {
    @Test
    void happy() {
        byte[] payload = "01".getBytes();
        Lexer lexer = new Lexer(Digit.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(1, tokens.length);
        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[DIGIT_ZERO] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("DIGIT_ZERO", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());
    }
}
