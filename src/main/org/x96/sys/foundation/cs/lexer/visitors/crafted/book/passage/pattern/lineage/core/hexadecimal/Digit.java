package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

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
