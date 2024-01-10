![99](https://github.com/dino-21/STEP3_spring_View/assets/80396471/d3575d76-f126-49ab-8a49-9766fbe62612)

![9](https://github.com/dino-21/STEP3_spring_View/assets/80396471/b478a5d8-90b7-4594-88d1-13ca0174bd96)

![10](https://github.com/dino-21/STEP3_spring_View/assets/80396471/c4f360d2-2013-40e5-be1a-7b26aa8ea000)


![4](https://github.com/dino-21/STEP3_spring_View/assets/80396471/183cf0c5-a64d-4016-ad7f-fe41b09e39ea)


1. SB Admin2 부트스크랩 압축풀고 
resources 폴더에 6개 폴더 붙여넣기

pages폴더에 tables.html파일 소스 가져오고
css 경로
 ../
/resources/ 바꾸기

톰캣 실행해서 화면 확인


2.  includes 파일 적용하기 – list.jsp에 header.jsp와 footer.jsp 적용
프로젝트 실행  - includes header.jsp 파일 적용 후에도 list.jsp가 동일하게 나와야 함
프로젝트 실행  - includes footer.jsp 파일 적용 후에도 list.jsp가 동일하게 나와야 함


3. list.jsp에서 Table 맨 위의 테이블만 남기고 아래쪽 테이블 7개 삭제 – 테이블 정리


4. footer.jsp 자바스크립트 코드 추가하기 </body>코드 전에 반응형 코드 붙여넣기

5. 목록 화면 처리 - list.jsp
list.jsp   - JSTL의 출력과 포맷을 적용하는 태그 라이브러리 추가
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

 list.jsp 코드 수정 – Model에 담긴 데이터 출력

<c:forEach items="${list}" var="board">
                                    <tr class="odd gradeX">
                                        <td>${board.bno}</td>
                                        <td>${board.title}</td>
                                        <td>${board.content}</td>
                                        <td>${board.regdate}</td>
                                        <td>${board.updateDate}</td>
                                    </tr>
 </c:forEach>


6. list에 날짜 포맷 바꾸기
 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
브라우저에서 확인

7.  list에서 최근글로 내림차순 정렬하기
BoardMapper.xml파일 수정
select * from tbl_board where bno > 0 order by bno desc

8. 등록 입력 페이지와 등록 처리 
BoardController.java
@GetMapping("/register")
public void resister() {
		 
}

9. register.jsp 파일 만들기

브라우저에서 확인 – 입력창





10. list.jsp   js 코드 추가 – 게시물번호 확인
addFlashAttribute 메소드 - 데이터를 URL에 노출되지 않고 일회성으로만 사용

<script>
$(document).ready(function(){
    var result = '${result}'; 	
});
</script>
리스트에서 F5 새로고침 후 
소스코드 확인  result 번호확인

11. 재전송(redirect)처리 
 PRG 패턴 POST → Redirect → GET 중복 입력을 방지
코드복사  bootstrap4  modal
list.jsp  
1. 부트4의 모달코드 붙여넣기 (table 끝나는 위치)
2. 모달창을 보여주는 jQuery 코드 추가 
3. 글등록버튼 추가

12. 글작성후 모달창이 뜨는지  확인 

13. 조회 페이지와 이동   - 링크를 통해서 GET방식으로 특정한 번호의 게시물을 조회할 수 있는 기능을 작성
BoardController.java
@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, Model model) {
		model.addAttribute("board", boardservice.get(bno));
	}

14. get.jsp 파일 만들기
브라우저에서 확인
http://localhost:8081/board/get?bno=2


15. list.jsp  코드추가,  목록페이지에서 제목 클릭하면 글번호로 읽을 수 있게
<td><a href='/board/get?bno=${board.bno}'>   ${board.title}</a></td>
톰캣서버 실행해서 브라우저에서 확인
http://localhost:8081/board/get?bno=7

16. 게시물 수정/삭제 처리 
BoardController.java 코드 수정

@GetMapping({"/get", "/modify"})
public void get(@RequestParam("bno") Long bno, Model model) {
      model.addAttribute("board", boardservice.get(bno));
}

modify.jsp 파일만들기 board폴더 아래에
<button type="submit" data-oper='modify'>Modify</button>
<button type="submit" data-oper='remove' >Remove</button>
<button type="submit" data-oper='list' >List</button>
var operation = $(this).data("oper");
톰캣서버 실행해서 브라우저에서 확인 – 수정 확인


17.  톰캣서버 실행해서 브라우저에서 확인 – 삭제 확인



