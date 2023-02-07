package com.example.dolearn.service;

import com.example.dolearn.domain.Board;
import com.example.dolearn.domain.Lecture;
import com.example.dolearn.domain.User;
import com.example.dolearn.domain.UserLecture;
import com.example.dolearn.dto.BoardDto;
import com.example.dolearn.dto.LectureDto;
import com.example.dolearn.dto.UserLectureDto;
import com.example.dolearn.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class LectureServiceTest {
    @InjectMocks
    LectureService lectureService;

    @Mock
    LectureRepository lectureRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    BoardRepository boardRepository;

    @Mock
    UserBoardRepository userBoardRepository;

    @Mock
    UserLectureRepository userLectureRepository;

    @Mock
    MessageRepository messageRepository;

    @DisplayName("강의 확정 테스트")
    @Test
    public void FixUpdateTest() throws Exception{
        BoardDto board = BoardDto.builder().id(1L).uid(1L).tid(1L).content("content").deadline("2023-01-18 14:31:59")
                .startTime("2023-01-18 14:31:59").endTime("2023-01-18 14:31:59")
                .isFixed(0).maxCnt(5).summary("summary").title("title").build();

        User user = User.builder().id(1L).name("test").build();
        Lecture lecture = Lecture.builder()
                .board(board.toEntity()).isDeleted(0).memberCnt(0).build();
        Board updatedBoard = Board.builder().id(1L).title("좋은 강의입니다.").isFixed(1).build();

        when(userRepository.findOneById(any())).thenReturn(Optional.ofNullable(user));
        when(boardRepository.findById(any())).thenReturn(Optional.ofNullable(board.toEntity()));
        when(lectureRepository.save(any())).thenReturn(lecture);
        when(boardRepository.save(any())).thenReturn(updatedBoard);

        LectureDto result = lectureService.updateFix(1L,1L);

        assertEquals(result.getMemberCnt(),lecture.getMemberCnt());
    }

    @DisplayName("강사 id 가져오기 테스트")
    @Test
    public void getInstructorTest(){
        List<UserLecture> userLectureList = new ArrayList<>();

        Lecture lecture = Lecture.builder()
                .id(1L).isDeleted(0).memberCnt(0).build();

        User user = User.builder().id(1L).name("test").build();

        UserLecture userLecture1 = UserLecture.builder()
                .id(1L).user(user).lecture(lecture).memberType("강사").build();

        userLectureList.add(userLecture1);

        when(userLectureRepository.searchLecture(any())).thenReturn(userLectureList);

        Long result = lectureService.getInstructor(lecture.getId());

        assertEquals(result,userLecture1.getUser().getId());
    }

    @DisplayName("강의 신청자 목록 가져오기")
    @Test
    public void getApplicantListTest(){
        List<UserLecture> userLectureList = new ArrayList<>();

        Lecture lecture = Lecture.builder()
                .id(1L).isDeleted(0).memberCnt(0).build();

        UserLecture userLecture1 = UserLecture.builder()
                .lecture(lecture).memberType("학생").build();

        UserLecture userLecture2 = UserLecture.builder()
                .lecture(lecture).memberType("강사").build();

        userLectureList.add(userLecture1);
        userLectureList.add(userLecture2);

        when(userLectureRepository.searchLecture(any())).thenReturn(userLectureList);

        List<UserLecture> result = lectureService.getList(lecture.getId());

        assertEquals(userLectureList.size(),result.size());
    }

    @DisplayName("강의 평가여부 업데이트 테스트")
    @Test
    public void updateLectureMemberTest() throws Exception{
        BoardDto board = BoardDto.builder().id(1L).uid(1L).tid(1L).content("content").deadline("2023-01-18 14:31:59")
                .startTime("2023-01-18 14:31:59").endTime("2023-01-18 14:31:59")
                .isFixed(0).maxCnt(5).summary("summary").title("title").build();

        User user = User.builder().id(1L).name("test").build();

        Lecture lecture = Lecture.builder()
                .id(1L).board(board.toEntity()).isDeleted(0).memberCnt(0).build();

        UserLectureDto userLectureDto = UserLectureDto.builder()
                .id(1L).lid(1L).uid(1L).user(user).lecture(lecture).memberType("학생").evaluateStatus(0).build();

        when(userLectureRepository.searchLectureMember(any(),any())).thenReturn(userLectureDto.toEntity());

        userLectureDto.setEvaluateStatus(1);
        when(userLectureRepository.save(any())).thenReturn(userLectureDto.toEntity());

        assertEquals(1,userLectureDto.getEvaluateStatus());
    }

    @DisplayName("강의 업데이트 테스트")
    @Test
    public void updateLectureTest() throws Exception{
        BoardDto board = BoardDto.builder().id(1L).uid(1L).tid(1L).content("content").deadline("2023-01-18 14:31:59")
                .startTime("2023-01-18 14:31:59").endTime("2023-01-18 14:31:59")
                .isFixed(0).maxCnt(5).summary("summary").title("title").build();

        User user = User.builder().id(1L).name("test").build();

        Lecture lecture = Lecture.builder()
                .id(1L).board(board.toEntity()).isDeleted(0).memberCnt(0).build();

        UserLectureDto userLectureDto = UserLectureDto.builder()
                .id(1L).lid(1L).uid(1L).user(user).lecture(lecture).memberType("학생").evaluateStatus(0).build();

        when(lectureRepository.findById(any())).thenReturn(Optional.ofNullable(lecture));
        when(lectureRepository.save(any())).thenReturn(lecture);

        LectureDto savedLecture = lectureService.updateLecture(lecture.toDto());

        assertEquals(lecture.getId(),savedLecture.getId());
    }

}
