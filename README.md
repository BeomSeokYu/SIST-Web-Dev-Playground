# Class 230112

날짜: 2023년 1월 12일

## Servlet

서블렛은 SERVER APPLET 의 줄임말로 cgi의 단점을 보완하기 위해서 썬마이크로시스템사에서 개발한 동적 웹 솔루션. 서블릿을 기반으로 하여 JSP 가 개발됨.

- Servlet과 JSP

![Untitled](https://user-images.githubusercontent.com/69231700/212273968-f81dc3df-b58c-4163-a5c8-5ff372c6f1a1.png)

<aside>
💡 JSP 는 내부적으로 서블릿으로 변환되어 실행됨

</aside>

서블릿 코드 예시

```java
@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
  
	public RadioServlet() {
	  super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("selected fruit : " + request.getParameter("fruit") + "<br>");
		out.close();
	}
```

JSP 코드 예시

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String s = request.getParameter("content"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h3>JSP Page</h3>
	content : ${ content }
	content : <%= s $>
</body>
</html>
```

### Servlet 장점

- 자바 기반이기 때문에 일반 자바의 모든 api 그대로 쓸 수 있다.
- 한번 개발된 애플리케이션은 다양한 서버 환경에서 실행할 수 있다.
- 다양한 오픈소스 라이브러리들과 개발도구들을 활용할 수 있다.

### Servlet 단점

- HTML 출력울 위해서 문자열 결합을 복잡하게 해야 한다.
- 프론트앤드 화면 수정이 아주 어렵다.
- 데이터 처리도 불편하다.
