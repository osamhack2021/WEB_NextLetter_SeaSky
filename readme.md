
# 프로젝트 명
<!--![Logo](https://logosbynick.com/wp-content/uploads/2018/03/final-logo-example.png)-->
<h1 align="center">💌 넥스트 레터</h1>

<!--   ravis CI, Circle CI, 또는 GitHub Action에서 제공하는 빌드 스테이터스 뱃지를 사용해 프로젝트가 정상적으로 돌아가고 있다는 안도감을 주자.
-   코드 커버리지, 코드 퀄리티, maintainability 뱃지를 사용해 프로젝트의 코드가 훌룡하고 안전하다는 인상을 주자.
-   npm 또는 pypi 등지에서 당신의 패키지가 얼마나 다운로드 되었는지를 표시하는 스탯이 어느정도 자랑할만 하다면 그 뱃지도 추가하자.
-   그 밖에 shields.io에서 원하는 뱃지를 찾아 붙여 보도록 하자.
-   다만 주의할 점은 과하지 않도록 해야 한다. -->

> 훈련병의 개인정보도 지켜주는 인편지기, 넥스트 레터
> I'm on the, NEXT LETTER

## 프로젝트 소개
[인터넷 편지 현황]
- 육군 => 더캠프
- 해군 => 해군교육사령부
- 공군 => 공군 기본군사훈련단

[기존 인터넷 편지의 문제]
 1. 주변에 친구한테 부탁해서 내 SNS 계정 알려줘야하나요?
 2. SNS에 내 개인정보를 업로드하기엔 찝찝한데..
 3. 육군은 어플도 있는데, 해군/공군은 모바일에서  PC 버전으로 보는 건 불편해요
 4. 인편 작성하다가 자꾸 사라져요
 5. 훈련소 끝나고 나면 인터넷 편지를 다시 꺼내 볼 수 없어요

[배경]
- 훈련소에서 훈련병들에게 유일하게 힘이되는 것이 "인터넷 편지"입니다.
- 기존의 인터넷 편지 어플리케이션인 "더캠프"와 "공군 기군단"을 Legacy System으로 정의하고 새로운 기능을 추가하고 기존 기능을 개선하고자 합니다.
- 인터넷 편지를 통해 훈련병들에게 힘을 주고자 이번 프로젝트를 기획했습니다.


## 기능 설명
[주요 기능]
|  |육군 더캠프|해군 교육사|공군 기군단|넥스트 레터|
|--|--|--|--|--|
|개인 정보 보호|<center>❌</center>|<center>❌</center>|<center>❌</center>|<center>⭕</center>
|모바일 버전 제공|<center>⭕</center>|<center>❌</center>|<center>⭕</center>|<center>⭕</center>
|PC 버전 제공|<center>⭕</center>|<center>⭕</center>|<center>⭕</center>|<center>⭕</center>
|훈련 종료후 열람|<center>❌</center>|<center>❌</center>|<center>❌</center>|<center>⭕</center>
|개인 단축 URL 공유|<center>❌</center>|<center>❌</center>|<center>❌</center>|<center>⭕</center>
|익명 편지|<center>⭕</center>|<center>❌</center>|<center>⭕</center>|<center>⭕</center>
|발송 실패 시, 백업|<center>⭕</center>|<center>❌</center>|<center>❌</center>|<center>⭕</center>

- 주요 기능 ① : 인터넷 편지 발송을 위한 개인 Blog형 URL
기존 인터넷 편지 발송을 위해서는, 훈련병의 생년월일과 입대일로 소대번호를 조회해야하는 번거로움이 있었습니다. 
입대하기 전에 미리 만들어둔 개인 홈페이지 링크를 공유합니다. 
보다 쉽게 친구와 가족들이 방명록을 남기듯 인터넷 편지를  쉽게 작성할 수 있도록 합니다.

- 주요 기능 ② : 사회의 소식을 정리해서 알려주는 인터넷 편지
입대하기 전에 날씨, 스포츠, 뉴스 등 관심있는 주제를 선택해 놓으면 매일 내용을 스크랩해 인터넷 편지로 발송해 줍니다.

## 컴퓨터 구성 / 필수 조건 안내 (Prerequisites)
* ECMAScript 6 지원 브라우저 사용
* 권장: Google Chrome 버젼 77 이상

## 기술 스택 (Technique Used) 
### Server(back-end)
 - java 1.8 버전 
 - Spring MVC Framework
 - MariaDB 
 
### Front-end


## 설치 안내 (Installation Process)
```bash
$ git clone git주소
```

## 프로젝트 사용법 (Getting Started)
**마크다운 문법을 이용하여 자유롭게 기재**

잘 모를 경우
구글 검색 - 마크다운 문법
[https://post.naver.com/viewer/postView.nhn?volumeNo=24627214&memberNo=42458017](https://post.naver.com/viewer/postView.nhn?volumeNo=24627214&memberNo=42458017)

 편한 마크다운 에디터를 찾아서 사용
 샘플 에디터 [https://stackedit.io/app#](https://stackedit.io/app#)
 
## 팀 정보 (Team Information)
- hong gil dong (hong999@gmail.com), Github Id: gildong999
- kim su ji (suji999@gmail.com), Github Id: suji999

## 저작권 및 사용권 정보 (Copyleft / End User License)
 * [MIT](https://github.com/osamhack2021/WEB_NextLetter_SeaSky/edit/master/readme.md)

This project is licensed under the terms of the MIT license.

※ [라이선스 비교표(클릭)](https://olis.or.kr/license/compareGuide.do)

※ [Github 내 라이선스 키워드(클릭)](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/creating-a-repository-on-github/licensing-a-repository)

※ [\[참조\] Github license의 종류와 나에게 맞는 라이선스 선택하기(클릭)](https://flyingsquirrel.medium.com/github-license%EC%9D%98-%EC%A2%85%EB%A5%98%EC%99%80-%EB%82%98%EC%97%90%EA%B2%8C-%EB%A7%9E%EB%8A%94-%EB%9D%BC%EC%9D%B4%EC%84%A0%EC%8A%A4-%EC%84%A0%ED%83%9D%ED%95%98%EA%B8%B0-ae29925e8ff4)
