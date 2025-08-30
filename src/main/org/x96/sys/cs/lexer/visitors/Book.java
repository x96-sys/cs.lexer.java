package org.x96.sys.cs.lexer.visitors;

import org.x96.sys.cs.lexer.visitors.close_book.CloseBook;
import org.x96.sys.cs.lexer.visitors.open_book.OpenBook;
import org.x96.sys.cs.lexer.visitors.passage.Passage;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;

import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.router.serial.Serial;

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
