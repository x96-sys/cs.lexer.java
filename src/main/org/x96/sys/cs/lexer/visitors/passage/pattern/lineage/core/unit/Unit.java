package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.unit;

import org.x96.sys.cs.lexer.visitors.passage.glyph.Glyph;
import org.x96.sys.cs.lexer.visitors.passage.pattern.casing.Quantifier;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class Unit extends Inhibitor {
    public Unit(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() || new Glyph(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.zeroOrOne(Inhibitor.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.one(Glyph.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.zeroOrOne(Quantifier.class);
        return serial.stream(tokenizer);
    }
}
