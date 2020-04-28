select *
from recipe;

INSERT INTO food(category, name)
VALUES
('면','비빔국수'),
('면','간장국수'),
('면','비빔당면'),
('면','칼국수'),
('면','모밀국수'),
('면','바지락칼국수'),
('면','짬뽕'),
('면','짜장면'),
('면','우동'),
('면','볶음우동'),
('면','카레우동'),
('면','라면'),
('면','볶음면'),
('면','김치말이국수'),
('면','냉면'),
('밀가루','수제비'),
('밀가루','밀떡볶이'),
('밀가루','김치부침개'),
('밀가루','부침개'),
('밀가루','해물파전'),
('밀가루','빈대떡'),
('밀가루','고추장떡'),
('밀가루','메밀전병'),
('떡','떡볶이'),
('떡','떡꼬치'),
('떡','떡국'),
('밥', '볶음밥'),
('밥', '차슈덮밥'),
('밥', '김치볶음밥'),
('밥', '황금볶음밥'),
('밥', '스팸마요덮밥'),
('밥', '치킨마요덮밥'),
('밥', '참치마요덮밥'),
('밥', '비빔밥'),
('밥', '오므라이스'),
('밥', '베이컨말이'),
('밥', '돈까스덮밥'),
('밥', '간장계란밥'),
('밥', '유부초밥'),
('밥', '김밥'),
('밥', '초밥'),
('밥', '쌈밥'),
('죽', '전복죽'),
('죽', '야채죽'),
('죽', '닭죽'),
('탕', '갈비탕'),
('탕', '감자탕'),
('탕', '설렁탕'),
('탕', '삼계탕'),
('탕', '매운탕'),
('탕', '홍합탕'),
('탕', '어묵탕'),
('국', '어묵국'),
('국', '계란국'),
('국', '오징어무우국'),
('국', '소고기무우국'),
('국', '된장국'),
('국', '미역국'),
('국', '콩나물국'),
('국', '만두국'),
('국', '청국장'),
('국', '오이냉국'),
('국', '북어국'),
('국', '육개장'),
('국', '순대국'),
('찌개', '김치찌개'),
('찌개', '된장찌개'),
('찌개', '버섯찌개'),
('찌개', '돼지찌개'),
('찌개', '부대찌개'),
('찌개', '고추장찌개'),
('찌개', '순두부찌개'),
('찌개', '두부찌개'),
('찌개', '짜글이'),
('양식', '토마토스파게티'),
('양식', '크림스파게티'),
('양식', '크림리조또'),
('양식', '새우필라프'),
('양식', '에그인헬'),
('양식', '그라탕'),
('양식', '스테이크'),
('양식', '봉골레파스타'),
('양식', '알리오올리오'),
('양식', '로제파스타'),
('양식', '감바스'),
-- 돼지고기
('반찬', '제육볶음'),
('반찬', '돼지갈비'),
('반찬', '돈까스'),
('반찬', '삼겹살'),
('반찬', '돼지불백'),
('반찬', '두루치기'),
('반찬', '족발'),
('반찬', '보쌈'),
('반찬', '수육'),
('반찬', '동파육'),
('반찬', '차슈'),
('반찬', '산적꼬치'),
-- 소고기
('반찬', '소불고기'),
('반찬', '장조림'),
('반찬', '갈비'),
('반찬', '갈비찜'),
('반찬', '너비아니'),
-- 닭고기
('반찬', '닭갈비'),
('반찬', '닭도리탕'),
('반찬', '치킨'),
('반찬', '깐풍기'),
('반찬', '닭개장'),
('반찬', '닭곰탕'),
('반찬', '닭꼬치'),
('반찬', '백숙'),
('반찬', '찜닭'),
-- 계란
('반찬', '달걀토마토볶음'),
('반찬', '마약계란장'),
('반찬', '오믈렛'),
('반찬', '계란말이'),
('반찬', '계란빵'),
('반찬', '계란프라이'),
('반찬', '노른자장'),
('반찬', '머랭'),
('반찬', '수란'),
('반찬', '스크램블에그'),
('반찬', '계란찜'),
-- 해물
('반찬', '멸치고추'),
('반찬', '꽁치조림'),
('반찬', '고등어구이'),
('반찬', '고등어데리야끼'),
('반찬', '고등어조림'),
('반찬', '칠리새우'),
('반찬', '버터갈릭새우'),
('반찬', '오징어볶음'),
('반찬', '낙지볶음'),
('반찬', '쭈꾸미볶음'),
('반찬', '간장새우'),
('반찬', '간장게장'),
('반찬', '양념게장'),
('반찬', '연어장'),
-- 나물, 두부, 콩
('반찬', '숙주불고기볶음'),
('반찬', '고사리무침'),
('반찬', '콩나물무침'),
('반찬', '마파두부'),
('반찬', '만두'),
('반찬', '버섯볶음'),
('반찬', '잡채'),
('반찬', '동그랑땡'),
('반찬', '상추겉절이'),
('반찬', '고추된장무침'),
('반찬', '두부시금치무침'),
('반찬', '가지고기볶음'),
('반찬', '오이무침'),
('반찬', '감자조림'),
('반찬', '감자전'),
('반찬', '애호박볶음'),
('반찬', '어묵볶음'),
('반찬', '무말랭이무침'),
('반찬', '연근조림'),
('반찬', '시금치나물'),
('반찬', '깻잎장아찌');
-- 04.28 여기까지 insert완료



INSERT INTO ingredient(category, name)
VALUES
('생선', '동태'),
('생선', '북어'),
('생선', '고등어'),
('생선', '참치'),
('생선', '꽁치'),
('생선', '명태'),
('생선', '삼치'),
('생선', '도미'),
('생선', '연어'),
('생선', '조기'),
('생선', '갈치'),
('생선', '굴비'),
('생선', '아구'),
('생선', '임연수'),
('해산물', '낙지'),
('해산물', '게'),
('해산물', '새우'),
('해산물', '쭈꾸미'),
('해산물', '문어'),
('해산물', '오징어'),
('해산물', '미역'),
('해산물', '전복'),
('해산물', '김'),
('해산물', '다시마'),
('해산물', '멸치'),
('해산물', '매생이'),
('해산물', '다슬기'),
('해산물', '파래'),
('해산물', '개불'),
('해산물', '해삼'),
('해산물', '멍게'),
('해산물', '굴'),
('해산물', '어묵'),
('해산물', '바지락'),
('해산물', '홍합'),
('조개', '조개'),
('젓갈', '명란젓'),
('젓갈', '낙지젓'),
('젓갈', '오징어젓'),
('젓갈', '조개젓'),
('고기', '소고기'),
('고기', '돼지고기'),
('고기', '돈까스'),
('고기', '닭고기'),
('고기', '치킨'),
('고기', '양고기'),
('고기', '오리고기'),
('채소', '쌈채소'),
('채소', '상추'),
('채소', '양배추'),
('채소', '양상추'),
('채소', '고추'),
('채소', '청양고추'),
('채소', '무말랭이'),
('채소', '피망'),
('채소', '양파'),
('채소', '마늘'),
('채소', '미나리'),
('채소', '더덕'),
('채소', '우거지'),
('채소', '당근'),
('채소', '콩'),
('채소', '오이'),
('채소', '가지'),
('채소', '고사리'),
('채소', '브로콜리'),
('채소', '샐러리'),
('채소', '감자'),
('채소', '고구마'),
('채소', '호박'),
('채소', '토마토'),
('채소', '딸기'),
('채소', '깻잎'),
('채소', '부추'),
('채소', '파'),
('채소', '쪽파'),
('채소', '대파'),
('채소', '아스파라거스'),
('채소', '쑥갓'),
('채소', '고수'),
('채소', '무우'),
('채소', '단호박'),
('채소', '배추'),
('채소', '생강'),
('채소', '메밀'),
('채소', '숙주'),
('채소', '연근'),
('채소', '우엉'),
('채소', '청경채'),
('채소', '레몬'),
('채소', '두부'),
('채소', '순두부'),
('채소', '파프리카'),
('버섯', '버섯'),
('버섯', '표고버섯'),
('버섯', '양송이버섯'),
('버섯', '새송이버섯'),
('버섯', '송이버섯'),
('버섯', '팽이버섯'),
('버섯', '느타리버섯'),
('김치', '김치'),
('김치', '배추김치'),
('김치', '파김치'),
('김치', '갓김치'),
('김치', '오이소박이'),
('면', '당면'),
('면', '냉면'),
('면', '소면'),
('면', '칼국수'),
('면', '모밀'),
('면', '우동'),
('면', '라면'),
('면', '파스타'),
('면', '스파게티'),
('양념', '카레가루'),
('양념', '짜장'),
('양념', '춘장'),
('양념', '카레'),
('양념', '고추장'),
('양념', '된장'),
('양념', '청국장'),
('양념', '쌈장'),
('양념', '들기름'),
('양념', '참기름'),
('양념', '식초'),
('양념', '기름'),
('양념', '마요네즈'),
('양념', '토마토소스'),
('양념', '굴소스'),
('양념', '두반장'),
('양념', '땅콩버터'),
('양념', '버터'),
('양념', '레몬즙'),
('햄', '햄'),
('햄', '소세지'),
('햄', '스팸'),
('햄', '리챔'),
('햄', '베이컨'),
('만두', '만두'),
('만두', '물만두'),
('만두', '군만두'),
('떡', '떡'),
('떡', '떡볶이'),
('떡', '가래떡'),
('떡', '쌀떡볶이'),
('떡', '밀떡볶이'),
('채소', '유부'),
('치즈', '치즈');
-- 4.28 여기까지 insert 완료


INSERT INTO recipe(main_material, food_name, ingredient_name)
VALUES
-- (1, '계란탕', '계란'),
(1, '국수', '국수'),
(1, '비빔국수', '국수'),
(1, '비빔국수', '고추장'),
(0, '비빔국수', '오이'),
(0, '비빔국수', '김'),
(0, '비빔국수', '김치'),
(1, '간장국수', '국수'),
(1, '간장국수', '간장'),
(0, '간장국수', '계란'),
(1, '비빔당면', '당면'),
(1, '비빔당면', '고추장'),
(0, '비빔당면', '계란'),
(0, '비빔당면', '김'),
(0, '비빔당면', '어묵'),
(1, '칼국수', '칼국수'),
(0, '칼국수', '바지락'),
(0, '칼국수', '해물'),
(1, '모밀국수', '모밀'),
(0, '모밀국수', '김'),
(1, '바지락칼국수', '칼국수'),
(1, '바지락칼국수', '바지락'),
(0, '바지락칼국수', '당근'),
(1, '짬뽕', '국수'),
(1, '짬뽕', '해산물'),
(1, '짬뽕', '고추장'),
(1, '짬뽕', '돼지고기'),
(1, '짜장', '국수'),
(1, '짜장면', '춘장'),
(1, '짜장면', '돼지고기'),
(1, '우동', '우동'),
(1, '볶음우동', '우동'),
(0, '볶음우동', '해산물'),
(1, '카레우동', '우동'),
(1, '카레우동', '카레'),
(0, '카레우동', '감자'),
(0, '카레우동', '당근'),
(1, '라면', '라면'),
(0, '라면', '치즈'),
(0, '라면', '만두'),
(0, '라면', '떡'),
(0, '라면', '깻잎'),
(1, '볶음면', '라면'),
(1, '볶음면', '굴소스'),
(1, '김치말이국수', '국수'),
(1, '김치말이국수', '김치'),
(1, '냉면', '냉면'),
(1, '수제비', '밀가루'),
(0, '수제비', '애호박'),
(0, '수제비', '당근'),
(1, '냉면', '냉면'),
(1, '김치부침개', '밀가루'),
(1, '김치부침개', '김치'),
(1, '부침개', '밀가루'),
(1, '해물파전', '밀가루'),
(1, '해물파전', '해산물'),
(1, '빈대떡', '밀가루'),
(1, '고추장떡', '밀가루'),
(1, '고추장떡', '고추장'),
(1, '메밀전병', '메밀'),
(1, '메밀전병', '김치'),
(1, '떡볶이', '떡'),
(1, '떡볶이', '고추장'),
(0, '떡볶이', '어묵'),
(0, '떡볶이', '파'),
(0, '떡볶이', '치즈'),
(1, '떡꼬치', '떡'),
(1, '떡꼬치', '고추장'),
(1, '떡꼬치', '고추장'),
(1, '떡국', '떡'),
(0, '떡국', '계란'),
(1, '볶음밥', '밥'),
(0, '볶음밥', '굴소스'),
(0, '볶음밥', '감자'),
(0, '볶음밥', '양파'),
(0, '볶음밥', '고추'),
(0, '볶음밥', '파'),
(0, '볶음밥', '햄'),
(1, '김치볶음밥', '밥'),
(1, '김치볶음밥', '김치'),
(0, '김치볶음밥', '햄'),
(1, '차슈덮밥', '밥'),
(1, '차슈덮밥', '돼지고기'),
(1, '황금볶음밥', '계란'),
(1, '황금볶음밥', '밥'),
(1, '스팸마요덮밥', '밥'),
(1, '스팸마요덮밥', '스팸'),
(1, '스팸마요덮밥', '마요네즈'),
(1, '치킨마요덮밥', '치킨'),
(1, '치킨마요덮밥', '마요네즈'),
(1, '치킨마요덮밥', '밥'),
(1, '참치마요덮밥', '밥'),
(1, '참치마요덮밥', '참치'),
(1, '참치마요덮밥', '마요네즈'),
(1, '비빔밥', '밥'),
(1, '비빔밥', '고추장'),
(0, '비빔밥', '계란후라이'),
(0, '비빔밥', '나물'),
(1, '오므라이스', '밥'),
(1, '오므라이스', '계란'),
(0, '오므라이스', '햄'),
(1, '베이컨말이', '밥'),
(1, '베이컨말이', '베이컨'),
(1, '돈까스덮밥', '밥'),
(1, '돈까스덮밥', '돈까스'),
(1, '간장계란밥', '밥'),
(1, '간장계란밥', '간장'),
(1, '간장계란밥', '계란'),
(1, '유부초밥', '밥'),
(1, '유부초밥', '유부'),
(1, '김밥', '밥'),
(1, '김밥', '김'),
(0, '김밥', '햄'),
(0, '김밥', '계란'),
(1, '쌈밥', '밥'),
(1, '쌈밥', '쌈채소'),
(1, '쌈밥', '쌈장'),
(1, '전복죽', '전복'),
(1, '전복죽', '밥'),
(1, '야채죽', '밥'),
(1, '야채죽', '채소'),
(1, '닭죽', '밥'),
(1, '닭죽', '닭'),
(0, '닭죽', '채소'),
(1, '갈비탕', '소고기'),
(1, '감자탕', '돼지고기'),
(1, '감자탕', '우거지'),
(1, '설렁탕', '소고기'),
(1, '삼계탕', '닭고기'),
(1, '매운탕', '생선'),
(1, '홍합탕', '홍합'),
(1, '어묵탕', '어묵'),
(1, '어묵국', '어묵'),
(1, '계란국', '계란'),
(1, '오징어무우국', '오징어'),
(1, '오징어무우국', '무우'),
(1, '소고기무우국', '소고기'),
(1, '소고기무우국', '무우'),
(1, '된장국', '된장'),
(0, '된장국', '두부'),
(0, '된장국', '애호박'),
(0, '된장국', '팽이버섯'),
(1, '미역국', '미역'),
(0, '미역국', '소고기'),
(0, '미역국', '조개'),
(1, '콩나물국', '콩나물'),
(1, '만두국', '만두'),
(0, '만두국', '떡'),
(1, '오이냉국', '오이'),
(1, '오이냉국', '미역'),
(0, '오이냉국', '식초'),
(1, '청국장', '청국장'),
(1, '북어국', '북어'),
(1, '육개장', '고사리'),
(1, '육개장', '소고기'),
(0, '육개장', '대파'),
(1, '순대국', '순대'),
(1, '김치찌개', '김치'),
(0, '김치찌개', '고추장'),
(0, '김치찌개', '돼지고기'),
(0, '김치찌개', '참치'),
(1, '된장찌개', '된장'),
(0, '된장찌개', '두부'),
(0, '된장찌개', '애호박'),
(0, '된장찌개', '팽이버섯'),
(1, '버섯찌개', '버섯'),
(1, '버섯찌개', '팽이버섯'),
(1, '버섯찌개', '느타리버섯'),
(1, '버섯찌개', '새송이버섯'),
(1, '버섯찌개', '표고버섯'),
(1, '부대찌개', '김치'),
(1, '부대찌개', '햄'),
(1, '부대찌개', '소세지'),
(1, '고추장찌개', '고추장'),
(1, '고추장찌개', '돼지고기'),
(1, '순두부찌개', '순두부'),
(0, '순두부찌개', '조개'),
(1, '두부찌개', '두부'),
(0, '두부찌개', '조개'),
(1, '짜글이', '고추장'),
(0, '짜글이', '돼지고기'),
(0, '짜글이', '감자'),
(0, '짜글이', '양파'),
(1, '토마토스파게티', '토마토소스'),
(1, '토마토스파게티', '스파게티'),
(1, '크림스파게티', '스파게티'),
(1, '크림스파게티', '우유'),
(1, '크림리조또', '우유'),
(1, '크림리조또', '밥'),
(1, '새우필라프', '밥'),
(1, '새우필라프', '새우'),
(1, '에그인헬', '토마토'),
(1, '에그인헬', '계란'),
(1, '그라탕', '치즈'),
(0, '그라탕', '닭고기'),
(0, '그라탕', '새우'),
(0, '그라탕', '소고기'),
(1, '스테이크', '소고기'),
(1, '스테이크', '소고기'),
(1, '봉골레파스타', '스파게티'),
(1, '봉골레파스타', '조개'),
(1, '알리오올리오', '스파게티'),
(1, '알리오올리오', '마늘'),
(0, '알리오올리오', '베이컨'),
(1, '로제파스타', '스파게티'),
(1, '로제파스타', '우유'),
(0, '로제파스타', '치즈'),
(1, '감바스', '새우'),
(1, '감바스', '마늘'),
(1, '제육볶음', '고추장'),
(1, '제육볶음', '돼지고기'),
(1, '돼지갈비', '돼지고기'),
(0, '돼지갈비', '고추장'),
(0, '돼지갈비', '간장'),
(1, '돈까스', '돼지고기'),
(1, '돈까스', '돈까스'),
(1, '삼겹살', '돼지고기'),
(1, '돼지불백', '돼지고기'),
(1, '돼지불백', '간장'),
(1, '두루치기', '돼지고기'),
(1, '두루치기', '고추장'),
(1, '족발', '돼지고기'),
(1, '보쌈', '돼지고기'),
(1, '수육', '돼지고기'),
(1, '동파육', '돼지고기'),
(1, '동파육', '간장'),
(1, '차슈', '돼지고기'),
(1, '차슈', '간장'),
(1, '산적꼬치', '파'),
(1, '산적꼬치', '돼지고기'),
(1, '산적꼬치', '단무지'),
(1, '산적꼬치', '맛살'),
(1, '소불고기', '소고기'),
(1, '소불고기', '간장'),
(0, '소불고기', '팽이버섯'),
(0, '소불고기', '표고버섯'),
(1, '장조림', '소고기'),
(1, '장조림', '계란'),
(0, '장조림', '고추'),
(1, '갈비', '소고기'),
(1, '갈비', '간장'),
(1, '너비아니', '소고기'),
(1, '닭갈비', '닭고기'),
(1, '닭갈비', '고추장'),
(0, '닭갈비', '파'),
(1, '닭도리탕', '닭고기'),
(1, '닭도리탕', '고추장'),
(0, '닭도리탕', '감자'),
(1, '치킨', '닭고기'),
(1, '깐풍기', '닭고기'),
(1, '깐풍기', '굴소스'),
(1, '깐풍기', '간장'),
(1, '찜닭', '닭고기'),
(1, '찜닭', '간장'),
(0, '찜닭', '떡'),
(1, '달걀토마토볶음', '계란'),
(1, '달걀토마토볶음', '토마토'),
(1, '마약계란장', '계란'),
(1, '마약계란장', '간장'),
(0, '마약계란장', '청양고추'),
(1, '오믈렛', '계란'),
(1, '계란말이', '간장'),
(0, '계란말이', '맛살'),
(0, '계란말이', '햄'),
(0, '계란말이', '파'),
(1, '계란프라이', '계란'),
(1, '노른자장', '계란'),
(1, '노른자장', '간장'),
(1, '수란', '계란'),
(1, '스크램블에그', '계란'),
(0, '스크램블에그', '우유'),
(1, '계란찜', '계란'),
(1, '멸치고추', '멸치'),
(1, '멸치고추', '고추'),
(1, '약고추장', '소고기'),
(1, '약고추장', '고추장'),
(1, '고등어구이', '고등어'),
(1, '고등어조림', '고등어'),
(1, '고등어조림', '고추장'),
(1, '꽁치조림', '꽁치'),
(1, '꽁치조림', '무우'),
(1, '고등어데리야끼', '고등어'),
(1, '고등어데리야끼', '간장'),
(1, '칠리새우', '새우'),
(1, '칠리새우', '칠리소스'),
(1, '버터갈릭새우', '새우'),
(1, '버터갈릭새우', '버터'),
(1, '버터갈릭새우', '마늘'),
(1, '오징어볶음', '오징어'),
(0, '오징어볶음', '고추장'),
(1, '낙지볶음', '낙지'),
(0, '낙지볶음', '고추장'),
(1, '쭈꾸미볶음', '쭈꾸미'),
(0, '쭈꾸미볶음', '고추장'),
(1, '간장새우', '새우'),
(1, '간장새우', '간장'),
(1, '간장게장', '간장'),
(1, '간장게장', '게'),
(1, '양념게장', '게'),
(0, '양념게장', '고추장'),
(1, '연어장', '연어'),
(1, '연어장', '간장'),
(1, '숙주불고기볶음', '숙주'),
(1, '숙주불고기볶음', '소고기'),
(1, '숙주불고기볶음', '굴소스'),
(1, '고사리무침', '고사리'),
(0, '고사리무침', '참기름'),
(0, '고사리무침', '들기름'),
(1, '콩나물무침', '콩나물'),
(0, '콩나물무침', '참기름'),
(0, '콩나물무침', '들기름'),
(0, '콩나물무침', '고추'),
(1, '마파두부', '두부'),
(1, '마파두부', '굴소스'),
(1, '마파두부', '고추가루'),
(0, '마파두부', '돼지고기'),
(1, '탄탄면', '땅콩버터'),
(1, '탄탄면', '칼국수'),
(1, '탄탄면', '국수'),
(1, '탄탄면', '굴소스'),
(1, '만두', '만두'),
(1, '물만두', '만두'),
(1, '군만두', '만두'),
(1, '버섯볶음', '버섯'),
(0, '버섯볶음', '굴소스'),
(1, '잡채', '당면'),
(0, '잡채', '당근'),
(1, '잡채', '돼지고기'),
(1, '동그랑땡', '돼지고기'),
(0, '동그랑땡', '밀가루'),
(1, '상추겉절이', '상추'),
(1, '고추된장무침', '고추'),
(1, '고추된장무침', '된장'),
(1, '두부시금치무침', '두부'),
(1, '고추된장무침', '시금치'),
(0, '고추된장무침', '된장'),
(1, '가지고기볶음', '가지'),
(1, '가지고기볶음', '돼지고기'),
(1, '오이무침', '오이'),
(1, '감자조림', '감자'),
(1, '감자조림', '간장'),
(1, '감자전', '감자'),
(1, '감자전', '밀가루'),
(1, '애호박볶음', '애호박'),
(1, '어묵볶음', '어묵'),
(1, '무말랭이무침', '무말랭이'),
(0, '무말랭이무침', '고추장'),
(1, '연근조림', '연근'),
(1, '연근조림', '간장'),
(1, '시금치나물', '시금치'),
(0, '시금치나물', '참기름'),
(0, '시금치나물', '된장'),
(1, '깻잎장아찌', '깻잎'),
(1, '깻잎장아찌', '간장');
















