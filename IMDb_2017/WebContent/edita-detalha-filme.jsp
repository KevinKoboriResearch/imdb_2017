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
						"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>Filme "
						+ "''" + filme.getTitulo() + "''" + "</FONT></TH></TR></TABLE>");
					
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
						"<TH style='width:22%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "PONTUACAO" + 	"</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "EXCLUIR" +   	"</FONT>" + "</TH>" +
						"</TR>" +
								
						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getIdFilme() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTitulo() + 	    "</FONT>" + "</TH>" + 
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getTituloIngles() + "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getAno() +          "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getCategoria() +    "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + filme.getPontuacao() +    "</FONT>" + "</TH>" +
						
						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TD>" + "<FORM ACTION='admin-modifica-dados' method='GET'>" + 
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='excluifilme'>" + 
						"<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE=" + filme.getIdFilme() + ">" +
						"<INPUT style='width:100%' TYPE='SUBMIT' VALUE='EXCLUIR'>" + "</FORM>" + "</TD>" +
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
						"<TH style='width:52%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "DESCRICAO" + "</FONT>" + "</TH>" +
					    "<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'> " + "EXCLUIR" +   "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < atoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getIdAtor() +    "</FONT>" + "</TH>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getIdFilme() +   "</FONT>" + "</TD>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getAtorNome() +      "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getPapel() + 	  "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'> " + atoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +

						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TD>" + "<FORM ACTION='admin-modifica-dados' method='GET'>" + 
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='excluiator'>" +
						"<INPUT TYPE='HIDDEN' NAME='idator' VALUE=" + atoresFilme.get(i).getIdAtor() + ">" +
						"<INPUT style='width:100%' TYPE='SUBMIT' VALUE='EXCLUIR'>" + "</FORM>" + "</TD>" +
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
						"<TH style='width:67%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "DESCRICAO" +  "</FONT>" + "</TH>" +
					    "<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "EXCLUIR" +    "</FONT>" + "</TH>" +
						"</TR>");
	
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			for (int i = 0; i < diretoresFilme.size(); i++) {
			out.println("<TR>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getIdDiretor() + "</FONT>" + "</TH>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getIdFilme() +   "</FONT>" + "</TD>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDiretorNome() +   "</FONT>" + "</TH>" +
						"<TH>" + "<FONT size='4' color='#FFFFFF'>" + diretoresFilme.get(i).getDescricao() + "</FONT>" + "</TH>" +
						
						//-------------------------------------------------------------------------------------------------------------------------------------------/
						"<TD>" + "<FORM ACTION='admin-modifica-dados' method='GET'>" + 
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='excluidiretor'>" + 
						"<INPUT TYPE='HIDDEN' NAME='iddiretor' VALUE=" + diretoresFilme.get(i).getIdDiretor() + ">" +
						"<INPUT style='width:100%' TYPE='SUBMIT' VALUE='EXCLUIR'>" + "</FORM>" + "</TD>" +
						"</TR>");

				}
			out.println("</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
	    			    "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
						"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>" + 
						"Adicionar Dados ao Filme " + "''" + filme.getTitulo() + "''" + "</font></TH></TR></TABLE>" +
						"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>");
						
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
			//			"<TD style='width:08%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID DIRETOR" +   "</FONT>" + "</TD>" +
			// 			"<TD style='width:08%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID FILME" +     "</FONT>" + "</TD>" +
						"<TH style='width:15%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "DIRETOR" +      "</FONT>" + "</TH>" +
						"<TH style='width:77%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "DESCRICAO" +    "</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "INCLUIR" +      "</FONT>" + "</TH>" +
						"</TR>" +
						
						"<TR>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + "AUTOIMPLEMENTO" +                "</FONT>" + "</TD>" +
						"<FORM ACTION='admin-modifica-dados' method='GET'>" +
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='incluidiretor'>" + 
						"<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE='" + filme.getIdFilme() + "'>" + 
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + idFilme +						   "</FONT>" + "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='diretor'>" +						   "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='descricao'>" + 				  	   "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='SUBMIT' VALUE='INCLUIR'>" +           		   "</TD>" +
						"</TR></FORM>" +
						"</TABLE>"); 
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println("<TABLE bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
			//			"<TD style='width:16%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID ATOR" +   "</FONT>" + "</TD>" +
			//			"<TD style='width:16%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID FILME" +  "</FONT>" + "</TD>" +
						"<TH style='width:15%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "ATOR" +      "</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "PAPEL" +     "</FONT>" + "</TH>" +
						"<TH style='width:62%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "DESCRICAO" + "</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#CCCCCC'>" + "<FONT size='4' color='#333333'>" + "INCLUIR" +   "</FONT>" + "</TH>" +
						"</TR>" +
						
						"<TR>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + "AUTOIMPLEMENTO" + 		   	   "</FONT>" + "</TD>" +
						"<FORM ACTION='admin-modifica-dados' method='GET'>" +
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='incluiator'>" + 
						"<INPUT TYPE='HIDDEN' NAME='idfilme' VALUE='" + filme.getIdFilme() + "'>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>" + idFilme +    			 		   "</FONT>" + "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='ator-nome'>" +                  	   "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='papel'>" +                		   "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='descricao' VALUE=>" + 			   "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='SUBMIT' VALUE='INCLUIR'>" +             		   "</TD>" +
						"</TR></FORM>" +
						"</TABLE>");
			
			//-------------------------------------------------------------------------------------------------------------------------------------------/
			out.println(//"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
    			        "<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
    			        
						"<TABLE style='width:100%' bgcolor='#CCCCCC'><TR><TH bgcolor='#333333'><FONT size='+1' color='#FFFFFF'>" + 
						"Novo Filme</font></TH></TR></TABLE>" +
						"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
					
						"<table bordercolor='#262626' border='1' style='width:100%' bgcolor='#333333'>" +
						"<TR>" +
			//			"<TD style='width:08%' bgcolor='#0099e6'>" + "<FONT size='4' color='#FFFFFF'>" + "ID FILME" +      "</FONT>" + "</TD>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "TITULO" +		   "</FONT>" + "</TH>" +
						"<TH style='width:15%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "TITULO INGLES" + "</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "ANO" + 		   "</FONT>" + "</TH>" +
						"<TH style='width:24%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "CATEGORIA" +     "</FONT>" + "</TH>" +
						"<TH style='width:30%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "PONTUACAO" +     "</FONT>" + "</TH>" +
						"<TH style='width:08%' bgcolor='#cccccc'>" + "<FONT size='4' color='#333333'>" + "INCLUIR" +       "</FONT>" + "</TH>" +
						"</TR>" +
						
						"<TR>" +
			//			"<TD>" + "<FONT size='4' color='#FFFFFF'>AUTOIMPLEMENTO" +  "</FONT>" + "</TD>" +
						"<FORM ACTION='admin-modifica-dados' method='GET'>" +
						"<INPUT TYPE='HIDDEN' NAME='tipo' VALUE='incluifilme'>" + 
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='titulo'>" +       "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='tituloingles'>" + "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='ano'>" + 		    "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='categoria'>" +    "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='TEXT' NAME='pontuacao'>" +    "</TD>" +
						"<TD>" + "<INPUT STYLE='width:100%' TYPE='SUBMIT' VALUE='incluir'>" +   "</TD>" +
						"</TR>" +
						"</TABLE>");
			
	    	out.println(//"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#800000'><TR><TH bgcolor='#800000'></TH></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#333333'><TR></TR></TABLE>" +
	    				"<TABLE style='width:100%' bgcolor='#262626'><TR><TH style='width:62%' bgcolor='#cccccc'><FONT color='#333333'>Kevin Yuji Kobori</FONT></TH>" +
	    				"<TH style='width:38%' bgcolor='#333333'><font size='+1' color='#FFFFFF'>UniCEUB</FONT></TH></TR></TABLE>");
			}		
%>
</FORM>
</BODY>
</HTML>