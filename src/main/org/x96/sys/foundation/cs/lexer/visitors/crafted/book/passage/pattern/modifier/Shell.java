package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.modifier;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c4.CommercialAt;

public class Shell extends CommercialAt {
    public Shell(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overkind() {
        return "shell";
    }
}
