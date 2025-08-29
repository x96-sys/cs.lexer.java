package org.x96.sys.cs.lexer.visitors.passage.pattern;

import org.x96.sys.cs.lexer.visitors.passage.pattern.casing.Casing;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.Lineage;
import org.x96.sys.cs.lexer.visitors.passage.pattern.modifier.Modifier;
import org.x96.sys.cs.lexer.visitors.terminals.docOrSpace.DocOrEmptySpace;
import org.x96.sys.foundation.cs.lexer.router.serial.Serial;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class Pattern extends Modifier {
    public Pattern(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed()
                || new Lineage(tokenizer).allowed()
                || new Casing(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Serial serial = new Serial();
        serial.zeroOrOne(Modifier.class);
        serial.zeroOrMore(DocOrEmptySpace.class);
        push(serial.stream(tokenizer));

        Switcher switcher = new Switcher();
        switcher.know(Lineage.class);
        switcher.know(Casing.class);
        push(switcher.stream(tokenizer));

        return stream();
    }
}
