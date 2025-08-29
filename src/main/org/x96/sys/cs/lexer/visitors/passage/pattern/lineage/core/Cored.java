package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core;

import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

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
