package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.modifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.buzz.cs.lexer.BuzzLex;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.io.ByteStream;

class ModifierTest {

    @Test
    void happyGhost() {
        byte[] payload = "__".getBytes();
        Lexer lexer = new Lexer(Modifier.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[ghost] Lexeme[0x5F] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x5F, t[0].lexeme().b());
        assertEquals(Kind.LOW_LINE, t[0].kind());
        assertEquals("ghost", t[0].overKind);
    }

    @Test
    void happyShell() {
        byte[] payload = "@_".getBytes();
        Lexer lexer = new Lexer(Modifier.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[shell] Lexeme[0x40] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x40, t[0].lexeme().b());
        assertEquals(Kind.COMMERCIAL_AT, t[0].kind());
        assertEquals("shell", t[0].overKind);

        for (int i = 0; i < t.length; i++) {
            byte b = t[i].lexeme().b();
            System.out.printf(
                    """
                    Token token = new Token(
                            Kind.%s,
                            new Lexeme((byte) 0x%X),
                            new Span(
                                    new Position(%s, %s, %s),
                                    new Position(%s, %s, %s)));
                    token.overKind("%s");\
                    """,
                    t[i].kind().toString(),
                    b,
                    t[i].span().start().line(),
                    t[i].span().start().column(),
                    t[i].span().start().offset(),
                    t[i].span().end().line(),
                    t[i].span().end().column(),
                    t[i].span().end().offset(),
                    t[i].overKind);
        }
    }

    @Test
    void happyOverKind() {
        Modifier mod = new Modifier(new Tokenizer(ByteStream.raw("@".getBytes())));
        assertEquals("morpho", mod.overkind());
    }

    @Test
    void happyBuzz() {
        byte[] payload = "a".getBytes();
        Lexer lexer = new Lexer(Modifier.class);
        assertThrows(BuzzLex.class, () -> lexer.lex(payload));
    }
}
