package com.juno.board.service;


import com.juno.board.dto.ReplyDTO;
import com.juno.board.entity.Board;
import com.juno.board.entity.Reply;

import java.util.List;

public interface ReplyService {

    /**
     * 1. 댓글 등록
     * 2. 특정 게시물의 댓글 리스트
     * 3. 댓글 수정
     * 4. 댓글 삭제
     * 5. entityToDTO
     * 6. dtoToEntity
     */

    Long register(ReplyDTO replyDTO); // 1

    List<ReplyDTO> getList(Long bno); // 2

    void modify(ReplyDTO replyDTO); // 3

    void remove(Long rno); // 4

    default Reply dtoToEntity(ReplyDTO replyDTO) {
        return Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(
                        Board.builder()
                        .bno(replyDTO.getBno())
                        .build()
                )
                .build();
    }

    default ReplyDTO entityToDTO(Reply reply) {
        return ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();
    }

}
