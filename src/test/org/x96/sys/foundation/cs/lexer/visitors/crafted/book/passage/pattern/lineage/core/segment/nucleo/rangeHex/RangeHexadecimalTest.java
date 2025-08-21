package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.nucleo.rangeHex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Token;

class RangeHexadecimalTest {

    @Test
    void happy() {
        byte[] payload = "0xEF-0xFF[".getBytes();
        Lexer lexer = new Lexer(RangeHexadecimal.class);
        Token[] t = lexer.lex(payload);
        assertEquals(9, t.length);
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x45] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
        assertEquals(
                "Token { Kind[HYPHEN_MINUS] Lexeme[0x2D] Span[{1:4 4}:{1:5 5}] }", t[4].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{1:5 5}:{1:6 6}] }", t[5].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:6 6}:{1:7 7}] }", t[6].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:7 7}:{1:8 8}] }", t[7].toString());
        assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:8 8}:{1:9 9}] }", t[8].toString());

        for (int i = 0; i < t.length; i++) {
            byte b = t[i].lexeme().b();
            System.out.printf(
                    """
                    Token t%s = new Token(
                    Kind.%s,
                    new Lexeme((byte) 0x%X),
                    new Span(
                    new Position(%s, %s, %s),
                    new Position(%s, %s, %s)));
                    t%s.overKind("%s");
                    %n\
                    """,
                    i,
                    t[i].kind().toString(),
                    b,
                    t[i].span().start().line(),
                    t[i].span().start().column(),
                    t[i].span().start().offset(),
                    t[i].span().end().line(),
                    t[i].span().end().column(),
                    t[i].span().end().offset(),
                    i,
                    t[i].overKind);
        }
    }
}
