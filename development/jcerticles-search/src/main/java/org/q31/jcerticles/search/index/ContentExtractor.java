/*
 * Project: jcerticles
 * Copyright(c) 2011 jcerticles
 * All rights reserved.
 *
 * $Revision $, last modified $Date $ by $Author $
 */
package org.q31.jcerticles.search.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

/**
 * This recursively scans the directory and extracts
 * the contents of all the files in it.
 * 
 * @author Jothi
 * @since  1.6
 */
public final class ContentExtractor {
	
	private static final int SUMMARY_LIMIT = 200;
	
	static char dirSep = System.getProperty("file.separator").charAt(0);
	
	static Set<String> textualMetadataFields = new HashSet<String>();
	static {
		textualMetadataFields.add(Metadata.TITLE);
		textualMetadataFields.add(Metadata.AUTHOR);
		textualMetadataFields.add(Metadata.COMMENTS);
		textualMetadataFields.add(Metadata.KEYWORDS);
		textualMetadataFields.add(Metadata.DESCRIPTION);
		textualMetadataFields.add(Metadata.SUBJECT);
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 * @throws Exception
	 */
	protected static Document getExtractedDocument(final File f) throws Exception {
		Document doc = new Document();
		
		Metadata metadata = new Metadata();
		metadata.set(Metadata.RESOURCE_NAME_KEY, f.getName());

		InputStream is = new FileInputStream(f);
		Parser parser = new AutoDetectParser();

		ContentHandler handler = new BodyContentHandler();
		ParseContext context = new ParseContext();
		context.set(Parser.class, parser);
		
		try {
			parser.parse(is, handler, metadata, context);
		} 
		finally {
			is.close();
		}
		
		System.out.println(" all text: " + handler.toString());
		
		/* Add the path field to the document */
	    doc.add(new Field("path", f.getPath().replace(dirSep, '/'), Field.Store.YES, Field.Index.NOT_ANALYZED));
		
		/* Index the contents */
		doc.add(new Field("contents", handler.toString(), Field.Store.NO, Field.Index.ANALYZED));
		
		/* Store and index the summary */
		doc.add(new Field("summary", handler.toString().substring(0, SUMMARY_LIMIT), Field.Store.YES, Field.Index.ANALYZED));
		
		/* Index the filenames */
		doc.add(new Field("filename", f.getCanonicalPath(),	Field.Store.YES, Field.Index.NOT_ANALYZED));

		for(String name : metadata.names()) {
			String value = metadata.get(name);
			
			if (textualMetadataFields.contains(name)) {
					doc.add(new Field("contents", value, Field.Store.YES, Field.Index.ANALYZED));
			}
			doc.add(new Field(name, value, Field.Store.YES, Field.Index.NO));
		}		
		return doc;		
	}
}