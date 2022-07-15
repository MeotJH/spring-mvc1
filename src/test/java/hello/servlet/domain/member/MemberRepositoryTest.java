package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {
    
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    @DisplayName( "save를 테스트한다.")
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member finaById = memberRepository.finaById(saveMember.getId());
        assertThat(finaById).isEqualTo(saveMember);

    }

    @Test
    @DisplayName( "findAll 테스트한다.")
    void finalAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);
        
        //when
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }



}