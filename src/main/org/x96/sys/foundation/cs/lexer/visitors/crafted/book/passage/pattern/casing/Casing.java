package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.LeftCurlyBracket;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.RightCurlyBracket;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.Cored;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

public class Casing extends LeftCurlyBracket {
    public Casing(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();

        Serial serial = new Serial();
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.oneOrMore(Cored.class);
        serial.know(RightCurlyBracket.class);

        push(serial.stream(tokenizer));

        return stream();
    }
}
