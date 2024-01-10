package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Autowired
	private BoardService service;

	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}

//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 시작하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		service.register(board);
//		log.info("생성된 게시물의 번호: " + board.getBno());
//	}

//	@Test
//	public void testGetList() {
//	   service.getList().forEach(board ->log.info(board));
//	}

//	@Test
//	public void testGet() {
//		// 번호가 있는지 확인
//		log.info(service.get(22L));
//	}
	
//	@Test
//	public void testDelete() {
//		// 번호가 있는지 확인
//		log.info("REMOVE RESULT : " + service.remove(23L));
//	}
	
	@Test
	public void testUpdate() {
		// 번호가 있는지 확인
		BoardVO board = service.get(24L);

		if (board == null) {
				return;
		}

		board.setTitle("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));
	}

}
