package org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.segment.nucleo;

import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.choices.Choices;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.segment.Segment;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.segment.nucleo.rangeHex.RangeHexadecimal;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.unit.Unit;
import org.x96.sys.cs.lexer.visitors.passage.pattern.lineage.core.word.Word;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.tokenizer.Tokenizer;

public class Nucleo extends RangeHexadecimal {
    public Nucleo(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() // RangeHex
                || new Word(tokenizer).allowed()
                || new Unit(tokenizer).allowed()
                || new Segment(tokenizer).allowed()
                || new Choices(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Switcher switcher = new Switcher();

        switcher.know(RangeHexadecimal.class);
        switcher.know(Word.class);
        switcher.know(Unit.class);
        switcher.know(Segment.class);
        switcher.know(Choices.class);

        return switcher.stream(tokenizer);
    }
}
