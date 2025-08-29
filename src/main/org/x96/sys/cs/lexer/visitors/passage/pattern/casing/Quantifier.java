package org.x96.sys.cs.lexer.visitors.passage.pattern.casing;

import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c3.QuestionMark;

public class Quantifier extends QuestionMark {
    public Quantifier(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return super.allowed() || kind() == Kind.ASTERISK || kind() == Kind.PLUS;
    }

    @Override
    public String overKind() {
        return "quantifier";
    }
}
