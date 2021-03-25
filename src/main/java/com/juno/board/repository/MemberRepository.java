package com.juno.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juno.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
