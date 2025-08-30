package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage;

import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.Core;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.Cored;
import org.x96.sys.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c3.Semicolon;

public class Lineage extends Core {
    public Lineage(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.oneOrMore(Cored.class);
        serial.one(Semicolon.class);

        return serial.stream(tokenizer);
    }
}
