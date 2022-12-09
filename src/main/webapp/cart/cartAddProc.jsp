<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="market.dao.ProductDAO"%>
<%@page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ProductDAO pdao = new ProductDAO();
	String pid = request.getParameter("pid");
	List<ProductVO> cartList = null;
	boolean flag = false;
	if (pid != null) {
		ProductVO pvo = pdao.select(request.getParameter("pid"));
		if(pvo != null) {
			cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");
			if(cartList == null) {
				cartList = new ArrayList();
				session.setAttribute("cartList", cartList);
			} else {
				for (ProductVO p : cartList) {
					if (p.getPid().equals(pid)) {
						p.setQuantity(p.getQuantity() + 1);
						flag = true;
					}
				}
			}
			if (!flag) {
				pvo.setQuantity(1);
				cartList.add(pvo);
			}
		}
		response.sendRedirect("../product/productInfo.jsp?pid=" + pid);
	} else {
		pageContext.forward("../product/productList.jsp");
	}
// 요청객체에서 pid 가져오기 
// pid가 없으면 상품 목록으로 돌아가기 
// product 테이블에서 해당 상품 하나 가져오기 
// 가져온 상품이 없다면 예외처리
// 세션에서 장바구니 목록 속성 cartList 꺼내기
// 		장바구니 목록(cartList)이 없다면 장바구니 리스트 생성해서 세션에 담기
//		있다면, 목록에 추가
//			pid가 이미 목록에 있다면 수량 ++
// 처리가 끝났다면 상품 정보 페이지로 
%>
