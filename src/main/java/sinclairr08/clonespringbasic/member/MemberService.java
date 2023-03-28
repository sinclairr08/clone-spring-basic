package sinclairr08.clonespringbasic.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
