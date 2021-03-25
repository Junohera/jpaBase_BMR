package com.juno.board.service;

import com.juno.board.dto.ReplyDTO;
import com.juno.board.entity.Board;
import com.juno.board.entity.Reply;
import com.juno.board.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = dtoToEntity(replyDTO);

        replyRepository.save(reply);

        return reply.getRno();
    }

    @Override
    public List<ReplyDTO> getList(Long bno) {
        List<Reply> result = replyRepository.getRepliesByBoardOrderByRno(Board.builder().bno(bno).build());

        return result.stream().map(this::entityToDTO).collect(Collectors.toList()); // lambda - target::justMethodName
//        return result.stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        replyRepository.save(dtoToEntity(replyDTO));
    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }
}
