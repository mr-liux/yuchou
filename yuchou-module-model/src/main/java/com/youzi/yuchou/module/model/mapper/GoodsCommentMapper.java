package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsComment;

public interface GoodsCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsComment record);

    int insertSelective(GoodsComment record);

    GoodsComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsComment record);

    int updateByPrimaryKey(GoodsComment record);
}