package qc.module.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qc.module.demo.dto.student.StudentScoreDto;
import qc.module.demo.entity.Course;
import qc.module.demo.entity.Score;
import qc.module.demo.repository.CourseRepository;
import qc.module.demo.repository.ScoreRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreService {
    private ScoreRepository scoreRepository;

    @Autowired
    public void setScoreRepository(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * 按照学生学号查询成绩
     *
     * @param studentNO 学生学号
     * @return
     */
    public List<StudentScoreDto> getScoreByStudentId(int studentNO) {
        LambdaQueryWrapper<Score> queryWrapper = Wrappers.<Score>lambdaQuery()
                //学生NO查询
                .eq(Score::getStudentNo, studentNO)
                // 按照课程id和成绩升序排列
                .orderByAsc(Score::getCourseNo, Score::getScore);
        //查询结果放入集合中
        List<Score> scoreList = scoreRepository.selectList(queryWrapper);

        //返回查询结果
        List<StudentScoreDto> result = new ArrayList<>();
        for (Score score : scoreList) {
            Course course = courseRepository.selectById(score.getCourseNo());
            StudentScoreDto scoreDto = new StudentScoreDto();
            scoreDto.setNo(course.getNo());
            scoreDto.setName(course.getName());
            scoreDto.setScore(score.getScore());
            result.add(scoreDto);
        }
        return result;
    }


}
