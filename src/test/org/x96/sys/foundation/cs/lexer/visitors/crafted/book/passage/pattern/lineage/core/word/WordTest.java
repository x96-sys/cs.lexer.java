package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.word;

import static org.junit.jupiter.api.Assertions.*;
import static org.x96.sys.foundation.cs.lexer.LexerTest.lex;

import org.junit.jupiter.api.Test;
import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.word.Word;
import org.x96.sys.foundation.test.util.Range;
import org.x96.sys.io.ByteStream;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

class WordTest {

    private Range rangeIn() {
        return new Range("'".getBytes()[0], "'".getBytes()[0]);
    }

    private Range checkRange() {
        return new Range(0x0, 0x7E);
    }

    @Test
    void happy() {
        byte[] payload = "'sofi'".getBytes();
        // assertEquals(4, payload.length);
        Token[] t = lex(Word.class, payload);
        // assertEquals(4, t.length);

        //// (') [0x27] [APOSTROPHE]
        // assertEquals("Token { Kind[q] Lexeme[0x27] Span[{0:0 0}:{1:1 1}] }",
        // t[0].toString());
        // assertEquals(Kind.APOSTROPHE, t[0].kind());
        // assertEquals(0x27, t[0].lexeme().b());
        // assertEquals("q", t[0].overKind);
        //
        //// (c) [0x63] [LATIN_SMALL_LETTER_C]
        // assertEquals("Token { Kind[word] Lexeme[0x63] Span[{1:1 1}:{1:2 2}] }",
        // t[1].toString());
        // assertEquals(Kind.LATIN_SMALL_LETTER_C, t[1].kind());
        // assertEquals(0x63, t[1].lexeme().b());
        // assertEquals("word", t[1].overKind);
        //
        //// (s) [0x73] [LATIN_SMALL_LETTER_S]
        // assertEquals("Token { Kind[word] Lexeme[0x73] Span[{1:2 2}:{1:3 3}] }",
        // t[2].toString());
        // assertEquals(Kind.LATIN_SMALL_LETTER_S, t[2].kind());
        // assertEquals(0x73, t[2].lexeme().b());
        // assertEquals("word", t[2].overKind);
        //
        //// (') [0x27] [APOSTROPHE]
        // assertEquals("Token { Kind[q] Lexeme[0x27] Span[{1:3 3}:{1:4 4}] }",
        // t[3].toString());
        // assertEquals(Kind.APOSTROPHE, t[3].kind());
        // assertEquals(0x27, t[3].lexeme().b());
        // assertEquals("q", t[3].overKind);

    }

    @Test
    void happyEmpty() {
        byte[] payload = "''".getBytes();
        assertEquals(2, payload.length);
        Token[] t = lex(Word.class, payload);
        assertEquals(2, t.length);
    }

    @Test
    void happyMultiLine() {
        byte[] payload = "'c\ns''".getBytes();
        assertEquals(6, payload.length);
        Token[] t = lex(Word.class, payload);
        assertEquals(5, t.length);
    }

    @Test
    void unhappyStop() {
        byte[] payload = "'cs".getBytes();
        assertEquals(3, payload.length);
        var e = assertThrows(RuntimeException.class, () -> lex(Word.class, payload));
        assertEquals("fim inesperado", e.getMessage());
    }

    @Test
    void happyStop() {
        byte[] payload = "'cs''".getBytes();
        assertEquals(5, payload.length);
        Token[] t = lex(Word.class, payload);
        assertEquals(4, t.length);
    }

    @Test
    void happyContent() {
        byte[] payload = new byte[] {0x27, 0x20, 0x21, 0x25, 0x26, 0x28, 0x29, 0x7D, 0x7E, 0x27};
        assertEquals(10, payload.length);
        Token[] t = lex(Word.class, payload);
        assertEquals(10, t.length);
    }

    @Test
    void unhappyContent() {
        byte[] payload = new byte[] {0x27, 0x7F, 0x27};
        assertEquals(3, payload.length);
        var e = assertThrows(BuzzLex.class, () -> lex(Word.class, payload));
        assertEquals(
                String.format(
                        """
                        🦕 [0x71]
                        🐝 [BuzzLex]
                        🌵 >\s
                          1 | '%s'
                        1:1 | ^
                          2 |\s
                        """,
                        (char) 0x7F),
                e.getMessage());

        assertEquals(3, payload.length);
        e = assertThrows(BuzzLex.class, () -> lex(Word.class, new byte[] {0x27, 0x19, 0x27}));
        assertEquals(
                String.format(
                        """
                        🦕 [0x71]
                        🐝 [BuzzLex]
                        🌵 >\s
                          1 | '%s'
                        1:1 | ^
                          2 |\s
                        """,
                        (char) 0x19),
                e.getMessage());
    }

    @Test
    void visitOutOfRange() {
        Range check = checkRange();
        for (int i = check.start(); i <= check.end(); i++) {
            if (!rangeIn().contains(i)) {
                assertTrue(new Word(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
                int finalI = i;
                var e =
                        assertThrows(
                                RuntimeException.class,
                                () ->
                                        new Word(
                                                        new Tokenizer(
                                                                ByteStream.raw(
                                                                        new byte[] {
                                                                            (byte) finalI
                                                                        })))
                                                .visit());
                assertEquals(
                        String.format(
                                """
                                🦕 [0xFFF]
                                🐝 [BuzzVisitorMismatch]
                                🌵 > Atual visitante [Word] encontrou token [0x%X] inesperado;
                                   > Tokenizer.pointer[0]
                                   > Tokens Allowed [0x27]
                                  1 | %s
                                1:1 | ^
                                  2 |\s
                                """,
                                i, i == 0xA ? "" : (char) i),
                        e.getMessage().replaceAll("\\u001B\\[[;\\d]*m", ""));
            }
        }
    }

    @Test
    void happyPermission() {
        Range check = checkRange();
        for (int i = check.start(); i <= check.end(); i++) {
            if (rangeIn().contains(i)) {
                assertTrue(
                        new Word(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).allowed());
            } else {
                assertTrue(new Word(new Tokenizer(ByteStream.raw(new byte[] {(byte) i}))).denied());
            }
        }
    }
}
