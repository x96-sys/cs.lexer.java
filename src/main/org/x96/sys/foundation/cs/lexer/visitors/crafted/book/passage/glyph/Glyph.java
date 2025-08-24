package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.glyph;

import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

public class Glyph extends Visitor {
    public Glyph(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overKind() {
        return "glyph";
    }

    @Override
    public Token[] visit() {
        first();
        follow();
        return stream();
    }

    private void follow() {
        if (tokenizer.ready() && (allowed() || Kind.isLowLine(look()))) {
            rec(overKind());
            follow();
        }
    }

    private void first() {
        rec(overKind());
    }

    @Override
    public boolean allowed() {
        return look() >= 0x41 && look() <= 0x5A || look() >= 0x61 && look() <= 0x7A;
    }
}
