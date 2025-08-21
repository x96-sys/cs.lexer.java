package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.open_book;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Etx;

public class CloseBook extends Etx {
    public CloseBook(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overkind() {
        return "close_book";
    }
}
