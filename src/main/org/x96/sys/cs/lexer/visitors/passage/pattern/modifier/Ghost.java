package org.x96.sys.cs.lexer.visitors.passage.pattern.modifier;

import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c5.LowLine;

public class Ghost extends LowLine {
    public Ghost(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        rec(overKind());
        return stream();
    }

    @Override
    public String overKind() {
        return "ghost";
    }
}
