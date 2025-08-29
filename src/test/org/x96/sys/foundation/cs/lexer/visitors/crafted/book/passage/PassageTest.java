package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.Passage;
import org.x96.sys.lexer.token.Token;

class PassageTest {
    @Test
    void happy() {
        byte[] payload = "c=s;".getBytes();
        assertEquals(4, payload.length);
        Token[] t = lex(Passage.class, payload);
        assertEquals(4, t.length);
    }

    @Test
    void happy2() {
        byte[] payload = "c={s}".getBytes();
        assertEquals(5, payload.length);
        Token[] t = lex(Passage.class, payload);
        assertEquals(5, t.length);
    }

    @Test
    void happy3() {
        byte[] payload = "book = { soi d* book_follow+ eoi } # doc and comment ".getBytes();
        assertEquals(53, payload.length);
        Token[] t = lex(Passage.class, payload);
        assertEquals(53, t.length);
    }
}
