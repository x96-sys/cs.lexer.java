package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.nucleo.rangeHex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.segment.nucleo.rangeHex.RangeHexadecimal;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;

class RangeHexadecimalTest {

    @Test
    void happy() {
        byte[] payload = "0xEF-0xFF[".getBytes();
        Lexer lexer = new Lexer(RangeHexadecimal.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(9, tokens.length);
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

        // [0x2D] [HYPHEN_MINUS] [-]
        assertEquals(
                "Token { Kind[HYPHEN_MINUS] Lexeme[0x2D] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("HYPHEN_MINUS", tokens[4].kind().toString());
        assertNull(tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x30] [DIGIT_ZERO] [0]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x30] Span[{1:5 5}:{1:6 6}] }",
                tokens[5].toString());
        assertEquals("DIGIT_ZERO", tokens[5].kind().toString());
        assertEquals("hexadecimal", tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());

        // [0x78] [LATIN_SMALL_LETTER_X] [x]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x78] Span[{1:6 6}:{1:7 7}] }",
                tokens[6].toString());
        assertEquals("LATIN_SMALL_LETTER_X", tokens[6].kind().toString());
        assertEquals("hexadecimal", tokens[6].overKind);
        assertEquals(1, tokens[6].span().start().line());
        assertEquals(6, tokens[6].span().start().column());
        assertEquals(6, tokens[6].span().start().offset());
        assertEquals(1, tokens[6].span().end().line());
        assertEquals(7, tokens[6].span().end().column());
        assertEquals(6, tokens[6].span().start().offset());

        // [0x46] [LATIN_CAPITAL_LETTER_F] [F]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x46] Span[{1:7 7}:{1:8 8}] }",
                tokens[7].toString());
        assertEquals("LATIN_CAPITAL_LETTER_F", tokens[7].kind().toString());
        assertEquals("hexadecimal", tokens[7].overKind);
        assertEquals(1, tokens[7].span().start().line());
        assertEquals(7, tokens[7].span().start().column());
        assertEquals(7, tokens[7].span().start().offset());
        assertEquals(1, tokens[7].span().end().line());
        assertEquals(8, tokens[7].span().end().column());
        assertEquals(7, tokens[7].span().start().offset());

        // [0x46] [LATIN_CAPITAL_LETTER_F] [F]
        assertEquals(
                "Token { Kind[hexadecimal] Lexeme[0x46] Span[{1:8 8}:{1:9 9}] }",
                tokens[8].toString());
        assertEquals("LATIN_CAPITAL_LETTER_F", tokens[8].kind().toString());
        assertEquals("hexadecimal", tokens[8].overKind);
        assertEquals(1, tokens[8].span().start().line());
        assertEquals(8, tokens[8].span().start().column());
        assertEquals(8, tokens[8].span().start().offset());
        assertEquals(1, tokens[8].span().end().line());
        assertEquals(9, tokens[8].span().end().column());
        assertEquals(8, tokens[8].span().start().offset());
    }
}
