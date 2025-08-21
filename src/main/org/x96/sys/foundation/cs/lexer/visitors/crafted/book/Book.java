package org.x96.sys.foundation.cs.lexer.visitors.crafted.book;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.close_book.OpenBook;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.open_book.CloseBook;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.Passage;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

public class Book extends OpenBook {
    public Book(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();
        Serial serial = new Serial();
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.oneOrMore(Passage.class);
        serial.know(CloseBook.class);
        push(serial.stream(tokenizer));
        return stream();
    }
}
