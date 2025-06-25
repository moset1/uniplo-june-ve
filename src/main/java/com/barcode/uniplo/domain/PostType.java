package com.barcode.uniplo.domain;

public enum PostType {
    QNA, FAQ, NOTICE;

    public static PostType from(String type) {
        if (type == null) return null;
        try {
            return PostType.valueOf(type.toUpperCase());

        } catch ( Exception e) {
            return null;
        }
    }
}
