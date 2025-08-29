package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal;

import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.Visitor;

// af_low = [0x61-0x66];
public class AfLow extends Visitor {

    public AfLow(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        if (!allowed()) {
            throw new RuntimeException(
                    String.format(
                            "token inesperado [0x%X]; faixa esperada eh [0x61] - [0x66]", look()));
        } else {
            rec();
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return (look() >= 0x61 && look() <= 0x66);
    }

    @Override
    public String overKind() {
        return "af_low";
    }
}
