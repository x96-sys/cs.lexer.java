package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.segment.nucleo.rangeHex;

import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.hexadecimal.Hexadecimal;
import org.x96.sys.cs.lexer.visitors.terminals.emptySpace.EmptySpace;
import org.x96.sys.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c2.HyphenMinus;

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
