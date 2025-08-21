package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

public class Cored extends Core {
    public Cored(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed();
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.know(Core.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        return serial.stream(tokenizer);
    }
}
