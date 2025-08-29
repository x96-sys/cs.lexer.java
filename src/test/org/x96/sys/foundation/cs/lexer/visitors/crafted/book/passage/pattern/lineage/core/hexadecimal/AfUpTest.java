package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal.AfUp;
import org.x96.sys.foundation.test.util.Range;
import org.x96.sys.io.ByteStream;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

class AfUpTest {
    @Test
    void happyStop() {
        byte[] payload = "BA".getBytes();
        Lexer lexer = new Lexer(AfUp.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals("Token { Kind[af_up] Lexeme[0x42] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
        assertEquals(0x42, t[0].lexeme().b());
        assertEquals(Kind.LATIN_CAPITAL_LETTER_B, t[0].kind());
        assertEquals("af_up", t[0].overKind);
    }

    private Range rangeIn() {
        return new Range("A".getBytes()[0], "F".getBytes()[0]);
    }

    private Range checkRange() {
        return new Range(0x0, 0xFF);
    }

    @Test
    void happyVisit() {
        Range check = checkRange();
        for (int i = check.start(); i <= check.end(); i++) {
            if (rangeIn().contains(i)) {
                assertTrue(
                        new AfUp(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).allowed());
                Token[] t = new AfUp(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).visit();
                assertEquals(1, t.length);
            } else {
                assertTrue(new AfUp(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
                int finalI = i;
                var e =
                        assertThrows(
                                RuntimeException.class,
                                () ->
                                        new AfUp(
                                                        new Tokenizer(
                                                                ByteStream.raw(
                                                                        new byte[] {
                                                                            (byte) finalI
                                                                        })))
                                                .visit());
                assertEquals(
                        String.format(
                                "token inesperado [0x%X]; faixa esperada eh [0x41] - [0x46]", i),
                        e.getMessage());
            }
        }
    }

    @Test
    void happyPermission() {
        Range check = checkRange();
        for (int i = check.start(); i <= check.end(); i++) {
            if (rangeIn().contains(i)) {
                assertTrue(
                        new AfUp(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).allowed());
            } else {
                assertTrue(new AfUp(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
            }
        }
    }
}
