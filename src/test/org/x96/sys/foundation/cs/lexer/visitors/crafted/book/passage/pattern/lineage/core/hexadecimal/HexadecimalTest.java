package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.x96.sys.foundation.buzz.cs.lexer.BuzzLex;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;

class HexadecimalTest {
  @Test
  void happy() {
    byte[] payload = "0XEF 0xFF".getBytes();
    Lexer lexer = new Lexer(Hexadecimal.class);
    Token[] t = lexer.lex(payload);
    assertEquals(4, t.length);

    // [0x30] 48 (0) [DIGIT_ZERO] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
    assertEquals(0x30, t[0].lexeme().b());
    assertEquals(Kind.DIGIT_ZERO, t[0].kind());
    assertEquals("hex", t[0].overKind);

    // [0x58] 88 (X) [LATIN_CAPITAL_LETTER_X] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x58] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
    assertEquals(0x58, t[1].lexeme().b());
    assertEquals(Kind.LATIN_CAPITAL_LETTER_X, t[1].kind());
    assertEquals("hex", t[1].overKind);

    // [0x45] 69 (E) [LATIN_CAPITAL_LETTER_E] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x45] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
    assertEquals(0x45, t[2].lexeme().b());
    assertEquals(Kind.LATIN_CAPITAL_LETTER_E, t[2].kind());
    assertEquals("hex", t[2].overKind);

    // [0x46] 70 (F) [LATIN_CAPITAL_LETTER_F] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x46] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
    assertEquals(0x46, t[3].lexeme().b());
    assertEquals(Kind.LATIN_CAPITAL_LETTER_F, t[3].kind());
    assertEquals("hex", t[3].overKind);
  }

  @Test
  void happyDigit() {
    byte[] payload = "0x0f 0xFF".getBytes();
    Lexer lexer = new Lexer(Hexadecimal.class);
    Token[] t = lexer.lex(payload);
    assertEquals(4, t.length);
    // [0x30] 48 (0) [DIGIT_ZERO] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{0:0 0}:{1:1 1}] }", t[0].toString());
    assertEquals(0x30, t[0].lexeme().b());
    assertEquals(Kind.DIGIT_ZERO, t[0].kind());
    assertEquals("hex", t[0].overKind);

    // [0x78] 120 (x) [LATIN_SMALL_LETTER_X] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x78] Span[{1:1 1}:{1:2 2}] }", t[1].toString());
    assertEquals(0x78, t[1].lexeme().b());
    assertEquals(Kind.LATIN_SMALL_LETTER_X, t[1].kind());
    assertEquals("hex", t[1].overKind);

    // [0x30] 48 (0) [DIGIT_ZERO] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x30] Span[{1:2 2}:{1:3 3}] }", t[2].toString());
    assertEquals(0x30, t[2].lexeme().b());
    assertEquals(Kind.DIGIT_ZERO, t[2].kind());
    assertEquals("hex", t[2].overKind);

    // [0x66] 102 (f) [LATIN_SMALL_LETTER_F] [hex]
    assertEquals("Token { Kind[hex] Lexeme[0x66] Span[{1:3 3}:{1:4 4}] }", t[3].toString());
    assertEquals(0x66, t[3].lexeme().b());
    assertEquals(Kind.LATIN_SMALL_LETTER_F, t[3].kind());
    assertEquals("hex", t[3].overKind);
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
