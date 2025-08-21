package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LeftSquareBracket;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.RightSquareBracket;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing.Quantifier;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.nucleo.Nucled;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

public class Segment extends LeftSquareBracket {
    public Segment(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();

        Serial serial = new Serial();
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.oneOrMore(Nucled.class);
        serial.know(RightSquareBracket.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.zeroOrOne(Quantifier.class);

        push(serial.stream(tokenizer));

        return stream();
    }
}
