package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.close_book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.open_book.OpenBook;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;

class OpenBookTest {
    @Test
    void happy() {
        byte[] payload = new byte[] {0x2};
        Lexer lexer = new Lexer(OpenBook.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(1, tokens.length);
        Token token = tokens[0];
        assertEquals(
                "Token { Kind[open_book] Lexeme[0x2] Span[{0:0 0}:{1:1 1}] }", token.toString());
    }

    @Test
    void happyJustOne() {
        Token[] t = new Lexer(OpenBook.class).lex(new byte[] {0x2, 0x2});
        assertEquals(1, t.length);
        assertEquals(0b10, t[0].lexeme().b());
        assertEquals(Kind.STX, t[0].kind());
        assertEquals("open_book", t[0].overKind);
    }
}
