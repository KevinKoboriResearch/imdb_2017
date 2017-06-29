<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FILME</title>
</head>
<style>
/*Table------------------------------------------------------------------------------*/
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
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
<TH style='width:4%'>ID</TH>
<TH style='width:96%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>FILME(S)</FONT></TH>
</TR></TABLE>
<TABLE style='width:100%' bgcolor='#CCCCCC' bordercolor='#262626' border='1'>
<TR>
<TH style='width:04%' bgcolor='#CCCCCC'>FILME</TH>
<TH style='width:24%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>TITULO PORTUGUES</FONT></TH>
<TH style='width:24%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>TITULO INGLES</FONT></TH>
<TH style='width:12%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>ANO</FONT></TH>
<TH style='width:18%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>CATEGORIA</FONT></TH>
<TH style='width:18%' bgcolor='#262626'><FONT size='+1' color='FFFFFF'>PONTUACAO</FONT></TH>
</TR>
<%
Filme filme = (Filme) request.getAttribute("filme");

		if(filme.getIdFilme() == 0) {
   		out.println("</TABLE>" +
					"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH><FONT size='7' color='#FFFFFF'>" +
					"É Nessesário a Inserção de Dados para a Pesquisa Ser Efetuada</FONT></TH>");
		} else if(filme.getTituloIngles() == null) {
	    out.println("<TR>" +
					"<TH bgcolor='#CCCCCC'><FONT size='4' color='#333333'>" + filme.getIdFilme() + "</FONT></TH>" +
					"<TH bgcolor='#333333'><A HREF='exibir-filme?idfilme=" + filme.getIdFilme() + "'>" +
					"<FONT size='4' color='#FFFFFF'> " + filme.getTitulo() + " </FONT></A></TH>" +
					"<TH bgcolor='#333333'><FONT size='4' color='#ffcc00'>Indisponível</FONT></TH>" +
					"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getAno() + " </FONT></TH>" +
				//	"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getCategoria() + " </FONT></TH>" +
					"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getPontuacao() + " </FONT></TH>");	
		}  else {
    	out.println("<TR>" +
				"<TH bgcolor='#CCCCCC'><FONT size='4' color='#333333'>" + filme.getIdFilme() + "</FONT></TH>" +
				"<TH bgcolor='#333333'><A HREF='exibir-filme?idfilme=" + filme.getIdFilme() + "'>" +
				"<FONT size='4' color='#FFFFFF'> " + filme.getTitulo() + " </FONT></A></TH>" +
				"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getTituloIngles() + " </FONT></TH>" +
				"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getAno() + " </FONT></TH>" +
			//	"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getCategoria() + " </FONT></TH>" +
				"<TH bgcolor='#333333'><FONT size='4' color='#FFFFFF'> " + filme.getPontuacao() + " </FONT></TH>");
		}
%>
</TR>
</TABLE>
</BODY>
</HTML>