package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage;

import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.assignor.Assignor;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.glyph.Glyph;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.Pattern;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.terminals.docOrSpace.DocOrEmptySpace;

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
