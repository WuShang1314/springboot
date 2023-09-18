package cn.lzy.mybatiscatalog;

import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("SELECT * FROM t_comment WHERE id=#{id}")

    public Comment finById(Integer id);
    @Update("UPDATE t_comment SET content=#{content} WHERE author =#{auther}")
    public int updateCommentl(Comment comment);
    @Update("UPDATE t_comment SET content=#{content} WHERE id=#{id}")
    public int updateComment(Comment comment);

    //插入
   @Insert("INSERT INTO t_comment(content,author,a_id)"+"values(#{content},#{author},#{aId})")
    public int insertComment(Comment comment);
   //删除
    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    public int deleteComment(Integer id);
}



