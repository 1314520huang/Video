package com.video.dao;

import com.video.model.Video;
import com.video.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int countByExample(VideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int deleteByExample(VideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int insert(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int insertSelective(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    List<Video> selectByExample(VideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    Video selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Video record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table video
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Video record);
}