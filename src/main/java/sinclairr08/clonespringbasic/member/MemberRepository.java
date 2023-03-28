package sinclairr08.clonespringbasic.member;

public interface MemberRepository {
    void save (Member member);

    Member findById(Long memberId);
}
