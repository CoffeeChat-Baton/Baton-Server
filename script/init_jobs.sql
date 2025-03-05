/*
 Job & SubJob 초기화 SQL
 */

 -- 1. 기존 테이블 (존재하면) 삭제
DROP TABLE IF EXISTS sub_job;
DROP TABLE IF EXISTS job;

-- 2. 직무 (Job) 테이블 생성
CREATE TABLE job (
    id BIGINT PRIMARY KEY,
    job_name VARCHAR(255) NOT NULL UNIQUE COMMENT '직무 이름'
);

-- 3. 세부 직무 (SubJob) 테이블 생성
CREATE TABLE sub_job (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sub_job_name VARCHAR(255) NOT NULL COMMENT '세부 직무 이름',
    job_id BIGINT NULL COMMENT '직무 ID (FK)',
    FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE SET NULL
);

-- 4. 직무 (Job) 데이터 삽입
INSERT INTO job (id, job_name) VALUES (1, '경영·비즈니스');
INSERT INTO job (id, job_name) VALUES (2, '서비스기획·운영');
INSERT INTO job (id, job_name) VALUES (3,'개발');
INSERT INTO job (id, job_name) VALUES (4, '데이터·AI·ML');
INSERT INTO job (id, job_name) VALUES (5, '마케팅·광고·홍보');
INSERT INTO job (id, job_name) VALUES (6, '디자인');
INSERT INTO job (id, job_name) VALUES (7, '미디어·커뮤니케이션');
INSERT INTO job (id, job_name) VALUES (8, '이커머스·리테일');
INSERT INTO job (id, job_name) VALUES (9, '금융·컨설팅·VC');
INSERT INTO job (id, job_name) VALUES (10, '회계·재무');
INSERT INTO job (id, job_name) VALUES (11, '인사·채용·노무');
INSERT INTO job (id, job_name) VALUES (12, '고객·영업');
INSERT INTO job (id, job_name) VALUES (13, '게임기획·개발');
INSERT INTO job (id, job_name) VALUES (14, '물류·구매');
INSERT INTO job (id, job_name) VALUES (15, '의료·제약·바이오');
INSERT INTO job (id, job_name) VALUES (16, '연구·R&D');
INSERT INTO job (id, job_name) VALUES (17, '엔지니어링·설계');
INSERT INTO job (id, job_name) VALUES (18, '생산·품질');
INSERT INTO job (id, job_name) VALUES (19, '교육');
INSERT INTO job (id, job_name) VALUES (20, '법률·특허');
INSERT INTO job (id, job_name) VALUES (21, '공공·복지·환경');
INSERT INTO job (id, job_name) VALUES (22, '기타');

-- 5. 세부 직무 (SubJob) 데이터 삽입
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '경영기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '전략/기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '신규사업/사업개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '해외사업기획/개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '기획조사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '조직관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '사업제휴');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '법인관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, 'CEO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, 'CFO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (1, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, 'PM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, 'PO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, 'CPO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '서비스기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '그로스해킹');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '운영전략/기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '서비스운영');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '애자일코치');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (2, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '백엔드개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '프론트엔드개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'iOS개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '안드로이드개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '풀스택개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'DevOps');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'SRE');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '리서치엔지니어');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'QA');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'DBA/ERP');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'WebRTC');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '웹개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '웹퍼블리셔');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '정보보안');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '임베디드개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '네트워크');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '클라우드');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '그래픽');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, 'CTO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '하드웨어개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '소프트웨어개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (3, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, 'AI/ML');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '데이터분석');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '빅데이터분석');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '데이터사이언스');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '데이터/플랫폼아키텍트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '데이터엔지니어');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, 'MLOps엔지니어');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, 'Linguist');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '통계전문가');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (4, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '브랜드마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '퍼포먼스마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '디지털마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '콘텐츠마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '글로벌마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '스포츠마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '제휴마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, 'CRM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '광고/AE');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '카피라이터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '아트디렉터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, 'PR');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, 'CMO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, 'ATL/BTL');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '프로모션마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '제품/솔루션마케팅');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (5, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '프로덕트디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, 'UX/UI디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, 'GUI디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '웹디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '그래픽디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, 'BI/BX디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '영상/모션디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '제품디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '3D디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '패키지디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '일러스트레이터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '캐릭터디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '건축/공간디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '패션디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '인테리어디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '편집디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '가구디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '아트디렉터/CD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '공공디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (6, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, 'MCN');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, 'PD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '연출');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '촬영/제작');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '영상편집');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '출판/편집');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '에디터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '영화/배급');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '라이센스');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '콘텐츠유통');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '작가/창작자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '기자/아나운서');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '저널리스트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '세미나/포럼기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '공연기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '레코드/음향');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '엔터테이너/MC');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '통번역');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '전시기획/운영');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '아티스트/크리에이터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (7, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '이커머스');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '라이브커머스');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, 'MD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '온라인MD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '패션MD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '식품MD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, 'VMD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '리테일');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '유통전략');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '스토어매니저');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '점포개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '점포관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (8, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, 'IB');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '대체투자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '사모펀드');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, 'M&A');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, 'IPO');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '애널리스트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '펀드매니저');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '전략컨설턴트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '투자심사/VC');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '부동산금융');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '언더라이터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '계리사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '신용/감정평가');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '내부통제/준법');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '트레이딩/퀀트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '자산운용/PB');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, 'Crypto/NFT');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '보험/보증');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '기업금융/여수신');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (9, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '회계');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '재무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '예산/결산');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '세무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '감사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, 'IR');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, 'KICPA공인회계사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, 'AICPA미국회계사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (10, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '인사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '채용');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '테크리크루터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '인재개발/교육');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '평가/보상');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '조직문화');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '노무사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '경영지원/총무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, 'HR컨설턴트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '헤드헌터');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '시설관리/정비');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '비서/사무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (11, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '영업기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '영업관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '해외영업');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '기술영업');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '솔루션컨설턴트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '파트너십');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, 'B2B');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '의료기기영업');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '제약영업');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '금융영업');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, 'CX');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, 'CS');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, 'CSM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '승무원');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '호텔/관광');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '뷰티');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '영양/요리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (12, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임PM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임운영');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임클라이언트개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임서버개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '모바일게임개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '언리얼게임개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임그래픽디자인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '게임아티스트');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (13, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, 'SCM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, 'Logistics');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, '구매/자재');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, 'TradeCompliance');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, '관세사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, '무역사무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, '항공/운동');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (14, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '의사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '약사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, 'MI');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, 'MSL');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '임상');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '배양');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '유전공학자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '미생물학자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '간호사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '한의사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '치료사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '심리분석/상담');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '인허가담당');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '의료행정/사무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '치위생사/기공사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (15, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '의료/제약');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '생명공학');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '전기/전자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '항공/우주');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '기계/자동차');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '로봇/자동화');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '화학/섬유');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '신소재개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '환경');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '반도체');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '경영/경제');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '원자력/에너지');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '농림/축산');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '조선');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '제조/공정');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '건설/교통');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '금속/철강');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '수도/위생');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '식품');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (16, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '자동차/배터리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '반도체');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '디스플레이');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '전기');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '전자');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, 'IT/통신');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '네트워크구축');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, 'CAD');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, 'CAM');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '제어');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '기계');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '화학');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '에너지');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '조선');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '건축/토목');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '의료');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (17, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '생산관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '공정관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, 'QA/QC');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '안전관리');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '생산기술개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '조립기술');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (18, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '교수');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '강사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '교직원');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '교육기획');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '교육행정');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '초중고교사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '보육/아동');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (19, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '검사/판사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '변호사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '변리사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '특허담당');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '법률사무');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '로펌비서');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '법무사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '재판연구원');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '감사');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (20, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '행정/공직');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '공공보건의료');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '사회복지');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '환경/동물복지');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '국제기구/협력');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '공공정책/개발');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '경찰/군인');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, 'NGO/시민단체');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '소방/안전');
INSERT INTO sub_job (job_id, sub_job_name) VALUES (21, '기타');

INSERT INTO sub_job (job_id, sub_job_name) VALUES (22, '기타');
