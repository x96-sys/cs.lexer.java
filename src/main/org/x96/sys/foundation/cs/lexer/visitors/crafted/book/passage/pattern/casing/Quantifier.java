package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing;

import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.QuestionMark;

public class Quantifier extends QuestionMark {
    public Quantifier(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() || kind() == Kind.ASTERISK || kind() == Kind.PLUS;
    }

    @Override
    public String overkind() {
        return "quantifier";
    }
}
