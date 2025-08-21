package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.nucleo.rangeHex;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.HyphenMinus;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal.Hexadecimal;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.emptySpace.EmptySpace;

public class RangeHexadecimal extends Hexadecimal {
    public RangeHexadecimal(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();
        Serial serial = new Serial();
        serial.zeroOrMore(EmptySpace.class);
        serial.know(HyphenMinus.class);
        serial.zeroOrMore(EmptySpace.class);
        serial.know(Hexadecimal.class);
        push(serial.stream(tokenizer));
        return stream();
    }
}
