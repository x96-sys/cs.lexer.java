package org.x96.sys.foundation.test.util;

public record Range(int start, int end) {
    public Range {
        if (start > end) {
            throw new IllegalArgumentException("Início não pode ser maior que o fim");
        }
    }

    public boolean contains(int value) {
        return value >= start && value <= end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
