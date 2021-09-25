package com.example.newsjavaMvvm.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class PostModel implements Parcelable {

    public static final Creator<PostModel> CREATOR = new Creator<PostModel>() {
        @Override
        public PostModel createFromParcel(Parcel in) {
            return new PostModel(in);
        }

        @Override
        public PostModel[] newArray(int size) {
            return new PostModel[size];
        }
    };
    /**
     * ID : 2893793
     * Title : علماء يدعون لانهمار الدموع عند الرغبة بالبكاء
     * Img : img/XLarge/original/2019/7/24/27d66e0c-ebda-4ae9-bf5a-3001fc42ce9dأقوال_عن_الدموع.jpg
     * SectionTitle : مرأة ومنوعات
     * SourceID : 344
     * SourceTitle : إن بي إن لبنان
     * TimeStamp : 1563978176
     * IsSelectedFavorite : false
     * IsSelectedReadLater : false
     * FormatedDate : الأربعاء، 24 يوليه 2019 02:22 م
     * Ratio : 2.1
     */

    private int ID;
    private String Title;
    private String Img;
    private String SectionTitle;
    private int SourceID;
    private String SourceTitle;
    private int TimeStamp;
    private boolean IsSelectedFavorite;
    private boolean IsSelectedReadLater;
    private String FormatedDate;
    private String Ratio;
    private int Type;

    public PostModel(Parcel in) {
        ID = in.readInt();
        Title = in.readString();
        Img = in.readString();
        SectionTitle = in.readString();
        SourceID = in.readInt();
        SourceTitle = in.readString();
        TimeStamp = in.readInt();
        IsSelectedFavorite = in.readByte() != 0;
        IsSelectedReadLater = in.readByte() != 0;
        FormatedDate = in.readString();
        Ratio = in.readString();
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    public String getSectionTitle() {
        return SectionTitle;
    }

    public void setSectionTitle(String SectionTitle) {
        this.SectionTitle = SectionTitle;
    }

    public int getSourceID() {
        return SourceID;
    }

    public void setSourceID(int SourceID) {
        this.SourceID = SourceID;
    }

    public String getSourceTitle() {
        return SourceTitle;
    }

    public void setSourceTitle(String SourceTitle) {
        this.SourceTitle = SourceTitle;
    }

    public int getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(int TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public boolean isIsSelectedFavorite() {
        return IsSelectedFavorite;
    }

    public void setIsSelectedFavorite(boolean IsSelectedFavorite) {
        this.IsSelectedFavorite = IsSelectedFavorite;
    }

    public boolean isIsSelectedReadLater() {
        return IsSelectedReadLater;
    }

    public void setIsSelectedReadLater(boolean IsSelectedReadLater) {
        this.IsSelectedReadLater = IsSelectedReadLater;
    }

    public String getFormatedDate() {
        return FormatedDate;
    }

    public void setFormatedDate(String FormatedDate) {
        this.FormatedDate = FormatedDate;
    }

    public String getRatio() {
        return Ratio;
    }

    public void setRatio(String Ratio) {
        this.Ratio = Ratio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeString(Title);
        parcel.writeString(Img);
        parcel.writeString(SectionTitle);
        parcel.writeInt(SourceID);
        parcel.writeString(SourceTitle);
        parcel.writeInt(TimeStamp);
        parcel.writeByte((byte) (IsSelectedFavorite ? 1 : 0));
        parcel.writeByte((byte) (IsSelectedReadLater ? 1 : 0));
        parcel.writeString(FormatedDate);
        parcel.writeString(Ratio);
    }
}