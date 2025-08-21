package org.x96.sys.foundation.cs.lexer;

import org.x96.sys.foundation.buzz.cs.lexer.BuzzLex;
import org.x96.sys.foundation.buzz.cs.lexer.router.serial.BuzzCantSerialize;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.Visitor;
import org.x96.sys.foundation.cs.lexer.visitor.factory.ReflectiveVisitorFactory;
import org.x96.sys.foundation.io.ByteStream;

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
