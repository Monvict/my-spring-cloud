package com.lotus.mapper;

import com.github.pagehelper.Page;
import com.lotus.dto.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityMapper {
    int deleteByPrimaryKey(String id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String id);

    List<City> selectAll();

    List<City> selectByPage(@Param("pageNum") int pageNum);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}