package org.x96.sys.cs.lexer.visitors.terminals.docOrSpace;

import org.x96.sys.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.cs.lexer.visitors.terminals.doc.Doc;
import org.x96.sys.cs.lexer.visitors.terminals.emptySpace.EmptySpace;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class DocOrEmptySpace extends Doc {
    public DocOrEmptySpace(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() || new EmptySpace(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Switcher switcher = new Switcher();
        switcher.know(EmptySpace.class);
        switcher.know(Doc.class);
        push(switcher.stream(tokenizer));
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public String overKind() {
        return "d";
    }
}
