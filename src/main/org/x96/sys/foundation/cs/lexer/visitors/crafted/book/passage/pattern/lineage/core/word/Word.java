package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.word;

import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.Apostrophe;

public class Word extends Apostrophe {
    public Word(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        mark();
        content();
        mark();
        return stream();
    }

    private void content() {
        if (tokenizer.ready() && isContent()) {
            rec();
            content();
        }
    }

    private boolean isContent() {
        return (look() == 0xA || look() >= 0x20 && look() <= 0x26)
                || (look() >= 0x28 && look() <= 0x7E);
    }

    private void mark() {
        if (!tokenizer.ready()) {
            throw new RuntimeException("fim inesperado");
        }
        if (!allowed()) {
            throw new BuzzVisitorMismatch(this, this.tokenizer);
        } else {
            rec("q");
        }
    }

    @Override
    public String overkind() {
        return "word";
    }
}
