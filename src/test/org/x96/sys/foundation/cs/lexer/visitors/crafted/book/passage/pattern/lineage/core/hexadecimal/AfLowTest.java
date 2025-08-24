package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.io.ByteStream;
import org.x96.sys.foundation.test.util.Range;

class AfLowTest {

    @Test
    void happy() {
        byte[] payload = "ab".getBytes();
        Lexer lexer = new Lexer(AfLow.class);
        Token[] t = lexer.lex(payload);
        assertEquals(1, t.length);
        assertEquals(
                "Token { Kind[LATIN_SMALL_LETTER_A] Lexeme[0x61] Span[{0:0 0}:{1:1 1}] }",
                t[0].toString());
        assertEquals(0x61, t[0].lexeme().b());
        assertEquals(Kind.LATIN_SMALL_LETTER_A, t[0].kind());
        assertNull(t[0].overKind);
    }

    private Range rangeIn() {
        return new Range("a".getBytes()[0], "f".getBytes()[0]);
    }

    private Range checkRange() {
        return new Range(0x0, 0xFF);
    }

    @Test
    void happyRange() {
        Range check = checkRange();
        for (int i = check.start(); i <= check.end(); i++) {
            if (rangeIn().contains(i)) {
                assertTrue(
                        new AfLow(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).allowed());
                Token[] t = new AfLow(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).visit();
                assertEquals(1, t.length);
            } else {
                assertTrue(
                        new AfLow(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
                int finalI = i;
                var e =
                        assertThrows(
                                RuntimeException.class,
                                () ->
                                        new AfLow(
                                                        new Tokenizer(
                                                                ByteStream.raw(
                                                                        new byte[] {
                                                                            (byte) finalI
                                                                        })))
                                                .visit());
                assertEquals(
                        String.format(
                                "token inesperado [0x%X]; faixa esperada eh [0x61] - [0x66]", i),
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
                        new AfLow(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).allowed());
            } else {
                assertTrue(
                        new AfLow(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
            }
        }
    }
}
