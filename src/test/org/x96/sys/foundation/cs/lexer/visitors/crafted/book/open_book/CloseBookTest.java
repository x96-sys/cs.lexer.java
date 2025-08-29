package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.open_book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.close_book.CloseBook;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;

class CloseBookTest {
    @Test
    void happy() {
        byte[] payload = new byte[] {0x3};
        Lexer lexer = new Lexer(CloseBook.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(1, tokens.length);
        assertEquals(
                "Token { Kind[close_book] Lexeme[0x3] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
    }

    @Test
    void happyJustOne() {
        byte[] payload = new byte[] {0x3, 0x3, 0x3};
        Lexer lexer = new Lexer(CloseBook.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(1, tokens.length);
        assertEquals(
                "Token { Kind[close_book] Lexeme[0x3] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
    }
}
