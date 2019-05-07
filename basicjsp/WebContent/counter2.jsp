<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! int cnt = 0;
int totalLen;

public void init() {
	cnt = 0;
	totalLen = 8;
}

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
cnt++;
String cntStr = cnt + "";	//예137
int cntLen = cntStr.length(); //3자리
int zeroLen = totalLen - cntLen; //5
//PrintWriter out = response.getWriter();
%>

<html>
	<body>
	<div align = "center">
당신은
<%		
for (int i = 0; i < zeroLen; i++){
%><img src="/basicjsp/img/0.PNG">
<%}
for(int i=0;i<cntLen;i++){%>
<img src="/basicjsp/img/<%=cntStr.charAt(i)%>.PNG">
<%}%>

<br>번째 방문자입니다.
	</div>
	</body>
</html>







