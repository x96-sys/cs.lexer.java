package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.choices;

import org.x96.sys.cs.lexer.visitors.passage.pattern.casing.Quantifier;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.Core;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;
import org.x96.sys.lexer.visitor.entry.terminals.c2.LeftParenthesis;
import org.x96.sys.lexer.visitor.entry.terminals.c2.RightParenthesis;

public class Choices extends LeftParenthesis {

    public Choices(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public Token[] visit() {
        super.visit();
        Serial serial = new Serial();

        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.know(Core.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.oneOrMore(Choice.class);
        serial.know(RightParenthesis.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        serial.zeroOrOne(Quantifier.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        push(serial.stream(tokenizer));
        return stream();
    }
}
