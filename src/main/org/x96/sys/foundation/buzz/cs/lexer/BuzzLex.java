package org.x96.sys.foundation.buzz.cs.lexer;

import org.x96.sys.foundation.buzz.Buzz;
import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;

public class BuzzLex extends Buzz {
    public static final int CODE = 0x71;

    public BuzzLex(Tokenizer t, Buzz e) {
        super(CODE, BuzzLex.class.getSimpleName(), explain(t), e);
    }

    private static String explain(Tokenizer t) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");

        int l = t.position().line();
        int c = t.position().column();

        String p = String.format("%s:%s", l, c);

        String i = " ".repeat(p.getBytes().length - String.valueOf(l).length());
        String currentLine = String.format("%s%s | %s%n", i, l, t.getLineByNumber(l));
        String nextLine = String.format("%s%s | %s%n", i, l + 1, t.getLineByNumber(l + 1));

        String explain = String.format("%s | %s^%n", p, " ".repeat(Math.max(0, c - 1)));

        sb.append(currentLine);
        sb.append(explain);
        sb.append(nextLine);

        return sb.toString();
    }
}
