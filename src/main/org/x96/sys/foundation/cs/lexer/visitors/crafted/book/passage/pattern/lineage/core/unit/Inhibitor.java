package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.unit;

import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.ExclamationMark;

public class Inhibitor extends ExclamationMark {
    public Inhibitor(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        rec(overKind());
        return stream();
    }

    @Override
    public String overKind() {
        return "inhibitor";
    }
}
