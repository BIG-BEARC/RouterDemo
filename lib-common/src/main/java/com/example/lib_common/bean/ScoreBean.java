package com.example.lib_common.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Description
 * @Author chuxiong
 * @Time 2021/6/8 10:50 AM
 */

public class ScoreBean implements Parcelable {

    public ScoreBean(String score, String rank) {
        this.score = score;
        this.rank = rank;
    }

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
        return "ScoreBean{" +
                "score='" + score + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.score);
        dest.writeString(this.rank);
    }

    public void readFromParcel(Parcel source) {
        this.score = source.readString();
        this.rank = source.readString();
    }

    protected ScoreBean(Parcel in) {
        this.score = in.readString();
        this.rank = in.readString();
    }

    public static final Creator<ScoreBean> CREATOR = new Creator<ScoreBean>() {
        @Override
        public ScoreBean createFromParcel(Parcel source) {
            return new ScoreBean(source);
        }

        @Override
        public ScoreBean[] newArray(int size) {
            return new ScoreBean[size];
        }
    };
}
