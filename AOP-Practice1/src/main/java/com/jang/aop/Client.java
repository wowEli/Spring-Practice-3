package com.jang.aop;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jang.biz.member.MemberService;
import com.jang.biz.member.MemberVO;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		/*
		BoardService bs = (BoardService)factory.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		Scanner sc = new Scanner(System.in);
		System.out.println("내용작성>> ");
		String msg = sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("작은 악마");
		vo.setWriter("티모");
		bs.insertBoard(vo);
		
		ArrayList<BoardVO> datas = bs.selectAllBoard(vo);
		
		for(BoardVO v : datas) {
			System.out.println(v);
		}
		*/
		
		MemberService ms = (MemberService)factory.getBean("memberService");
		
		MemberVO vo = new MemberVO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 로그인 2. 회원가입");
		System.out.println("번호 입력: ");
		int action = sc.nextInt();
		
		if(action == 1) {
			System.out.println("아이디입력: ");
			String id=sc.next();
			System.out.println("비밀번호 입력: ");
			String pw=sc.next();
			
			vo.setMid(id);
			vo.setMpw(pw);
			
			vo = ms.selectOneMember(vo);
			if(vo!= null) {
				System.out.println(vo.getName()+"님 로그인이 되었습니다.");
			}
			else {
				System.out.println("아이디나 비밀번호가 틀렸습니다.");
			}
		}
		
		else if(action == 2) {
			System.out.println("아이디입력: ");
			String id=sc.next();
			System.out.println("비밀번호입력: ");
			String pw=sc.next();
			System.out.println("이름입력: ");
			String name=sc.next();
			System.out.println("등급입력: ");
			String role=sc.next();
			
			vo.setMid(id);
			vo.setMpw(pw);
			vo.setName(name);
			vo.setRole(role);
			
			ms.insertMember(vo);
			System.out.println("회원가입이 완료되었습니다.");
		}
		
		else {
			System.out.println("잘못된 번호입니다.");
		}
		
	}

}