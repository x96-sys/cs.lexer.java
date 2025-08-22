package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace;

import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.doc.Doc;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.emptySpace.EmptySpace;

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
        setMod(new Shell(0x40));
        return stream();
    }

    @Override
    public String overKind() {
        return "d";
    }
}
