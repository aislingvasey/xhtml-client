package com.africaapps.xhtml;

import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.junit.Test;
import org.w3.x1999.xhtml.BodyDocument.Body;
import org.w3.x1999.xhtml.H1Document.H1;
import org.w3.x1999.xhtml.HeadDocument.Head;
import org.w3.x1999.xhtml.HtmlDocument;
import org.w3.x1999.xhtml.HtmlDocument.Html;
import org.w3.x1999.xhtml.MetaDocument.Meta;
import org.w3.x1999.xhtml.PDocument.P;
import org.w3.x1999.xhtml.TitleDocument.Title;

public class XhtmlClientTest {

//	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	//<!DOCTYPE root_element SYSTEM "DTD_location">
	
//	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
//  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	
	@Test
	public void createXhtmlPage() throws Exception {
		HtmlDocument htmlDocument = HtmlDocument.Factory.newInstance();
		
		XmlDocumentProperties props = htmlDocument.documentProperties();
	  props.setDoctypeSystemId( "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
	  props.setDoctypePublicId("-//W3C//DTD XHTML 1.0 Strict//EN");
	  props.setDoctypeName("html");
		
		Html html = htmlDocument.addNewHtml();
		
		Meta meta = Meta.Factory.newInstance();
		XmlAnySimpleType content = meta.addNewContent();
		content.setStringValue("text/html;charset=utf-8");
		XmlAnySimpleType equiv = meta.addNewHttpEquiv();
		equiv.setStringValue("content-type");
				
		Title title = Title.Factory.newInstance();
		XmlCursor cursor = title.newCursor();
		cursor.setTextValue("League Game");
		
		Head head = html.addNewHead();
		head.setTitle(title);
		head.setMetaArray(new Meta[] { meta });
		
		Body body = html.addNewBody();
		
		H1 h1 = body.addNewH1();	
		cursor = h1.newCursor();
    cursor.setTextValue("Hello!");
				
		P p = body.addNewP();
		cursor = p.newCursor();
    cursor.setTextValue("Here is some text...");
		
		System.out.println(htmlDocument.toString()); //as html 
//		htmlDocument.save(System.out); //as xml		 
	}
}
