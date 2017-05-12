package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCommentPic;

public interface GoodsCommentPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCommentPic record);

    int insertSelective(GoodsCommentPic record);

    GoodsCommentPic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCommentPic record);

    int updateByPrimaryKey(GoodsCommentPic record);
}