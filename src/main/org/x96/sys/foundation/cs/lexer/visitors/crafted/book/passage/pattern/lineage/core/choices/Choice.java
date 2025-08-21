package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.VerticalLine;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.Core;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

public class Choice extends VerticalLine {
    public Choice(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();

        Serial serial = new Serial();
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.know(Core.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        push(serial.stream(tokenizer));

        return stream();
    }
}
