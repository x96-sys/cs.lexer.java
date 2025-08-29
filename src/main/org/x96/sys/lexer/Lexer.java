package org.x96.sys.lexer;

import org.x96.sys.buzz.lexer.BuzzLex;
import org.x96.sys.buzz.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.buzz.router.serial.BuzzCantSerialize;
import org.x96.sys.io.ByteStream;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.Visitor;
import org.x96.sys.lexer.visitor.factory.ReflectiveVisitorFactory;

public record Lexer(Class<? extends Visitor> entry) {

    public Token[] lex(byte[] payload) {
        return build(new Tokenizer(ByteStream.raw(payload)));
    }

    public Token[] lexWrapped(byte[] payload) {
        return build(new Tokenizer(ByteStream.wrapped(payload)));
    }

    private Token[] build(Tokenizer tokenizer) {
        Visitor visitor = ReflectiveVisitorFactory.happens(entry, tokenizer);
        try {
            return visitor.safeVisit();
        } catch (BuzzVisitorMismatch | BuzzCantSerialize e) {
            throw new BuzzLex(tokenizer, e);
        }
    }
}
