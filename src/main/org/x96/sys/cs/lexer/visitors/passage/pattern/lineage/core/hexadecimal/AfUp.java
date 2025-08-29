package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal;

import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.Visitor;

// af_up = [0x41-0x46];
public class AfUp extends Visitor {

    public AfUp(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        if (denied()) {
            throw new RuntimeException(
                    String.format(
                            "token inesperado [0x%X]; faixa esperada eh [0x41] - [0x46]", look()));
        } else {
            rec(overKind());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return (look() >= 0x41 && look() <= 0x46);
    }

    @Override
    public String overKind() {
        return "af_up";
    }
}
