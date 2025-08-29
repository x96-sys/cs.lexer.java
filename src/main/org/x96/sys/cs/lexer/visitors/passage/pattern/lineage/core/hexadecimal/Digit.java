package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal;

import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.Visitor;

public class Digit extends Visitor {
    public Digit(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overKind() {
        return "digit";
    }

    @Override
    public boolean allowed() {
        return look() >= 0x30 && look() <= 0x39;
    }
}
