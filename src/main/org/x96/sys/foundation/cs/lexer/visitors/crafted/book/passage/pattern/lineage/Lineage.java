package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.Semicolon;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.Core;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.Cored;

public class Lineage extends Core {
    public Lineage(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.oneOrMore(Cored.class);
        serial.know(Semicolon.class);

        return serial.stream(tokenizer);
    }
}
