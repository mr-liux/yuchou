package com.youzi.yuchou.module.model.mapper;

import com.youzi.yuchou.module.model.model.GoodsCommentReply;

public interface GoodsCommentReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCommentReply record);

    int insertSelective(GoodsCommentReply record);

    GoodsCommentReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCommentReply record);

    int updateByPrimaryKey(GoodsCommentReply record);
}