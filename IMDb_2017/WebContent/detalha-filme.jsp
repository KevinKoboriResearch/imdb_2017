<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="model.Filme"%>
<%@ page import="model.AtoresFilme"%>
<%@ page import="model.DiretoresFilme"%>
<%@ page import='java.util.ArrayList'%>

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
<%
Filme filme = (Filme) request.getAttribute("filme");

ArrayList<DiretoresFilme> diretoresFilme = (ArrayList<DiretoresFilme>) request.getAttribute("diretoresFilme");

ArrayList<AtoresFilme> atoresFilme = (ArrayList<AtoresFilme>) request.getAttribute("atoresFilme");


		if(filme.getIdFilme() == 0) {
   		out.println("</TABLE>" +
					"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH><FONT size='7' color='#FFFFFF'>" +
					"É Nessesário a Inserção de Dados para a Pesquisa Ser Efetuada</FONT></TH>");
		}  else {
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<HTML><HEAD><TITLE>DETALHES FILME PT</TITLE>" + "<link href='css/bootstrap.min.css' rel='stylesheet'>" + "</HEAD>" +
						"<BODY>" +
						"<TABLE style='width:100%' bgcolor='#262626'><TR><TH style='width:62%' bgcolor='#cccccc'><FONT color='#333333'>Kevin Yuji Kobori</FONT></TH>" +
	    				"<TH style='width:38%' bgcolor='#333333'><font size='+1' color='#FFFFFF'>UniCEUB</FONT></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH style='width:100%' bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>Filme "
    					+ "''" + filme.getTitulo() + "''" + "</FONT></TH>");
				/*		"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH style='width:80%' bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>Filme "
						+ "''" + filme.getTitulo() + "''" + "</FONT></TH>" +
						"<TH style='width:20%' ><A HREF='/TrabalhoFinal_Kevin_Yuji_Kobori_IMDb/login.jsp'>" + "<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE=" + filme.getIdFilme() + ">EDITAR DADOS</A></TH></TR></TABLE>");*/
				//		"<TH style='width:20%' ><FORM ACTION='login.jsp'>" + "<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE=" + filme.getIdFilme() + ">INCLUIR DADOS</TH></TR></TABLE>");
					
						//-------------------------------------------------------------------------------------------------------------------------------------------/
		    out.println("<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ID FILME" +    	"</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "TITULO" +	    "</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "TITULO INGLES" +	"</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ANO" + 		 	"</FONT>" + "</TH>" +
						"<TH style='width:22%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "CATEGORIA" +   	"</FONT>" + "</TH>" +
						"<TH style='width:30%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "PONTUACAO" + 	"</FONT>" + "</TH>" +
						"</TR>" +
					
						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getIdFilme() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTitulo() + 	    "</FONT>" + "</TH>" + 
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTituloIngles() + "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getAno() +          "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getCategoria() +    "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getPontuacao() +    "</FONT>" + "</TH>" +
						"</TR>" +
						"</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println(//"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						"<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
			        	"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ID ATOR" + 	"</FONT>" + "</TH>" +
			//			"<TD style='width:09%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'> " + "ID FILME" +	"</FONT>" + "</TD>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "ATORES" +  	"</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "PAPEL" +   	"</FONT>" + "</TH>" +
						"<TH style='width:60%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "DESCRICAO" + "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < atoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getIdAtor() +    "</FONT>" + "</TH>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getIdFilme() +   "</FONT>" + "</TD>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getAtorNome() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getPapel() + 	  "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +
						"</TR>");
				}
			out.println("</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println(//"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						"<TABLE style='width:100%' bgcolor='#FFCC00'><TR><TH bgcolor='#ffcc00'></TH></TR></TABLE>" +
			        	"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
					
						"<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
						"<TH style='width:10%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "ID DIRETOR" + "</FONT>" + "</TH>" +
			//			"<TD style='width:20%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID FILME" +   "</FONT>" + "</TD>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "DIRETORES" +  "</FONT>" + "</TH>" +
						"<TH style='width:75%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "DESCRICAO" +  "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < diretoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getIdDiretor() + "</FONT>" + "</TH>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getIdFilme() +   "</FONT>" + "</TD>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDiretorNome() +   "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +
						"</TR>");

				}
			out.println("</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
	    			    "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>");
			
			out.println("<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH style='width:100%' bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>EDITE OS DADOS FAZENDO LOGIN COMO ADMINISTRADOR</FONT></TH>" +
						"<TABLE style='width:100%'>" +
						"<form action='/TrabalhoFinal_Kevin_Yuji_Kobori_IMDb/login' method='POST'>" +
						"<TR><TD style='width:05%' bgcolor='#333333'><FONT color='#FFFFFF'>Usuário: </FONT></TD>" +
						"<TD style='width:09%' bgcolor='#D9D9D9'><input type='text' name='usuario'></TD>" +
						"<TD style='width:05%' bgcolor='#333333'></TD>" +
						"<TD style='width:81%' bgcolor='#333333'></TD></TR>" +
						"<TR><TD style='width:05%' bgcolor='#333333'><FONT color='#FFFFFF'>Senha: </FONT></TD>" +
						"<TD style='width:09%' bgcolor='#D9D9D9'><input type='password' name='senha'></TD>" +
					//  "<TD><select name='idfilme' id='idfilme' onchange='this.form.submit()'>" +
					//	"<option value='" + filme.getIdFilme() + "'>Filme</option></TD>" +
						"<TD style='width:05%' bgcolor='#262626'><input style='width:100%' type='submit' name='idfilme' id='idfilme' value='" + filme.getIdFilme() + "'></TD>" +
					//	"<TD style='width:05%' bgcolor='#262626'><input style='width:100%' type='submit' value='Logar'></TD>" +
						"<TD style='width:81%' bgcolor='#333333'></TD></TR>" +
						"</form>" +
						"</TABLE>");
			
	/*		<TH bgcolor='#333333' style='width:10%'>
			 <form action="/TrabalhoFinal_Kevin_Yuji_Kobori_IMDb/barra-todos" method="GET">
			 <select class="w3-select w3-border" name="consultaTodos" id="consultaTodos" onchange="this.form.submit()">
				<option value="" selected disabled>Listas</option>
				<option value='Todos os Filmes'>Todos os Filmes</option>
				<option value='Todas as Series' disabled>Todas as Series</option>
				<option value='Todos os Diretores'>Todos os Diretores</option>
				<option value='Todos os Atores'>Todos os Atores</option>
			  </select>
			 </TH>
			 
			 <select class="w3-select w3-border" name="tipoConsulta" id="tipoConsulta">
				<option value="" selected disabled>Consultar Filmes por....</option>*/
			}		
%>
</FORM>
</BODY>
</HTML>