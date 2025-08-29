package org.x96.sys.foundation.cs.lexer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.x96.sys.cs.lexer.visitors.Book;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.visitor.Visitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LexerTest {

    public static Token[] lex(Class<? extends Visitor> v, byte[] payload) {
        Lexer lexer = new Lexer(v);
        return lexer.lex(payload);
    }

    @Test
    void happy() {
        byte[] payload = "\u0002cs='sc';\u0003".getBytes();
        Lexer lexer = new Lexer(Book.class);
        lexer.lex(payload);
    }

    @Test
    void happyWrapped() throws IOException {
        Path path = Path.of("docs/grammar/zero.cs");
        byte[] bytes = Files.readAllBytes(path);
        Lexer lexer = new Lexer(Book.class);
        Token[] t = lexer.lexWrapped(bytes);
        assertEquals(2221, t.length);
    }
}
