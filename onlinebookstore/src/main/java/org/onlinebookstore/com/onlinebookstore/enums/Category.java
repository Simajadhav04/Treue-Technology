package org.onlinebookstore.com.onlinebookstore.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Category {
    TECHNICAL("Technical"), NOVELS("Novels"), MYSTERY("Mystery"),CRIME("Crime"),THRILLER("Thriller"),
    HISTORY("History"),LAW("Law"),SCHOOLBOOK("Schoolbook");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    //****** Reverse Lookup ************//

    public static Optional<Category> get(String value) {
        return Arrays.stream(Category.values())
                .filter(env -> env.value.equals(value))
                .findFirst();
    }
}
