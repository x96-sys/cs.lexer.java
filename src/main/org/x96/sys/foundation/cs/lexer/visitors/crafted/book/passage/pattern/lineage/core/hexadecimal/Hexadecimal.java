package org.x96.sys.foundation.cs.lexer.visitors.crafted.book.passage.pattern.lineage.core.hexadecimal;

import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.token.Kind;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.DigitZero;

public class Hexadecimal extends DigitZero {

    public Hexadecimal(Tokenizer tokenizer) {
        super(tokenizer);
    }

    @Override
    public String overKind() {
        return "hex";
    }

    @Override
    public Token[] visit() {
        rec(overKind()); // prefix 0x
        x(); // prefix 0x
        if (!isHexDigit()) {
            String msg =
                    String.format(
                            "token inesperado [0x%X] (%s) durante visita permitida; espera ( 0-9 |"
                                    + " A-F | a-f )",
                            look(), (char) look());
            throw new RuntimeException(msg, new BuzzVisitorMismatch(this, tokenizer));
        }
        follow();
        return stream();
    }

    private void follow() {
        if (tokenizer.ready() && isHexDigit()) {
            rec(overKind());
            follow();
        }
    }

    public boolean isHexDigit() {
        return (new Digit(tokenizer).allowed())
                || // 0-9
                (new AfUp(tokenizer).allowed())
                || // A-F
                new AfLow(tokenizer).allowed(); // a-f
    }

    private void x() {
        if (kind() == Kind.LATIN_SMALL_LETTER_X || kind() == Kind.LATIN_CAPITAL_LETTER_X) {
            rec(overKind());
        } else {
            String msg =
                    String.format(
                            "token inesperado [0x%X] (%s) durante visita permitida; espera ( x | X"
                                    + " )",
                            look(), (char) look());
            throw new RuntimeException(msg, new BuzzVisitorMismatch(this, tokenizer));
        }
    }
}
