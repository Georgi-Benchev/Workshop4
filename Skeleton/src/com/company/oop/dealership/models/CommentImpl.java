package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.utils.CommentValidation;


public class CommentImpl implements Comment {


    private String comment;
    private final String author;

    public CommentImpl(String comment, String author) {
        setComment(comment);
        this.author = author;
    }

    private void setComment(String comment) {
        CommentValidation.validateCommentLength(comment);
        this.comment = comment;
    }


    @Override
    public String getContent() {
        return this.comment;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {

        String output =         "\n----------\n";
        output += String.format("%s\n" +
                                "User: %s", getContent(), getAuthor());
        output +=               "\n----------";

        return output;
    }
}