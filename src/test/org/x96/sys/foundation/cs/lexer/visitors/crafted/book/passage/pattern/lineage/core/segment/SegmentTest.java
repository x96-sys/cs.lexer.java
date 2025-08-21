package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Token;

import java.util.StringJoiner;

class SegmentTest {
    private Token[] lex(byte[] payload) {
        return new Lexer(Segment.class).lex(payload);
    }

    @Test
    void happy() {
        byte[] payload =
                ("[ " + "( a | 0x61 ) " + "( [( 0x63 | c )] | ([s] | [0x63-0x73]) ) ]").getBytes();
        // assertEquals(7, payload.length);
        Token[] t = lex(payload);
        // assertEquals(6, t.length);

        // // [0x5B] 91 ([) [LEFT_SQUARE_BRACKET] [LEFT_SQUARE_BRACKET]
        // assertEquals(
        // "Token { Kind[LEFT_SQUARE_BRACKET] Lexeme[0x5B] Span[{0:0 0}:{1:1 1}] }",
        // t[0].toString());
        // assertEquals(0x5B, t[0].lexeme().b());
        // assertEquals(Kind.LEFT_SQUARE_BRACKET, t[0].kind());
        // assertEquals("LEFT_SQUARE_BRACKET", t[0].overKind);
        //
        // // [0x21] 33 (!) [EXCLAMATION_MARK] [inhibitor]
        // assertEquals(
        // "Token { Kind[inhibitor] Lexeme[0x21] Span[{1:1 1}:{1:2 2}] }",
        // t[1].toString());
        // assertEquals(0x21, t[1].lexeme().b());
        // assertEquals(Kind.EXCLAMATION_MARK, t[1].kind());
        // assertEquals("inhibitor", t[1].overKind);
        //
        // // [0x63] 99 (c) [LATIN_SMALL_LETTER_C] [glyph]
        // assertEquals("Token { Kind[glyph] Lexeme[0x63] Span[{1:2 2}:{1:3 3}] }",
        // t[2].toString());
        // assertEquals(0x63, t[2].lexeme().b());
        // assertEquals(Kind.LATIN_SMALL_LETTER_C, t[2].kind());
        // assertEquals("glyph", t[2].overKind);
        //
        // // [0x3F] 63 (?) [QUESTION_MARK] [quantifier]
        // assertEquals(
        // "Token { Kind[quantifier] Lexeme[0x3F] Span[{1:3 3}:{1:4 4}] }",
        // t[3].toString());
        // assertEquals(0x3F, t[3].lexeme().b());
        // assertEquals(Kind.QUESTION_MARK, t[3].kind());
        // assertEquals("quantifier", t[3].overKind);
        //
        // // [0x5D] 93 (]) [RIGHT_SQUARE_BRACKET] [RIGHT_SQUARE_BRACKET]
        // assertEquals(
        // "Token { Kind[RIGHT_SQUARE_BRACKET] Lexeme[0x5D] Span[{1:4 4}:{1:5 5}] }",
        // t[4].toString());
        // assertEquals(0x5D, t[4].lexeme().b());
        // assertEquals(Kind.RIGHT_SQUARE_BRACKET, t[4].kind());
        // assertEquals("RIGHT_SQUARE_BRACKET", t[4].overKind);
        //
        // // [0x20] 32 ( ) [SPACE] [empty_space]
        // assertEquals(
        // "Token { Kind[empty_space] Lexeme[0x20] Span[{1:5 5}:{1:6 6}] }",
        // t[5].toString());
        // assertEquals(0x20, t[5].lexeme().b());
        // assertEquals(Kind.SPACE, t[5].kind());
        // assertEquals("empty_space", t[5].overKind);

        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < t.length; i++) {
            byte b = t[i].lexeme().b();
            System.out.printf(
                    """
                    Token t%s = new Token(
                    Kind.%s,
                    new Lexeme((byte) 0x%X),
                    new Span(
                    new Position(%s, %s, %s),
                    new Position(%s, %s, %s)));
                    t%s.overKind("%s");
                    %n\
                    """,
                    i,
                    t[i].kind().toString(),
                    b,
                    t[i].span().start().line(),
                    t[i].span().start().column(),
                    t[i].span().start().offset(),
                    t[i].span().end().line(),
                    t[i].span().end().column(),
                    t[i].span().end().offset(),
                    i,
                    t[i].overKind);
            joiner.add("t" + i);
        }

        System.out.printf("Token[] t = new Token[]{%s};%n", joiner);
    }
}
