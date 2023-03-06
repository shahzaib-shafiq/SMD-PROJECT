package com.example.bscs_sec_a_batch_20.CardViewExample;

public class My_Model {
public String name;
public int downloadCount;
public int thumbnail;

    public My_Model(String name, int downloadCount, int thumbnail) {
        this.name = name;
        this.downloadCount = downloadCount;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
