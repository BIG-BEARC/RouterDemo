package com.example.routerdemo.common;

/**
 * @Description 通过 url 跳转，不能加入 Parcelable
 * @Author chuxiong
 * @Time 2021/6/15 2:07 PM
 */
public class Score {

    /**
     * score
     */
    private String score;
    /**
     * rank
     */
    private String rank;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score='" + score + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
