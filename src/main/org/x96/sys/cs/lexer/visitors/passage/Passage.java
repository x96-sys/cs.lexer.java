package org.x96.sys.cs.lexer.visitors.passage;

import org.x96.sys.cs.lexer.visitors.passage.assignor.Assignor;
import org.x96.sys.cs.lexer.visitors.passage.glyph.Glyph;
import org.x96.sys.cs.lexer.visitors.passage.pattern.Pattern;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class Passage extends Glyph {
    public Passage(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.one(Glyph.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.one(Assignor.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.one(Pattern.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        return serial.stream(tokenizer);
    }
}
