package sideproject.coffeechat.domain.mentor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject.coffeechat.domain.member.entity.Member;
import sideproject.coffeechat.domain.member.service.MemberService;
import sideproject.coffeechat.domain.mentor.entity.Bookmark;
import sideproject.coffeechat.domain.mentor.entity.Mentor;
import sideproject.coffeechat.domain.mentor.repository.BookmarkRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberService memberService;
    private final MentorService mentorService;

    public void toggleBookmark(Long mentorId, String username) {
        Member member = memberService.getMemberByUsername(username);
        Mentor mentor = mentorService.findByMentorId(mentorId);

        bookmarkRepository.findByMemberIdAndMentorId(member.getId(), mentorId)
                .ifPresentOrElse(
                        bookmarkRepository::delete,
                        () -> bookmarkRepository.save(
                                new Bookmark(mentor, member)
                        )
                );
    }

}
