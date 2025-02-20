package com.example.asm1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class news {
    private String id;
    private String title;
    private String content;
    private String img;
    private String Date;
    private String auThor;
    private int view;
    private String cate;
    private boolean home;

    @Override
    public String toString() {
        return "news{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", img='" + img + '\'' +
                ", Date='" + Date + '\'' +
                ", auThor='" + auThor + '\'' +
                ", view=" + view +
                ", cate='" + cate + '\'' +
                ", home=" + home +
                '}';
    }
}
