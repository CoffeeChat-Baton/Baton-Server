/*
 Education & Major 초기화 SQL
 */

 -- 1. 기존 테이블 (존재하면) 삭제
DROP TABLE IF EXISTS major;
DROP TABLE IF EXISTS education;

-- 2. 학력 (Education) 테이블 생성
CREATE TABLE education (
    id BIGINT PRIMARY KEY,
    education_name VARCHAR(255) NOT NULL UNIQUE COMMENT '학력 이름'
);

-- 3. 전공 (Major) 테이블 생성
CREATE TABLE major (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    major_name VARCHAR(255) NOT NULL COMMENT '전공 이름',
    education_id BIGINT NULL COMMENT '학력 ID (FK)',
    FOREIGN KEY (education_id) REFERENCES education(id) ON DELETE SET NULL
);

-- 4. 학력 (Education) 데이터 삽입
INSERT INTO education (id, education_name) VALUES (1, 'MBA');
INSERT INTO education (id, education_name) VALUES (2, '학사');
INSERT INTO education (id, education_name) VALUES (3,'석사');
INSERT INTO education (id, education_name) VALUES (4, '박사');
INSERT INTO education (id, education_name) VALUES (5, '기타');

-- 5. 전공 (Major) 데이터 삽입
INSERT INTO major (education_id, major_name) VALUES (1, '해외MBA');
INSERT INTO major (education_id, major_name) VALUES (1, '국내MBA');
INSERT INTO major (education_id, major_name) VALUES (1, '해외EMBA');
INSERT INTO major (education_id, major_name) VALUES (1, '국내EMBA');
INSERT INTO major (education_id, major_name) VALUES (1, 'MIM');
INSERT INTO major (education_id, major_name) VALUES (1, '기타');

INSERT INTO major (education_id, major_name) VALUES (2, '데이터사이언스');
INSERT INTO major (education_id, major_name) VALUES (2, 'HCI');
INSERT INTO major (education_id, major_name) VALUES (2, '컴퓨터공학');
INSERT INTO major (education_id, major_name) VALUES (2, '미술/디자인');
INSERT INTO major (education_id, major_name) VALUES (2, '심리/상담');
INSERT INTO major (education_id, major_name) VALUES (2, '경영');
INSERT INTO major (education_id, major_name) VALUES (2, '금융/경제');
INSERT INTO major (education_id, major_name) VALUES (2, '국제/정치');
INSERT INTO major (education_id, major_name) VALUES (2, '행정');
INSERT INTO major (education_id, major_name) VALUES (2, '로스쿨');
INSERT INTO major (education_id, major_name) VALUES (2, '법학');
INSERT INTO major (education_id, major_name) VALUES (2, '건축');
INSERT INTO major (education_id, major_name) VALUES (2, '환경');
INSERT INTO major (education_id, major_name) VALUES (2, '교육');
INSERT INTO major (education_id, major_name) VALUES (2, '인문계열');
INSERT INTO major (education_id, major_name) VALUES (2, '공학계열');
INSERT INTO major (education_id, major_name) VALUES (2, '사회계열');
INSERT INTO major (education_id, major_name) VALUES (2, '간호/보건');
INSERT INTO major (education_id, major_name) VALUES (2, '의학/약학');
INSERT INTO major (education_id, major_name) VALUES (2, '통계');
INSERT INTO major (education_id, major_name) VALUES (2, '미디어/커뮤니케이션');
INSERT INTO major (education_id, major_name) VALUES (2, '무역/통상');
INSERT INTO major (education_id, major_name) VALUES (2, '자연계열');
INSERT INTO major (education_id, major_name) VALUES (2, '연극/영화');
INSERT INTO major (education_id, major_name) VALUES (2, 'IT/정보시스템');
INSERT INTO major (education_id, major_name) VALUES (2, '경찰/군사');
INSERT INTO major (education_id, major_name) VALUES (2, '어문/어학계열');
INSERT INTO major (education_id, major_name) VALUES (2, '음악');
INSERT INTO major (education_id, major_name) VALUES (2, '스포츠/레저');
INSERT INTO major (education_id, major_name) VALUES (2, '기타');

INSERT INTO major (education_id, major_name) VALUES (3, '데이터사이언스');
INSERT INTO major (education_id, major_name) VALUES (3, 'HCI');
INSERT INTO major (education_id, major_name) VALUES (3, '컴퓨터공학');
INSERT INTO major (education_id, major_name) VALUES (3, '미술/디자인');
INSERT INTO major (education_id, major_name) VALUES (3, '심리/상담');
INSERT INTO major (education_id, major_name) VALUES (3, '경영');
INSERT INTO major (education_id, major_name) VALUES (3, '금융/경제');
INSERT INTO major (education_id, major_name) VALUES (3, '국제/정치');
INSERT INTO major (education_id, major_name) VALUES (3, '행정');
INSERT INTO major (education_id, major_name) VALUES (3, '로스쿨');
INSERT INTO major (education_id, major_name) VALUES (3, '법학');
INSERT INTO major (education_id, major_name) VALUES (3, '건축');
INSERT INTO major (education_id, major_name) VALUES (3, '환경');
INSERT INTO major (education_id, major_name) VALUES (3, '교육');
INSERT INTO major (education_id, major_name) VALUES (3, '인문계열');
INSERT INTO major (education_id, major_name) VALUES (3, '공학계열');
INSERT INTO major (education_id, major_name) VALUES (3, '사회계열');
INSERT INTO major (education_id, major_name) VALUES (3, '간호/보건');
INSERT INTO major (education_id, major_name) VALUES (3, '의학/약학');
INSERT INTO major (education_id, major_name) VALUES (3, '통계');
INSERT INTO major (education_id, major_name) VALUES (3, '미디어/커뮤니케이션');
INSERT INTO major (education_id, major_name) VALUES (3, '무역/통상');
INSERT INTO major (education_id, major_name) VALUES (3, '자연계열');
INSERT INTO major (education_id, major_name) VALUES (3, '연극/영화');
INSERT INTO major (education_id, major_name) VALUES (3, 'IT/정보시스템');
INSERT INTO major (education_id, major_name) VALUES (3, '경찰/군사');
INSERT INTO major (education_id, major_name) VALUES (3, '어문/어학계열');
INSERT INTO major (education_id, major_name) VALUES (3, '음악');
INSERT INTO major (education_id, major_name) VALUES (3, '스포츠/레저');
INSERT INTO major (education_id, major_name) VALUES (3, '기타');

INSERT INTO major (education_id, major_name) VALUES (4, '데이터사이언스');
INSERT INTO major (education_id, major_name) VALUES (4, 'HCI');
INSERT INTO major (education_id, major_name) VALUES (4, '컴퓨터공학');
INSERT INTO major (education_id, major_name) VALUES (4, '미술/디자인');
INSERT INTO major (education_id, major_name) VALUES (4, '심리/상담');
INSERT INTO major (education_id, major_name) VALUES (4, '경영');
INSERT INTO major (education_id, major_name) VALUES (4, '금융/경제');
INSERT INTO major (education_id, major_name) VALUES (4, '국제/정치');
INSERT INTO major (education_id, major_name) VALUES (4, '행정');
INSERT INTO major (education_id, major_name) VALUES (4, '로스쿨');
INSERT INTO major (education_id, major_name) VALUES (4, '법학');
INSERT INTO major (education_id, major_name) VALUES (4, '건축');
INSERT INTO major (education_id, major_name) VALUES (4, '환경');
INSERT INTO major (education_id, major_name) VALUES (4, '교육');
INSERT INTO major (education_id, major_name) VALUES (4, '인문계열');
INSERT INTO major (education_id, major_name) VALUES (4, '공학계열');
INSERT INTO major (education_id, major_name) VALUES (4, '사회계열');
INSERT INTO major (education_id, major_name) VALUES (4, '간호/보건');
INSERT INTO major (education_id, major_name) VALUES (4, '의학/약학');
INSERT INTO major (education_id, major_name) VALUES (4, '통계');
INSERT INTO major (education_id, major_name) VALUES (4, '미디어/커뮤니케이션');
INSERT INTO major (education_id, major_name) VALUES (4, '무역/통상');
INSERT INTO major (education_id, major_name) VALUES (4, '자연계열');
INSERT INTO major (education_id, major_name) VALUES (4, '연극/영화');
INSERT INTO major (education_id, major_name) VALUES (4, 'IT/정보시스템');
INSERT INTO major (education_id, major_name) VALUES (4, '경찰/군사');
INSERT INTO major (education_id, major_name) VALUES (4, '어문/어학계열');
INSERT INTO major (education_id, major_name) VALUES (4, '음악');
INSERT INTO major (education_id, major_name) VALUES (4, '스포츠/레저');
INSERT INTO major (education_id, major_name) VALUES (4, '기타');

INSERT INTO major (education_id, major_name) VALUES (5, '기타');
