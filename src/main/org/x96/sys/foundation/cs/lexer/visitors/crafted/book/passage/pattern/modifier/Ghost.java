package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.modifier;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LowLine;

public class Ghost extends LowLine {
    public Ghost(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overkind() {
        return "ghost";
    }
}
