package org.x96.sys.cs.lexer.visitors.open_book;

import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c0.Stx;

public class OpenBook extends Stx {
    public OpenBook(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        rec(overKind());
        return stream();
    }

    @Override
    public String overKind() {
        return "open_book";
    }
}
