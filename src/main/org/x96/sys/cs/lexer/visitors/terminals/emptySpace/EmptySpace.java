package org.x96.sys.cs.lexer.visitors.terminals.emptySpace;

import org.x96.sys.lexer.token.Kind;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c2.Space;

public class EmptySpace extends Space {
    public EmptySpace(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        rec(overKind());
        return stream();
    }

    @Override
    public String overKind() {
        return "empty_space";
    }

    @Override
    public boolean allowed() {
        return switch (kind()) {
            case Kind.HT, Kind.LF, Kind.CR, Kind.SPACE -> true;
            default -> false;
        };
    }
}
