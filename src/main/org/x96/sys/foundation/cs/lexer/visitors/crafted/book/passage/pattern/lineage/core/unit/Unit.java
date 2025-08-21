package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.unit;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.casing.Quantifier;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

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
