<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.DiretoresFilme"%>
<%@ page import='java.util.ArrayList'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Diretor(es)</title>
</head>
<style>
/*Table------------------------------------------------------------------------------*/
table {
    border-collapse: collapse;
    width: 100%;
}

th {
    padding: 4px;
    text-align: center;
    border-bottom: 1px solid #ddd;
} 

td {
    padding: 4px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color:#f5f5f5
}
</style>
<body>
<TABLE style='width:100%' bgcolor='#262626'><TR><TH style='width:62%' bgcolor='#cccccc'><FONT color='#333333'>Kevin Yuji Kobori</FONT></TH>
<TH style='width:38%' bgcolor='#333333'><font size='+1' color='#FFFFFF'>UniCEUB</FONT></TH></TR></TABLE>

<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>
<TABLE style='width:100%' bgcolor='#ffcc00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>
<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>

<TABLE style='width:100%' bgcolor='#CCCCCC'><TR>
<TH style='width:04%'>ID</TH>
<TH style='width:96%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>DIRETOR(ES)</FONT></TH>
</TR></TABLE>
<TABLE style='width:100%' bgcolor='#CCCCCC' bordercolor='#262626' border='1'>
<TR>
<TH style='width:04%' bgcolor='#CCCCCC'>DIRETOR</TH>
<TH style='width:48%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>DIRETOR</FONT></TH>
<TH style='width:48%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>DESCRICAO</FONT></TH>
</TR>
<%
ArrayList<DiretoresFilme> diretores = (ArrayList<DiretoresFilme>) request.getAttribute("diretores");
	      
	for(int i = 0; i < diretores.size(); i++) {
		if(diretores.get(i).getIdDiretor() == 0) {
        out.println("</TABLE>" +
					"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH><FONT size='7' color='#FFFFFF'>" +
					"É Nessesário a Inserção de Dados para a Pesquisa Ser Efetuada</FONT></TH>");
  		} else if(diretores.get(i).getDescricao() == null) {
  	    out.println("<TR>" +
  					"<TH bgcolor='#CCCCCC'><FONT size='4' color='#333333'>" + diretores.get(i).getIdFilme() + "</FONT></TH>" +
  					"<TH bgcolor='#333333'><A HREF='exibir-filme?idfilme=" + diretores.get(i).getIdFilme() + "'>" +
					"<FONT size='4' color='#FFFFFF'> " + diretores.get(i).getDiretorNome() + " </FONT></A></TH>" +
					"<TD bgcolor='#333333'><FONT size='4' color='#333333'>----------------------------------------------</FONT><FONT size='4' color='#ffcc00'>Indisponível</FONT></CENTER></TD>");	
		}  else {
        out.println("<TR>" +
					"<TH bgcolor='#CCCCCC'><FONT size='4' color='#333333'>" + diretores.get(i).getIdFilme() + "</FONT></TH>" +
					"<TH bgcolor='#333333'><A HREF='exibir-filme?idfilme=" + diretores.get(i).getIdFilme() + "'>" +
					"<FONT size='4' color='#FFFFFF'> " + diretores.get(i).getDiretorNome() + " </FONT></A></TH>" +
					"<TD bgcolor='#333333'><FONT size='4' color='#333333'>----------------------------------------------</FONT><FONT size='4' color='#FFFFFF'>" + diretores.get(i).getDescricao() + "</FONT></CENTER></TD>");
    	}
	}
%>
</TR>
</TABLE>
</BODY>
</html>