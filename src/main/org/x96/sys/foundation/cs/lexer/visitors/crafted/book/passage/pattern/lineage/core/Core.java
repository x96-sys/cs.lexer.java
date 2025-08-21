package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core;

import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.choices.Choices;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal.Hexadecimal;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.segment.Segment;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.unit.Unit;
import org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.word.Word;

public class Core extends Hexadecimal {
    public Core(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public boolean allowed() {
        return super.allowed() // Hex
                || new Word(tokenizer).allowed()
                || new Unit(tokenizer).allowed()
                || new Segment(tokenizer).allowed()
                || new Choices(tokenizer).allowed();
    }

    @Override
    public Token[] visit() {
        Switcher switcher = new Switcher();

        switcher.know(Word.class);
        switcher.know(Hexadecimal.class);
        switcher.know(Unit.class);
        switcher.know(Segment.class);
        switcher.know(Choices.class);

        return switcher.stream(tokenizer);
    }
}
