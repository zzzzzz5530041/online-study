package com.online.edu.web.entity.website;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * banner广告图管理
 * @author
 */
@EqualsAndHashCode(callSuper=false)
public class WebsiteImages implements Serializable{
	private int imageId;
    private String imagesUrl;//图地址
    private String linkAddress;//图连接地址
    private String title;//图标题
    private int typeId;//图片类型ID
    private int seriesNumber;//序列号
    private String previewUrl;//略缩图片地址
    private String color;//背景色

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    private String describe;//描述
    
	
}
