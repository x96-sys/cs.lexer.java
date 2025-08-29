package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal.Hexadecimal;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;

class HexadecimalTest {
    @Test
    void happy() {
        byte[] payload = "0XEF 0xFF".getBytes();
        Lexer lexer = new Lexer(Hexadecimal.class);
        Token[] tokens = lexer.lex(payload);

        assertEquals(4, tokens.length);
        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("DIGIT_ZERO", tokens[0].kind().toString());
        assertEquals("hexadecimal", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x58] [LATIN_CAPITAL_LETTER_X] [X]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x58] Span[{1:1 1}:{1:2 2}] }",
                tokens[1].toString());
        assertEquals("LATIN_CAPITAL_LETTER_X", tokens[1].kind().toString());
        assertEquals("hexadecimal", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x45] [LATIN_CAPITAL_LETTER_E] [E]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x45] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("LATIN_CAPITAL_LETTER_E", tokens[2].kind().toString());
        assertEquals("hexadecimal", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x46] [LATIN_CAPITAL_LETTER_F] [F]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x46] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("LATIN_CAPITAL_LETTER_F", tokens[3].kind().toString());
        assertEquals("hexadecimal", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());
    }

    @Test
    void happyDigit() {
        byte[] payload = "0x0f 0xFF".getBytes();
        Lexer lexer = new Lexer(Hexadecimal.class);
        Token[] tokens = lexer.lex(payload);

        assertEquals(4, tokens.length);
        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("DIGIT_ZERO", tokens[0].kind().toString());
        assertEquals("hexadecimal", tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{1:1 1}:{1:2 2}] }",
                tokens[1].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[1].kind().toString());
        assertEquals("hexadecimal", tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("DIGIT_ZERO", tokens[2].kind().toString());
        assertEquals("hexadecimal", tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x66] [LATIN_SMALL_LETTER_F] [f]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x66] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_F", tokens[3].kind().toString());
        assertEquals("hexadecimal", tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());
    }

    @Test
    void happyBuzzFollow() {
        byte[] payload = "0xP".getBytes();
        Lexer lexer = new Lexer(Hexadecimal.class);
        var e = assertThrows(RuntimeException.class, () -> lexer.lex(payload));
        assertEquals(
                "token inesperado [0x50] (P) durante visita permitida; espera ( 0-9 | A-F | a-f )",
                e.getMessage());
        assertNotNull(e.getCause());
        assertEquals(
                """
                🦕 [0xFFF]
                🐝 [BuzzVisitorMismatch]
                🌵 > Atual visitante [Hexadecimal] encontrou token [0x50] inesperado;
                   > Tokenizer.pointer[2]
                   > Tokens Allowed [0x30]
                  1 | 0xP
                1:2 |  ^
                  2 |\s
                """,
                e.getCause().getMessage().replaceAll("\\u001B\\[[;\\d]*m", ""));
    }

    @Test
    void happyBuzz() {
        byte[] payload = "0P".getBytes();
        Lexer lexer = new Lexer(Hexadecimal.class);
        var e = assertThrows(RuntimeException.class, () -> lexer.lex(payload));
        assertEquals(
                "token inesperado [0x50] (P) durante visita permitida; espera ( x | X )",
                e.getMessage());
        assertNotNull(e.getCause());
        assertEquals(
                """
                🦕 [0xFFF]
                🐝 [BuzzVisitorMismatch]
                🌵 > Atual visitante [Hexadecimal] encontrou token [0x50] inesperado;
                   > Tokenizer.pointer[1]
                   > Tokens Allowed [0x30]
                  1 | 0P
                1:1 | ^
                  2 |\s
                """,
                e.getCause().getMessage().replaceAll("\\u001B\\[[;\\d]*m", ""));
    }

    @Test
    void happyReturnNull() {
        byte[] payload = "1".getBytes();
        Lexer lexer = new Lexer(Hexadecimal.class);
        assertThrows(BuzzLex.class, () -> lexer.lex(payload));
    }
}
