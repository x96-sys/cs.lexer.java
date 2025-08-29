package org.x96.sys.cs.lexer.visitors.passage.pattern.modifier;

import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class Modifier extends Ghost {
    public Modifier(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() || new Shell(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Switcher switcher = new Switcher();
        switcher.know(Ghost.class);
        switcher.know(Shell.class);
        return switcher.stream(tokenizer);
    }

    @Override
    public String overKind() {
        return "morpho";
    }
}
