package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.doc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.terminals.doc.Doc;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;

class DocTest {

    @Test
    void happy() {
        byte[] payload = "# doc \n# doc".getBytes();
        Lexer lexer = new Lexer(Doc.class);
        Token[] tokens = lexer.lex(payload);
        assertEquals(6, tokens.length);
        // [0x23] [NUMBER_SIGN] [#]
        assertEquals(
                "Token { Kind[NUMBER_SIGN] Lexeme[0x23] Span[{0:0 0}:{1:1 1}] }",
                tokens[0].toString());
        assertEquals("NUMBER_SIGN", tokens[0].kind().toString());
        assertNull(tokens[0].overKind);
        assertEquals(0, tokens[0].span().start().line());
        assertEquals(0, tokens[0].span().start().column());
        assertEquals(0, tokens[0].span().start().offset());
        assertEquals(1, tokens[0].span().end().line());
        assertEquals(1, tokens[0].span().end().column());
        assertEquals(0, tokens[0].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[SPACE] Lexeme[0x20] Span[{1:1 1}:{1:2 2}] }", tokens[1].toString());
        assertEquals("SPACE", tokens[1].kind().toString());
        assertNull(tokens[1].overKind);
        assertEquals(1, tokens[1].span().start().line());
        assertEquals(1, tokens[1].span().start().column());
        assertEquals(1, tokens[1].span().start().offset());
        assertEquals(1, tokens[1].span().end().line());
        assertEquals(2, tokens[1].span().end().column());
        assertEquals(1, tokens[1].span().start().offset());

        // [0x64] [LATIN_SMALL_LETTER_D] [d]
        assertEquals(
                "Token { Kind[LATIN_SMALL_LETTER_D] Lexeme[0x64] Span[{1:2 2}:{1:3 3}] }",
                tokens[2].toString());
        assertEquals("LATIN_SMALL_LETTER_D", tokens[2].kind().toString());
        assertNull(tokens[2].overKind);
        assertEquals(1, tokens[2].span().start().line());
        assertEquals(2, tokens[2].span().start().column());
        assertEquals(2, tokens[2].span().start().offset());
        assertEquals(1, tokens[2].span().end().line());
        assertEquals(3, tokens[2].span().end().column());
        assertEquals(2, tokens[2].span().start().offset());

        // [0x6F] [LATIN_SMALL_LETTER_O] [o]
        assertEquals(
                "Token { Kind[LATIN_SMALL_LETTER_O] Lexeme[0x6F] Span[{1:3 3}:{1:4 4}] }",
                tokens[3].toString());
        assertEquals("LATIN_SMALL_LETTER_O", tokens[3].kind().toString());
        assertNull(tokens[3].overKind);
        assertEquals(1, tokens[3].span().start().line());
        assertEquals(3, tokens[3].span().start().column());
        assertEquals(3, tokens[3].span().start().offset());
        assertEquals(1, tokens[3].span().end().line());
        assertEquals(4, tokens[3].span().end().column());
        assertEquals(3, tokens[3].span().start().offset());

        // [0x63] [LATIN_SMALL_LETTER_C] [c]
        assertEquals(
                "Token { Kind[LATIN_SMALL_LETTER_C] Lexeme[0x63] Span[{1:4 4}:{1:5 5}] }",
                tokens[4].toString());
        assertEquals("LATIN_SMALL_LETTER_C", tokens[4].kind().toString());
        assertNull(tokens[4].overKind);
        assertEquals(1, tokens[4].span().start().line());
        assertEquals(4, tokens[4].span().start().column());
        assertEquals(4, tokens[4].span().start().offset());
        assertEquals(1, tokens[4].span().end().line());
        assertEquals(5, tokens[4].span().end().column());
        assertEquals(4, tokens[4].span().start().offset());

        // [0x20] [SPACE] [ ]
        assertEquals(
                "Token { Kind[SPACE] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }", tokens[5].toString());
        assertEquals("SPACE", tokens[5].kind().toString());
        assertNull(tokens[5].overKind);
        assertEquals(1, tokens[5].span().start().line());
        assertEquals(5, tokens[5].span().start().column());
        assertEquals(5, tokens[5].span().start().offset());
        assertEquals(1, tokens[5].span().end().line());
        assertEquals(6, tokens[5].span().end().column());
        assertEquals(5, tokens[5].span().start().offset());
    }
}
