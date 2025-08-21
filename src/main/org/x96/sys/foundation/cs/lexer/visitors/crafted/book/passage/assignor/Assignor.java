package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.assignor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.Equals;

public class Assignor extends Equals {
    public Assignor(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overkind() {
        return "assignor";
    }
}
