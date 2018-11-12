package com.video.dao;

import com.video.model.Type;
import com.video.model.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int countByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int deleteByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int insert(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int insertSelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    List<Type> selectByExample(TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    Type selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Type record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Type record);
}