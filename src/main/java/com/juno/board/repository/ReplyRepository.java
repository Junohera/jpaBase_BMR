package com.juno.board.repository;
import com.juno.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.juno.board.entity.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query("delete from Reply r where r.board.bno =:bno ")
    void deleteByBno(Long bno);

    // 게시물로 댓글 목록 가져오기
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
