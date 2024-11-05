package com.company.oop.dealership.utils;

import static java.lang.String.format;

public class CommentValidation {

    private static final int CONTENT_LEN_MIN = 3;
    private static final int CONTENT_LEN_MAX = 200;
    private static final String CONTENT_LEN_ERR = format(
            "Content must be between %d and %d characters long!", CONTENT_LEN_MIN, CONTENT_LEN_MAX);

    public static void validateCommentLength(String comment){
        ValidationHelpers.validateIntRange(
                comment.length(), CONTENT_LEN_MIN, CONTENT_LEN_MAX, CONTENT_LEN_ERR);
    }

}
