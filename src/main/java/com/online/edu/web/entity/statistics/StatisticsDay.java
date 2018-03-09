package com.online.edu.web.entity.statistics;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 *
 */
@EqualsAndHashCode(callSuper = false)
public class StatisticsDay implements Serializable{

    private static final long serialVersionUID = -1667710529821277065L;
    /**
	 * 主键id
	 */
	private Long id;
	/**
	 * 统计日期
	 */
    private java.util.Date statisticsTime;
    /**
     * 登录人数（活跃人数 ）
     */
    private Long loginNum;
    /**
     *  生成时间
     */
    private java.util.Date createTime;
    /**
     * 注册人数
     */
    private Long registeredNum;
    /**
     * 每日播放视频数
     */
    private Long videoViewingNum;
    /**
     * 每日用户数
     */
    private Long dailyUserNumber;
    /**
     * 每日课程数
     */
    private Long dailyCourseNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public Long getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(Long loginNum) {
        this.loginNum = loginNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getRegisteredNum() {
        return registeredNum;
    }

    public void setRegisteredNum(Long registeredNum) {
        this.registeredNum = registeredNum;
    }

    public Long getVideoViewingNum() {
        return videoViewingNum;
    }

    public void setVideoViewingNum(Long videoViewingNum) {
        this.videoViewingNum = videoViewingNum;
    }

    public Long getDailyUserNumber() {
        return dailyUserNumber;
    }

    public void setDailyUserNumber(Long dailyUserNumber) {
        this.dailyUserNumber = dailyUserNumber;
    }

    public Long getDailyCourseNumber() {
        return dailyCourseNumber;
    }

    public void setDailyCourseNumber(Long dailyCourseNumber) {
        this.dailyCourseNumber = dailyCourseNumber;
    }
}
