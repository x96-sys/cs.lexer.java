package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.doc;

import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.NumberSign;

public class Doc extends NumberSign {
    public Doc(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overKind() {
        return "doc";
    }

    @Override
    public Token[] visit() {
        super.visit();
        follow();
        return stream();
    }

    private void follow() {
        if (tokenizer.ready() && content()) {
            rec();
            follow();
        }
    }

    public boolean content() {
        return switch (kind()) {
            case Kind.ETX, Kind.LF -> false;
            default -> true;
        };
    }
}
